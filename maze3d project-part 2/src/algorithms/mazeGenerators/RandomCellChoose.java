package algorithms.mazeGenerators;

import java.util.List;

/**
 * The override of choose method by choosing random cell from the list
 * 
 * @author Bar and Noa
 *
 */
public class RandomCellChoose extends CellChooseAbstract {

	@Override
	public Position choose(List<Position> cells_list) {
		int index = rand.nextInt(cells_list.size());
		Position randomCell = cells_list.get(index);

		return randomCell;
	}

}
