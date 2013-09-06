package appfactory.dto.converters;

/**
 * Created with IntelliJ IDEA.
 * User: wli
 * Date: 9/6/13
 * Time: 10:59 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Populator<SOURCE, TARGET> {

    void populate(SOURCE source, TARGET target);

}
