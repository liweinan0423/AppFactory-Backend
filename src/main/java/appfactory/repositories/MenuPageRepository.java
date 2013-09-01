package appfactory.repositories;

import appfactory.model.MenuPage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 * User: wli
 * Date: 8/23/13
 * Time: 11:11 AM
 * To change this template use File | Settings | File Templates.
 */
public interface MenuPageRepository extends CrudRepository<MenuPage, Long> {


    @Query("select page from MenuPage as page where page.id=-1")
    public MenuPage findDefaultMenuPage();


}
