package appfactory.services;

import appfactory.model.ProductCategory;
import appfactory.repositories.ProductCategoryRepository;
import appfactory.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: liweinan
 * Date: 13-9-3
 * Time: PM9:03
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DefaultProductService implements ProductService {


    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public void createCategory(ProductCategory category, MultipartFile icon, String webRootDirPath) throws IOException {
        String fileName = FileUploadUtils.generateUUIDFileNameAndSaveFile(icon, webRootDirPath + "/upload");

        category.setIconURL("/upload/" + fileName);

        productCategoryRepository.save(category);

    }
}
