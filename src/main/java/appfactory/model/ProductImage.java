package appfactory.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created with IntelliJ IDEA.
 * User: liweinan
 * Date: 13-9-5
 * Time: PM9:08
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
public class ProductImage {

    private String url;

    private String name;

    @Column(name = "IS_PRIMARY")
    private boolean primary;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }
}
