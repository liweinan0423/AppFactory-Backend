package appfactory.services;

import appfactory.dto.ProductData;
import appfactory.dto.converters.Populator;
import appfactory.model.Product;
import appfactory.model.ProductCategory;
import appfactory.repositories.ProductCategoryRepository;
import appfactory.repositories.ProductRepository;
import appfactory.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    @Qualifier("productDataConverter")
    private Populator<ProductData, Product> productPopulator;

    @Override
    public void createCategory(ProductCategory category, MultipartFile icon, String webRootDirPath) throws IOException {
        String fileName = FileUploadUtils.generateUUIDFileNameAndSaveFile(icon, webRootDirPath + "/upload");

        category.setIconURL("/upload/" + fileName);

        productCategoryRepository.save(category);

    }

    @Override
    public void createProduct(ProductData productData) {
        Product product = new Product();
        productPopulator.populate(productData, product);

        productRepository.save(product);
    }
}
