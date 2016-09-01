package algorithms.mazeGenerators;

import java.util.List;
import java.util.Random;
/**
 * The class CellChooseAbstract
 * @author Bar and Noa
 *
 */
public abstract class CellChooseAbstract implements CellChoose {
	/** Variables **/
	Maze3d maze3d;
	List<Position> ArrayPosition;
	public Random rand = new Random();

	/** the abstract method choose*/
	@Override
	public abstract Position choose(List<Position> cells_list);

}
