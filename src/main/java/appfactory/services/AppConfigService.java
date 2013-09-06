package appfactory.services;

import appfactory.dto.CellData;
import appfactory.model.Cell;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wli
 * Date: 8/23/13
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AppConfigService {

    public void addCellToMenuPage(Cell cell, MultipartFile icon, String uploadDirPath) throws IOException;

}
