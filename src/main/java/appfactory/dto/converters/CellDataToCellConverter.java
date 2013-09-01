package appfactory.dto.converters;

import appfactory.dto.CellData;
import appfactory.model.Cell;
import appfactory.repositories.MenuPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: liweinan
 * Date: 13-9-1
 * Time: 下午4:19
 * To change this template use File | Settings | File Templates.
 */
@Component("cellDataToCellConverter")
public class CellDataToCellConverter implements Converter<CellData, Cell> {

    @Autowired
    private MenuPageRepository menuPageRepository;

    @Override
    public Cell convert(CellData cellData) {
        Cell cell = new Cell();
        if (cellData.getId() != null) {
            cell.setId(Long.valueOf(cellData.getId()));
        }
        cell.setTitle(cellData.getTitle());
        cell.setIconURL(cellData.getIconURL());
        cell.setOrder(cellData.getOrder());
        if (StringUtils.isEmpty(cellData.getFunctionId())) {
            cell.setFunctionCode(cellData.getFunctionCode());
        } else {
            cell.setFunctionCode(cellData.getFunctionCode() + "/" + cellData.getFunctionId());
        }


        cell.setMenuPage(menuPageRepository.findDefaultMenuPage());
        return cell;
    }
}
