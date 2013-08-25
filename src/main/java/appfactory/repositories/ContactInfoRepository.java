package appfactory.repositories;

import appfactory.model.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: liweinan
 * Date: 13-8-25
 * Time: PM6:24
 * To change this template use File | Settings | File Templates.
 */
public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long> {
}
