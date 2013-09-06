package appfactory.dto.converters;

import appfactory.dto.CellData;
import appfactory.model.Cell;
import appfactory.repositories.PostCategoryRepository;
import appfactory.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: liweinan
 * Date: 13-9-1
 * Time: 下午3:18
 * To change this template use File | Settings | File Templates.
 */
public class CellDataPopulator implements Populator<Cell, CellData> {

    @Autowired
    private PostCategoryRepository postCategoryRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void populate(Cell cell, CellData result) {
        result.setId(cell.getId().toString());
        result.setOrder(cell.getOrder());
        result.setTitle(cell.getTitle());
        result.setIconURL(cell.getIconURL());

        String functionStr = cell.getFunctionCode();

        if (!functionStr.contains("/")) {
            result.setFunctionCode(cell.getFunctionCode());
        } else {
            result.setFunctionCode(functionStr.split("/")[0]);
            result.setFunctionId(functionStr.split("/")[1]);

            if ("POST_CATEGORY".equals(result.getFunctionCode())) {
                result.setFunctionIdDisplay(postCategoryRepository.findOne(Long.valueOf(result.getFunctionId())).getName());
            } else if ("POST".equals(result.getFunctionCode())) {
                result.setFunctionIdDisplay(postRepository.findOne(Long.valueOf(result.getFunctionId())).getTitle());
            }

        }
    }
}
