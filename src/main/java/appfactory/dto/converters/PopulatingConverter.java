package appfactory.dto.converters;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wli
 * Date: 9/6/13
 * Time: 11:01 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class PopulatingConverter<SOURCE, TARGET> {

    private List<Populator<SOURCE, TARGET>> populators;


    public List<Populator<SOURCE, TARGET>> getPopulators() {
        return populators;
    }

    public void setPopulators(List<Populator<SOURCE, TARGET>> populators) {
        this.populators = populators;
    }


    public abstract void convert(SOURCE source, TARGET target);
}
