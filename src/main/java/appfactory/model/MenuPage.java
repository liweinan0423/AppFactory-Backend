package appfactory.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wli
 * Date: 8/23/13
 * Time: 10:55 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class MenuPage {

    @Id
    private Long id;

    private LayoutType layoutType;

    @OneToMany(mappedBy = "menuPage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("order")
    private List<Cell> cells;

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public LayoutType getLayoutType() {
        return layoutType;
    }

    public void setLayoutType(LayoutType layoutType) {
        this.layoutType = layoutType;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
