package algorithms.demo;

import java.util.HashMap;

import algorithms.mazeGenerators.Directions;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Action;
import algorithms.search.Searchable;
import algorithms.search.State;

/**
 * The Searchable maze3d calss
 * This class doing an Adaptation to each searchable problem in the maze.
 * 
 * @author Bar and Noa
 *
 */
public class SearchableMaze3d implements Searchable {

	/** The Constant COST. */
	private static final int COST = 1;

	/** The maze. */
	private Maze3d maze;

	/**
	 * Instantiates a new searchable maze3d.
	 *
	 * @param maze
	 * 
	 */
	public SearchableMaze3d(Maze3d maze) {
		this.maze = maze;
	}

	/**
	 * Gets the next position.
	 *
	 * @param p
	 *            the position
	 * @param dir
	 *            the Direction
	 * @return the next position
	 */
	private Position getNextPosition(Position p, Directions dir) {
		switch (dir) {
		case LEFT:
			return new Position(p.getX(), p.getY() - 1, p.getZ());
		case RIGHT:
			return new Position(p.getX(), p.getY() + 1, p.getZ());
		case UP:
			return new Position(p.getX(), p.getY(), p.getZ() + 1);
		case DOWN:
			return new Position(p.getX(), p.getY(), p.getZ() - 1);
		case BACKWARD:
			return new Position(p.getX() - 1, p.getY(), p.getZ());
		case FORWARD:
			return new Position(p.getX() + 1, p.getY(), p.getZ());
		}
		return null;

	}

	/**
	 * adapter start position to state
	 */
	@Override
	public State getStartState() {
		MazeState statState = new MazeState(maze.getStartPosition());
		statState.setCamFrom(null);
		return statState;

	}

	/**
	 * adapter goal position to state
	 */
	@Override
	public State getGoalState() {
		MazeState goalState = new MazeState(maze.getGoalPosition());
		return goalState;
	}

	@Override
	public HashMap<Action, State> getAllPossibleStates(State state) {
		MazeState mazeState = (MazeState) state;
		Position pos = mazeState.getPlayerPosition();
		Directions[] directions = maze.getPossibleDirections(pos);

		HashMap<Action, State> actions = new HashMap<Action, State>();
		for (Directions d : directions) {
			Action action = new Action(d.toString(), COST);
			MazeState newState = new MazeState(getNextPosition(pos, d));

			actions.put(action, newState);
		}

		return actions;
	}
}