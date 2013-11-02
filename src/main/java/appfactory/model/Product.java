package appfactory.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liweinan
 * Date: 13-9-5
 * Time: PM9:06
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Product extends BaseEntity {

    private String name;

    @Lob
    private String desc;

    @ManyToOne
    private ProductCategory category;

    @ElementCollection
    private List<ProductImage> productImages;

    @ElementCollection
    private List<ProductSize> sizes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public ProductImage getPrimaryImage() {
        for (ProductImage image : productImages) {
            if (image.isPrimary()) {
                return image;
            }
        }

        return null;
    }


    public void addProductImage(ProductImage image) {
        if (productImages == null) {
            productImages = new ArrayList<ProductImage>();
        }

        productImages.add(image);
    }

    public void addSize(ProductSize size) {
        if (this.sizes == null) {
            sizes = new ArrayList<ProductSize>();
        }

        sizes.add(size);
    }
}
