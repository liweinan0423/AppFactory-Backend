package appfactory.services;

import appfactory.model.ProductCategory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: liweinan
 * Date: 13-9-3
 * Time: PM9:02
 * To change this template use File | Settings | File Templates.
 */
public interface ProductService {

    public void createCategory(ProductCategory category, MultipartFile icon, String uploadDir) throws IOException;

}
