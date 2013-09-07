package appfactory.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductCategory extends BaseEntity {

    @NotBlank
    private String name;

    private String iconURL;

    private String desc;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent", cascade = CascadeType.ALL)
    private List<ProductCategory> children;

    @ManyToOne
    private ProductCategory parent;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<ProductCategory> getChildren() {
        return children;
    }

    public void setChildren(List<ProductCategory> children) {
        this.children = children;
    }

    public ProductCategory getParent() {
        return parent;
    }

    public void setParent(ProductCategory parent) {
        this.parent = parent;
    }
}
