
package algorithms.mazeGenerators;

/**
 * The Class Position.
 * 
 * @author Bar and Noa
 */
public class Position {
	/** Variables **/
	public int x;
	public int y;
	public int z;

	/** ctor to position that puts 0 in the values of the positions **/
	public Position() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}

	/**
	 * Instantiates a new position
	 * 
	 * @param x
	 *            rows
	 * @param y
	 *            columns
	 * @param z
	 *            floors
	 */
	public Position(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * position Ctor with other position
	 * 
	 * @param pos
	 */
	public Position(Position pos) {
		this.x = pos.x;
		this.y = pos.y;
		this.z = pos.z;
	}

	/**
	 * get the x coordinate in some position
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * set the x(rows)
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * get the y coordinate in some position
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * set the y(columns)
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * get the z coordinate in some position
	 * 
	 * @return z
	 */
	public int getZ() {
		return z;
	}

	/**
	 * set the z(floors)
	 * 
	 * @param z
	 */
	public void setZ(int z) {
		this.z = z;
	}

	/**
	 * override toString method to {x,y,z}
	 */
	@Override
	public String toString() {
		return "{" + x + "," + y + "," + z + "}";
	}

	/**
	 * equals between two positions
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Position)) {
			return false;
		}
		Position p = (Position) obj;
		return x == p.x && y == p.y && z == p.z;
	}
}