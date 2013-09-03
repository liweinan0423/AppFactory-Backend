package appfactory.repositories;

import appfactory.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: liweinan
 * Date: 13-9-3
 * Time: PM8:38
 * To change this template use File | Settings | File Templates.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
