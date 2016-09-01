package algorithms.demo;



/**
 * The  MazeState class
 * Bar and Noa
 */
import algorithms.mazeGenerators.Position;
import algorithms.search.State;

public class MazeState extends State  {
	
	/** The player position. */
	private Position playerPosition;
	
	/**
	 * Instantiates a new state maze3d.
	 *
	 * @param playerPosition the player position
	 */
	public MazeState(Position playerPosition) {
		super();
		this.setPlayerPosition(playerPosition);
		this.setStete(playerPosition.toString());
	}

	/**
	 * Gets the player position.
	 *
	 * @return the player position
	 */
	public Position getPlayerPosition() {
		return playerPosition;
	}

	/**
	 * Sets the player position.
	 *
	 * @param playerPosition the new player position
	 */
	public void setPlayerPosition(Position playerPosition) {
		this.playerPosition = playerPosition;
	}
}