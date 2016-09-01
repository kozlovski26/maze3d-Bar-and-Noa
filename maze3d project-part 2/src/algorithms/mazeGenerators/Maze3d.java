package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;

/**
 * The Class Maze3d
 *
 * @author Bar and Noa
 */
public class Maze3d {

	/** Variables of the maze [rows][columns][floors] */

	int rows;
	int columns;
	int floors;

	/** The maze3d that created by int[][][]. */
	int[][][] maze_matrix;

	/** The start position. */
	private Position StartPosition;

	/** The goal position. */
	private Position GoalPosition;

	/**
	 * Gets the maze3d.
	 *
	 * @return the maze3d
	 */
	public int[][][] getMaze_matrix() {
		return maze_matrix;
	}

	/**
	 * Sets the maze3d
	 * 
	 * @param maze_matrix
	 */
	public void setMaze_matrix(int[][][] maze_matrix) {
		this.maze_matrix = maze_matrix;
	}

	/** The Constant PASS=0 in the maze. */
	private static final int Pass = 0;
	/** The Constant WALL=1 in the maze. */
	private static final int Wall = 1;

	/**
	 * get the rows of the maze
	 * 
	 * @return rows
	 */
	public int getRows() {

		return rows;
	}

	/**
	 * get the columns of the maze
	 * 
	 * @return columns
	 */
	public int getColumns() {
		return columns;
	}

	/**
	 * get the floors of the maze
	 * 
	 * @return floors
	 */
	public int getFloors() {
		return floors;
	}

	/** @return Pass=0 **/
	public static int getPass() {
		return Pass;
	}

	/** @return Wall=1 **/
	public static int getWall() {
		return Wall;
	}

	/**
	 * get value of maze position
	 * 
	 * @param pos
	 * @return value of the position
	 */
	public int getValue(Position pos) {
		int val = this.maze_matrix[pos.getX()][pos.getY()][pos.getZ()];

		return val;
	}

	/**
	 * set value in maze position
	 * 
	 * @param pos
	 * @param value
	 */
	public void setValue(Position pos, int value) {
		maze_matrix[pos.getX()][pos.getY()][pos.getZ()] = value;

	}

	/**
	 * Gets the start position.
	 *
	 * @return the start position
	 */
	public Position getStartPosition() {
		return StartPosition;
	}

	/**
	 * Gets the goal position.
	 *
	 * @return the goal position
	 */
	public Position getGoalPosition() {
		return GoalPosition;
	}

	/**
	 * set the rows in the maze3d
	 * 
	 * @param rows
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * set the columns in the maze3d
	 * 
	 * @param columns
	 */
	public void setColumns(int columns) {
		this.columns = columns;
	}

	/**
	 * set the floors in the maze3d
	 * 
	 * @param floors
	 */
	public void setFloors(int floors) {
		this.floors = floors;
	}

	/**
	 * set a wall in a current position
	 * 
	 * @param int
	 *            x-rows
	 * @param int
	 *            y-columns
	 * @param int
	 *            z-floors
	 */
	public void setWall(int x, int y, int z) {
		maze_matrix[x][y][z] = Wall;
	}

	/**
	 * set a pass in a current position
	 * 
	 * @param int
	 *            x-rows
	 * @param int
	 *            y-columns
	 * @param int
	 *            z-floors
	 */
	public void setPass(int x, int y, int z) {
		maze_matrix[x][y][z] = Pass;
	}

	/**
	 * Sets the start position.
	 *
	 * @return the start position
	 */
	public void setStartPosition(Position startPosition) {
		this.StartPosition = startPosition;
	}

	/**
	 * Sets the goal position.
	 *
	 * @return the goal position
	 */
	public void setGoalPosition(Position goalPosition) {
		this.GoalPosition = goalPosition;
	}

	/**
	 * Ctor of the maze,to create a nes maze we need to put the maze Variables:
	 * Maze3d maze3d=new Maze3d(rows,columns,floors); and we will get a new
	 * maze3d/
	 * 
	 * @param rows
	 * @param columns
	 * @param floors
	 */
	public Maze3d(int rows, int columns, int floors) {
		this.rows = rows;
		this.columns = columns;
		this.floors = floors;
		this.maze_matrix = new int[this.rows][this.columns][this.floors];

	}

	/** reset all maze with random walls **/
	public void RandomResetMaze() {
		Random rand = new Random();
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getColumns(); j++) {
				for (int k = 0; k < getFloors(); k++) {
					getMaze_matrix()[i][j][k] = rand.nextInt(Maze3d.getWall() + 1);

				}
			}
		}

	}

	/** reset all maze with walls **/

	public void ResetMaze() {
		for (int i = 0; i < maze_matrix.length; i++) {
			for (int j = 0; j < maze_matrix[0].length; j++) {
				for (int k = 0; k < maze_matrix[0][0].length; k++) {
					getMaze_matrix()[i][j][k] = Wall;
				}
			}
		}

	}

	/**
	 * Create the maze with String
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(" ");
		for (int i = 0; i < floors; i++) {
			for (int j = 0; j < rows; j++) {
				for (int k = 0; k < columns; k++) {

					sb.append(maze_matrix[j][k][i] + " ");
				}

				sb.append("\n ");
			}

			sb.append("\n ");

		}

		return sb.toString();
	}

	/**
	 * Gets the cross section by z cross the maze by rows
	 * 
	 * @param int
	 *            num(floor)
	 * 
	 * @return the cross section by z int[]
	 */
	public int[][] getCrossSectionByZ(int num) throws IndexOutOfBoundsException {
		// checking if there are exception
		if (num < 0 || num >= maze_matrix[0].length)
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
		else {
			// create maze2d
			int[][] mazeByZ = new int[this.maze_matrix.length][this.maze_matrix[0].length];
			for (int i = 0; i < mazeByZ.length; i++) {
				for (int j = 0; j < mazeByZ[0].length; j++) {
					mazeByZ[i][j] = maze_matrix[i][j][num];
				}
			}
			return mazeByZ;

		}

	}

	/**
	 * Gets the cross section by y cross the maze by rows
	 * 
	 * @param int
	 *            num(column)
	 * 
	 * @return the cross section by y int[]
	 */
	public int[][] getCrossSectionByY(int num) throws IndexOutOfBoundsException {
		// checking if there are exception
		if (num < 0 || num >= maze_matrix[0].length)
			throw new IndexOutOfBoundsException("Index Out Of Bounds Exception");

		else {

			// create maze2d
			int[][] mazeByY = new int[this.maze_matrix.length][this.maze_matrix[0][0].length];
			for (int i = 0; i < mazeByY.length; i++) {
				for (int j = 0; j < mazeByY[0].length; j++) {
					mazeByY[i][j] = maze_matrix[i][num][j];
				}
			}
			return mazeByY;

		}
	}

	/**
	 * Gets the cross section by x cross the maze by rows
	 * 
	 * @param int
	 *            num(row)
	 * 
	 * @return the cross section by x int[]
	 */
	public int[][] getCrossSectionByX(int num) throws IndexOutOfBoundsException {
		// checking if there are exception
		if (num < 0 || num >= maze_matrix.length)
			throw new IndexOutOfBoundsException("Index Out Of Bounds Exception");

		else {

			// create maze2d
			int[][] mazeByX = new int[this.maze_matrix[0].length][this.maze_matrix[0][0].length];
			for (int i = 0; i < mazeByX.length; i++) {
				for (int j = 0; j < mazeByX[0].length; j++) {
					mazeByX[i][j] = maze_matrix[num][i][j];
				}
			}
			return mazeByX;

		}
	}

	/**
	 * Gets the possible moves directions
	 *
	 * @param pos
	 * @return the possible moves directions
	 */
	public Directions[] getPossibleDirections(Position pos) {
		ArrayList<Directions> directions = new ArrayList<Directions>();
		if (pos.x + 1 < getRows() && maze_matrix[pos.x + 1][pos.y][pos.z] == Pass)
			directions.add(Directions.FORWARD);
		if (pos.x - 1 >= 0 && maze_matrix[pos.x - 1][pos.y][pos.z] == Pass)
			directions.add(Directions.BACKWARD);
		if (pos.y + 1 < getColumns() && maze_matrix[pos.x][pos.y + 1][pos.z] == Pass)
			directions.add(Directions.RIGHT);
		if (pos.y - 1 >= 0 && maze_matrix[pos.x][pos.y - 1][pos.z] == Pass)
			directions.add(Directions.LEFT);
		if (pos.z - 1 >= 0 && maze_matrix[pos.x][pos.y][pos.z - 1] == Pass)
			directions.add(Directions.DOWN);
		if (pos.z + 1 < getFloors() && maze_matrix[pos.x][pos.y][pos.z + 1] == Pass)
			directions.add(Directions.UP);

		Directions[] arr = new Directions[directions.size()];
		directions.toArray(arr);
		return arr;
	}

	/**
	 * Method that check if the cell is out of bound
	 * 
	 * @param pos
	 * @return boolean
	 */
	public boolean isCellInBound(Position pos) {
		int temp;
		temp = maze_matrix.length;
		if (pos.x < 0 || temp - 1 < pos.x)
			return false;
		temp = maze_matrix[0].length;
		if (pos.y < 0 || temp - 1 < pos.y)
			return false;
		temp = maze_matrix[0][0].length;
		if (pos.z < 0 || temp - 1 < pos.z)
			return false;

		return true;
	}

	/**
	 * Gets the possible moves.
	 *
	 * @param pos
	 * @return the possible moves
	 */
	public String[] getPossibleMoves(Position pos) {
		ArrayList<Directions> dirs = new ArrayList<Directions>();
		int[][][] m = maze_matrix;

		// Check left neighbor
		if (isCellInBound(pos) && (pos.getY() - 1) >= 0 && m[pos.getX()][pos.getY() - 1][pos.getZ()] == Maze3d.Pass) {
			dirs.add(Directions.LEFT);
		}

		// Check right neighbor
		if (isCellInBound(pos) && (pos.getY() + 1) < getColumns()
				&& m[pos.getX()][pos.getY() + 1][pos.getZ()] == Maze3d.Pass) {
			dirs.add(Directions.RIGHT);
		}

		// Check FORWARD neighbor

		if (isCellInBound(pos) && (pos.getX() + 1) < getRows()
				&& m[pos.getX() + 1][pos.getY()][pos.getZ()] == Maze3d.Pass) {
			dirs.add(Directions.FORWARD);
		}

		// Check BACKWARDS neighbor
		if (isCellInBound(pos) && (pos.getX() - 1) >= 0 && m[(pos.getX() - 1)][pos.getY()][pos.getZ()] == Maze3d.Pass) {
			dirs.add(Directions.BACKWARD);
		}
		// Check UP neighbor
		if (isCellInBound(pos) && (pos.getZ() + 1) < getFloors()
				&& m[pos.getX()][pos.getY()][pos.getZ() + 1] == Maze3d.Pass) {
			dirs.add(Directions.UP);
		}
		// Check DOWN neighbor
		if (isCellInBound(pos) && (pos.getZ() - 1) >= 0 && m[pos.getX()][pos.getY()][pos.getZ() - 1] == Maze3d.Pass) {
			dirs.add(Directions.DOWN);
		}
		int sum = dirs.size();
		String[] temp = new String[sum];

		int i = 0;
		while (dirs.size() != 0) {
			temp[i] = dirs.get(0).toString();
			i++;
			dirs.remove(0);
		}
		return temp;
	}

	/**
	 * override equals method of objects class. this method equals between two
	 * 3d mazes and return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		Maze3d tomaze = (Maze3d) obj;
		if (this.rows == tomaze.getRows() && this.columns == tomaze.getColumns() && this.floors == tomaze.getFloors()) {
			for (int i = 0; i < this.rows; i++) {
				for (int j = 0; j < this.columns; j++) {
					for (int k = 0; k < this.floors; k++) {
						if (this.maze_matrix[i][j][k] != tomaze.getValue(new Position(i, j, k))) {
							return false;
						}
					}
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Prints the maze cross.
	 * 
	 * @param arr
	 *            the int arr[][] of the maze
	 */
	public void PrintMazeCross(int arr[][]) {
		String s = new String();
		for (int j = 0; j < arr.length; j++) {
			for (int j2 = 0; j2 < arr[0].length; j2++) {
				s += " " + arr[j][j2];
			}
			s += "\n";
		}
		System.out.println(s);
	}

	/**
	 * The printing method that print the maze 3D
	 * 
	 * no return value
	 */
	public void printMaze3d() {

		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < this.getColumns(); j++) {
				for (int k = 0; k < this.getFloors(); k++) {
					System.out.print(maze_matrix[i][j][k] + " ");
				}
				System.out.println(" ");
			}
			System.out.println();
		}

	}
}
