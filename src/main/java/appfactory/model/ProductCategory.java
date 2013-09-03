package appfactory.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;

@Entity
public class ProductCategory extends BaseEntity {

    @NotBlank
    private String name;

    @NotBlank
    private String iconURL;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }
}
