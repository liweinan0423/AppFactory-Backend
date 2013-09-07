package appfactory.dto.converters;

import appfactory.dto.ProductData;
import appfactory.model.Product;
import appfactory.model.ProductImage;
import appfactory.repositories.ProductCategoryRepository;
import appfactory.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ProductPopulator implements Populator<ProductData, Product> {

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;


    @Override
    public void populate(ProductData source, Product product) {
        product.setId(source.getId());
        product.setName(source.getName());
        product.setDesc(source.getDesc());

        ProductImage primaryImage = new ProductImage();
        primaryImage.setPrimary(true);
        primaryImage.setName(source.getPrimaryImage().getOriginalFilename());

        product.setCategory(productCategoryRepository.findOne(source.getCategory().getId()));

        try {
            String uuidFileName = FileUploadUtils.generateUUIDFileNameAndSaveFile(source.getPrimaryImage(), servletContext.getRealPath("/upload"));
            primaryImage.setUrl("/upload/" + uuidFileName);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        product.addProductImage(primaryImage);

        for (MultipartFile file : source.getOtherImages()) {

            ProductImage productImage = new ProductImage();
            productImage.setName(file.getOriginalFilename());
            productImage.setPrimary(false);

            try {
                String uuidFileName = FileUploadUtils.generateUUIDFileNameAndSaveFile(file, servletContext.getRealPath("/upload"));
                productImage.setUrl("/upload/" + uuidFileName);
                product.addProductImage(productImage);
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

        }
    }
}
