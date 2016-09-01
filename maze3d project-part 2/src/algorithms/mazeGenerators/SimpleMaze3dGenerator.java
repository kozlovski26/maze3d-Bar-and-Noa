package algorithms.mazeGenerators;

import java.util.Random;

/**
 * The Class SimpleMaze3dGenerator.
 * 
 * @author Bar and Noa
 *
 */
public class SimpleMaze3dGenerator extends Maze3dGeneratorAbstract {
	/** random rand **/
	private Random rand = new Random();

	/**
	 * choose random start position
	 * 
	 * @param maze
	 * @return the random start position
	 */
	private Position ChooseRandomStartPosition(Maze3d maze) {
		int[][][] mat = maze.getMaze_matrix();
		int x = rand.nextInt(maze.getRows() - 1);
		int y = rand.nextInt(maze.getColumns() - 1);
		int z = 0;

		while (mat[x][y][z] == Maze3d.getPass()) {
			x = rand.nextInt(maze.getRows() - 1);
			y = rand.nextInt(maze.getColumns() - 1);
			z = 0;
		}
		return new Position(x, y, z);
	}

	/**
	 * choose random goal position
	 * 
	 * @param maze
	 * @return the random goal position
	 */
	private Position ChooseRandomGoalPosition(Maze3d maze) {
		int[][][] mat = maze.getMaze_matrix();
		int x = rand.nextInt(maze.getRows() - 1);
		int y = rand.nextInt(maze.getColumns() - 1);
		int z = maze.getFloors() - 1;
		while (mat[x][y][z] == Maze3d.getPass()) {
			x = rand.nextInt(maze.getRows() - 1);
			y = rand.nextInt(maze.getColumns() - 1);
			z = maze.getFloors() - 1;
		}
		return new Position(x, y, z);
	}

	/**
	 * generate a simple maze
	 */
	@Override
	public Maze3d generate(int rows, int columns, int floors) {
		Maze3d maze = new Maze3d(rows, columns, floors);
		maze.RandomResetMaze();
		Position start, goal;
		start = ChooseRandomStartPosition(maze);
		goal = ChooseRandomGoalPosition(maze);
		maze.setStartPosition(start);
		maze.setGoalPosition(goal);
		maze.setPass(maze.getStartPosition().getX(), maze.getStartPosition().getY(), maze.getStartPosition().getZ());
		maze.setPass(maze.getGoalPosition().getX(), maze.getGoalPosition().getY(), maze.getGoalPosition().getZ());
		Position currentpos = new Position(start);

		while (currentpos.getX() < goal.getX()) {
			// run on floor
			while (currentpos.getZ() < goal.getZ()) {
				currentpos.setZ(currentpos.getZ() + 1);
				maze.setPass(currentpos.getX(), currentpos.getY(), currentpos.getZ());
			}
			// run on columns
			while (currentpos.getY() < goal.getY()) {
				currentpos.setY(currentpos.getY() + 1);
				maze.setPass(currentpos.getX(), currentpos.getY(), currentpos.getZ());
			}
			while (currentpos.getY() > goal.getY()) {
				currentpos.setY(currentpos.getY() - 1);
				maze.setPass(currentpos.getX(), currentpos.getY(), currentpos.getZ());
			}
			// run on rows
			while (currentpos.getX() < goal.getX()) {
				currentpos.setX(currentpos.getX() + 1);
				maze.setPass(currentpos.getX(), currentpos.getY(), currentpos.getZ());
			}
			while (currentpos.getX() > goal.getX()) {
				currentpos.setX(currentpos.getX() - 1);
				maze.setPass(currentpos.getX(), currentpos.getY(), currentpos.getZ());
			}

		}

		return maze;
	}



}
