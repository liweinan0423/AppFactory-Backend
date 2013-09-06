package appfactory.services;

import appfactory.dto.CellData;
import appfactory.model.Cell;
import appfactory.model.MenuPage;
import appfactory.repositories.CellRepository;
import appfactory.repositories.MenuPageRepository;
import appfactory.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wli
 * Date: 8/23/13
 * Time: 4:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class AppConfigServiceImpl implements AppConfigService {

    @Autowired
    private MenuPageRepository menuPageRepository;

    @Autowired
    private CellRepository cellRepository;

    @Override
    public void addCellToMenuPage(Cell cell, MultipartFile icon, String webRootDirPath) throws IOException {

        MenuPage menuPage = menuPageRepository.findDefaultMenuPage();

        String fileName = FileUploadUtils.generateUUIDFileNameAndSaveFile(icon, webRootDirPath + "/upload");

        cell.setIconURL("/upload/" + fileName);
        cell.setMenuPage(menuPage);

        cellRepository.save(cell);
    }
}
