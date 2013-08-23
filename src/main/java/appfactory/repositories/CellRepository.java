package appfactory.repositories;

import appfactory.model.Cell;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: wli
 * Date: 8/23/13
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
public interface CellRepository extends JpaRepository<Cell, Long> {
}
