package algorithms.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * The DFS Algorithm class 
 * @author Bar and Noa
 *
 */
public class DFS extends CommonSearcher {

	/** The visited states. */
	private HashSet<State> visitedStates = new HashSet<State>();

	/** The Solution. */
	private Solution sol;

	/** The Num of Nodes that have developed. */
	private int NumOfEvol = 0;

	/**
	 * Gets the num of Evaluated Nodes.
	 *
	 * @return the num of Evaluated Nodes
	 */
	public int getNumOfEvaluatedNodes() {
		return NumOfEvol;
	}

	/**
	 * Sets the num of Evaluated Nodes.
	 *
	 * @param so
	 *            the new num of Evaluated Nodes
	 */
	public void setNumOfEvaluatedNodes(int so) {
		this.NumOfEvol = so;
	}

	/**
	 * Depth-first search Solution to by specific algorithm - Depth-first search
	 */
	@Override
	public Solution search(Searchable s) {

		dfs(s, s.getStartState());
		return sol;
	}

	/**
	 * DFS- Depth-first search
	 *
	 * @param s
	 *            the searchable maze
	 * @param state
	 *            the state
	 */
	private void dfs(Searchable s, State state) {
		setNumOfEvaluatedNodes(getNumOfEvaluatedNodes() + 1);
		if (state.equals(s.getGoalState())) {
			this.sol = backtrace(state);
			return;
		}
		visitedStates.add(state);
		if (state.equals(s.getStartState())) {
			state.setCamFrom(null);
		}

		HashMap<Action, State> actions = s.getAllPossibleStates(state);

		for (State neighbor : actions.values()) {
			if (!visitedStates.contains(neighbor)) {
				neighbor.setCamFrom(state);

				dfs(s, neighbor);
			}
		}
		return;
	}

	/**
	 * Backtrace. this method give the user how the algorithm get to the
	 * solution
	 * 
	 * @param state
	 *            the State
	 * @return the solution
	 */
	private Solution backtrace(State state) {
		State s = state;
		ArrayList<State> states = new ArrayList<State>();
		while (s != null) {
			states.add(0, s);
			s = s.getCamFrom();
		}

		Solution solution = new Solution();
		solution.setStates(states);
		return solution;
	}

	public Solution getSol() {
		return sol;
	}

	public void setSol(Solution sol) {
		this.sol = sol;
	}

}