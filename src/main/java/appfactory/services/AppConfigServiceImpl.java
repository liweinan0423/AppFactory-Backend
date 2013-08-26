package appfactory.services;

import appfactory.dto.CellData;
import appfactory.model.Cell;
import appfactory.model.MenuPage;
import appfactory.repositories.CellRepository;
import appfactory.repositories.MenuPageRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
    public void addCellToMenuPage(Cell cell, MultipartFile icon, String uploadDirPath) throws IOException {

        MenuPage menuPage = menuPageRepository.findDefaultMenuPage();

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");


        String fileExtension = icon.getOriginalFilename().split("\\.")[1];

        String fileName = uuid + "." + fileExtension;

        FileUtils.copyInputStreamToFile(icon.getInputStream(), new File(uploadDirPath, fileName));


        cell.setIconURL("/upload/" + fileName);
        cell.setMenuPage(menuPage);

        cellRepository.save(cell);
    }

    @Override
    public List<CellData> getCells() {
        MenuPage menuPage = menuPageRepository.findDefaultMenuPage();
        for (Cell cell : menuPage.getCells()) {

        }

        return null;
    }
}
