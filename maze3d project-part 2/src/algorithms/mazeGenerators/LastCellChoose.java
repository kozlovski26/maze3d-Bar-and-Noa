package algorithms.mazeGenerators;

import java.util.List;

/**
 * The override of choose method by choosing last cell from the list
 * 
 * @author Bar and Noa
 *
 */
public class LastCellChoose extends CellChooseAbstract {

	public Position choose(List<Position> cells_list) {
		Position lastCell = cells_list.get(cells_list.size() - 1);

		return lastCell;
	}

}
