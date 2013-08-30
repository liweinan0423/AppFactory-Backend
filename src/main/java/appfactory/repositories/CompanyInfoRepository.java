package appfactory.repositories;

import appfactory.model.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created with IntelliJ IDEA.
 * User: liweinan
 * Date: 13-8-30
 * Time: PM8:25
 * To change this template use File | Settings | File Templates.
 */
public interface CompanyInfoRepository extends JpaRepository<CompanyInfo, Long> {

    @Query("select info from CompanyInfo as info where id=-1")
    CompanyInfo findCompanyInfo();
}
