package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The class GrowingTreeGenerator.
 * 
 * @author Bar and Noa
 *
 */
public class GrowingTreeGenerator extends Maze3dGeneratorAbstract {
	/** Variables */
	public CellChoose cellChoose;
	public Random rand = new Random();

	/**
	 * ctor of the growing tree generator class
	 * 
	 * @param ch
	 */
	public GrowingTreeGenerator(CellChoose ch) {
		this.cellChoose = ch;
	}

	/**
	 * choose random position
	 * 
	 * @param maze
	 * @return random position
	 */
	private Position ChooseRandomPositon(Maze3d maze) {
		int x = rand.nextInt(maze.getRows());
		while (x % 2 != 0)
			x = rand.nextInt(maze.getRows());
		int y = rand.nextInt(maze.getColumns());
		while (y % 2 != 0)
			y = rand.nextInt(maze.getColumns());
		int z = rand.nextInt(maze.getFloors());
		while (z % 2 != 0)
			z = rand.nextInt(maze.getFloors());

		return new Position(x, y, z);

	}

	/** generate the maze by growing tree generator algorithms */

	@Override
	public Maze3d generate(int rows, int columns, int floors) {

		/** creates new maze **/
		Maze3d maze = new Maze3d(rows, columns, floors);
		/** reset all the maze with walls **/
		maze.ResetMaze();
		/** choose random start position and puts pass(0) **/
		Position startPos = ChooseRandomPositon(maze);
		startPos.setZ(0);
		maze.setStartPosition(startPos);
		maze.setPass(maze.getStartPosition().getX(), maze.getStartPosition().getY(), maze.getStartPosition().getZ());
		GrowingTreeGenerator(maze);
		Position goalPosition = chooseRandomGoalPosition(maze);
		maze.setGoalPosition(goalPosition);

		return maze;
	}

	private void GrowingTreeGenerator(Maze3d maze) {

		/** arraylist of positions **/
		List<Position> cells = new ArrayList<Position>();
		/** add to the cells array list the start pos **/
		cells.add(maze.getStartPosition());
		while (!(cells.isEmpty())) {

			Position pos = new Position();
			pos = cellChoose.choose(cells);
			List<Position> neighbors = new ArrayList<Position>();
			neighbors = FindUnvistedNeighbors(maze, pos);

			if (!neighbors.isEmpty()) {
				Position neighbor = new Position(cellChoose.choose(neighbors));
				CarvePassBatweenCells(maze, pos, neighbor);
				cells.add(neighbor);
			} else {
				cells.remove(pos);

			}
		}

	}

	/**
	 * choose random goal position
	 * 
	 * @param maze
	 * @return the goal position
	 */
	private Position chooseRandomGoalPosition(Maze3d maze) {
		int[][][] mat = maze.getMaze_matrix();

		int x = rand.nextInt(maze.getRows());
		int y = rand.nextInt(maze.getColumns());
		int z = rand.nextInt(maze.getFloors());
		while (mat[x][y][z] == Maze3d.getWall()) {
			x = rand.nextInt(maze.getRows());
			y = rand.nextInt(maze.getColumns());
			z = rand.nextInt(maze.getFloors());
		}
		return new Position(x, y, maze.getFloors() -1);
	}

	/**
	 * crave a pass between cells
	 * 
	 * @param maze
	 * @param pos
	 * @param neighbor
	 */
	private void CarvePassBatweenCells(Maze3d maze, Position pos, Position neighbor) {
		if (neighbor.getX() == pos.getX() + 2) {
			maze.setPass((pos.getX() + 1), pos.getY(), pos.getZ());
			maze.setPass((pos.getX() + 2), pos.getY(), pos.getZ());
		} else if (neighbor.getX() == pos.getX() - 2) {
			maze.setPass((pos.getX() - 1), pos.getY(), pos.getZ());
			maze.setPass((pos.getX() - 2), pos.getY(), pos.getZ());
		} else if (neighbor.getY() == pos.getY() + 2) {
			maze.setPass(pos.getX(), (pos.getY() + 1), pos.getZ());
			maze.setPass(pos.getX(), (pos.getY() + 2), pos.getZ());
		} else if (neighbor.getY() == pos.getY() - 2) {
			maze.setPass(pos.getX(), (pos.getY() - 1), pos.getZ());
			maze.setPass(pos.getX(), (pos.getY() - 2), pos.getZ());
		} else if (neighbor.getZ() == pos.getZ() + 2) {
			maze.setPass(pos.getX(), pos.getY(), (pos.getZ() + 1));
			maze.setPass(pos.getX(), pos.getY(), (pos.getZ() + 2));
		} else if (neighbor.getZ() == pos.getZ() - 2) {
			maze.setPass(pos.getX(), pos.getY(), (pos.getZ() - 2));
			maze.setPass(pos.getX(), pos.getY(), (pos.getZ() - 1));
		}

	}

	/**
	 * find the unvisited neighbors in the maze position
	 * 
	 * @param maze
	 * @param pos
	 * @return a list of unvisited neighbors
	 */
	private List<Position> FindUnvistedNeighbors(Maze3d maze, Position pos) {

		List<Position> neighbors = new ArrayList<Position>();
		int[][][] mat = maze.getMaze_matrix();
		if (pos.getX() - 2 >= 0 && mat[pos.getX() - 2][pos.getY()][pos.getZ()] == Maze3d.getWall()) {
			neighbors.add(new Position(pos.getX() - 2, pos.getY(), pos.getZ()));
		}
		if (pos.getX() + 2 < maze.getRows() && mat[pos.getX() + 2][pos.getY()][pos.getZ()] == Maze3d.getWall()) {
			neighbors.add(new Position(pos.getX() + 2, pos.getY(), pos.getZ()));
		}
		if (pos.getY() - 2 >= 0 && mat[pos.getX()][pos.getY() - 2][pos.getZ()] == Maze3d.getWall()) {
			neighbors.add(new Position(pos.getX(), pos.getY() - 2, pos.getZ()));
		}
		if (pos.getY() + 2 < maze.getColumns() && mat[pos.getX()][pos.getY() + 2][pos.getZ()] == Maze3d.getWall()) {
			neighbors.add(new Position(pos.getX(), pos.getY() + 2, pos.getZ()));
		}
		if (pos.getZ() - 2 >= 0 && mat[pos.getX()][pos.getY()][pos.getZ() - 2] == Maze3d.getWall()) {
			neighbors.add(new Position(pos.getX(), pos.getY(), pos.getZ() - 2));
		}
		if (pos.getZ() + 2 < maze.getFloors() && mat[pos.getX()][pos.getY()][pos.getZ() + 2] == Maze3d.getWall()) {
			neighbors.add(new Position(pos.getX(), pos.getY(), pos.getZ() + 2));
		}

		return neighbors;

	}

}
