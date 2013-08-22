package appfactory.repositories;

import appfactory.model.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: wli
 * Date: 8/22/13
 * Time: 10:49 AM
 * To change this template use File | Settings | File Templates.
 */
public interface PostCategoryRepository extends JpaRepository<PostCategory, Long> {
}
