package appfactory.dto.converters;

import appfactory.dto.ProductData;
import appfactory.model.Product;
import appfactory.model.ProductImage;
import appfactory.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: wli
 * Date: 9/6/13
 * Time: 10:46 AM
 * To change this template use File | Settings | File Templates.
 */
@Component("productDataConverter")
public class ProductDataConverter implements Populator<ProductData, Product> {

    @Autowired
    private ServletContext servletContext;


    @Override
    public void populate(ProductData source, Product product) {
        product.setId(source.getId());
        product.setName(source.getName());
        product.setDesc(source.getDesc());

        ProductImage primaryImage = new ProductImage();
        primaryImage.setPrimary(true);
        primaryImage.setName(source.getPrimaryImage().getOriginalFilename());

        try {
            String uuidFileName = FileUploadUtils.generateUUIDFileNameAndSaveFile(source.getPrimaryImage(), servletContext.getRealPath("/upload"));
            primaryImage.setUrl("/upload/" + uuidFileName);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        for (MultipartFile file : source.getOtherImages()) {
        }
    }
}
