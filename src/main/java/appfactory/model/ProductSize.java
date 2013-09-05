package appfactory.model;

import javax.persistence.Embeddable;

/**
 * Created with IntelliJ IDEA.
 * User: liweinan
 * Date: 13-9-5
 * Time: PM9:11
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
public class ProductSize {

    private String name;

    private String value;

    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
