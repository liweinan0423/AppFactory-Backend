package appfactory.dto.converters;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wli
 * Date: 9/6/13
 * Time: 11:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class CombinationPopulator<SOURCE, TARGET> implements Populator<SOURCE, TARGET> {

    private List<Populator<SOURCE, TARGET>> populators;


    public List<Populator<SOURCE, TARGET>> getPopulators() {
        return populators;
    }

    public void setPopulators(List<Populator<SOURCE, TARGET>> populators) {
        this.populators = populators;
    }

    @Override
    public void populate(SOURCE source, TARGET target) {
        if (populators != null) {
            for (Populator<SOURCE, TARGET> populator: populators) {
                populator.populate(source, target);
            }
        }
    }
}
