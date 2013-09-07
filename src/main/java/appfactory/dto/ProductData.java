package appfactory.dto;

import appfactory.model.ProductCategory;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liweinan
 * Date: 13-9-5
 * Time: PM10:03
 * To change this template use File | Settings | File Templates.
 */
public class ProductData {

    private Long id;
    private String name;
    private String desc;
    private ProductCategory category;

    private MultipartFile primaryImage;

    private List<MultipartFile> otherImages;

    public MultipartFile getPrimaryImage() {
        return primaryImage;
    }

    public void setPrimaryImage(MultipartFile primaryImage) {
        this.primaryImage = primaryImage;
    }

    public List<MultipartFile> getOtherImages() {
        return otherImages;
    }

    public void setOtherImages(List<MultipartFile> otherImages) {
        this.otherImages = otherImages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
