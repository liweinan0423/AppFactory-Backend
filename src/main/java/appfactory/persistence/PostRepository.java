package appfactory.persistence;

import appfactory.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: wli
 * Date: 8/21/13
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PostRepository extends JpaRepository<Post, Long> {

    public Page<Post> findAll(Pageable pageable);

}
