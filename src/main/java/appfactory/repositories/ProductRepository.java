package appfactory.repositories;

import appfactory.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: liweinan
 * Date: 13-9-5
 * Time: PM9:40
 * To change this template use File | Settings | File Templates.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
