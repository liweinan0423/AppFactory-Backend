package appfactory.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Created with IntelliJ IDEA.
 * User: liweinan
 * Date: 13-8-25
 * Time: PM6:22
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class ContactInfo extends BaseEntity {

    private String phoneName;

    private String phoneNumber;

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
