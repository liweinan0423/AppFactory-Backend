package appfactory.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: wli
 * Date: 8/30/13
 * Time: 5:08 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class CompanyInfo {


    private Long id;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
