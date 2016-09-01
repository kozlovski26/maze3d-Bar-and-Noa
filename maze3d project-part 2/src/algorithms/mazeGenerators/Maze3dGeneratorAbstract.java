package algorithms.mazeGenerators;
/**
 *  The class Maze3dGeneratorAbstract
 * @author Bar and Noa
 *
 */
public abstract class Maze3dGeneratorAbstract implements Maze3dGenerator {

	/**
	 * abstract generate method
	 */
	public abstract Maze3d generate(int rows, int columns, int floors);

	/**
	 * measure algorithm time of all algorithm that create maze
	 */
	@Override
	public String measureAlgorithmTime(int rows, int columns, int floors) {
		long startTime = System.currentTimeMillis();
		generate(rows, columns, floors);
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		return String.valueOf(duration);

	}

}