package algorithms.mazeGenerators;

/**
 * The interface Maze3dGenerator
 * 
 * @author Bar and Noa
 *
 */
public interface Maze3dGenerator {
	/**
	 * Generate
	 * 
	 * @param rows
	 * @param columns
	 * @param floors
	 * @return the Maze3d
	 */
	Maze3d generate(int rows, int columns, int floors);

	/**
	 * measure algorithm time
	 * 
	 * @param rows
	 * @param columns
	 * @param floors
	 * @return the String
	 */
	String measureAlgorithmTime(int rows, int columns, int floors);

}
