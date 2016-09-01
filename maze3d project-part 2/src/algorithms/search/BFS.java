package algorithms.search;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map.Entry;

/**
 * The BFS Algorithm class  
 * Best First Search Solves problems using BFS.
 * 
 * @author Bar and Noa
 *
 */

public class BFS extends CommonSearcher {

	/** The Num of Nodes that have developed. */
	private int NumOfEvol = 0;
	private Solution sol;

	/**
	 * Best-first search Solution to by specific algorithm - Best-first search
	 */
	@Override
	public Solution search(Searchable s) {
		openList.add(s.getStartState());

		while (!openList.isEmpty()) {

			State state = openList.poll();
			NumOfEvol = getNumOfEvaluatedNodes() + 1;
			closedList.add(state);

			if (state.equals(s.getGoalState())) {

				return backtrace(state);
			}
			HashMap<Action, State> actions = s.getAllPossibleStates(state);
			for (Entry<Action, State> entry : actions.entrySet()) {
				Action action = entry.getKey();
				State successor = entry.getValue();

				if (!openList.contains(successor) && !closedList.contains(successor)) {
					successor.setCamFrom(state);
					successor.setCost(state.getCost() + action.getCost());
					openList.add(successor);

				} else if (state.getCost() + action.getCost() < successor.getCost()) {

					successor.setCamFrom(state);
					successor.setCost(state.getCost() + action.getCost());

					// update priority in queue by removing and adding the state
					openList.remove(successor);
					openList.add(successor);
				}
			}
		}
		return null; // won't reach this line never
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
		this.sol = solution;
		return solution;
	}

	/**
	 * Gets the num of Nodes that have developed..
	 *
	 * @return the num of Nodes that have developed.
	 */
	public int getNumOfEvaluatedNodes() {
		return NumOfEvol;
	}

	/**
	 * Sets the num of Nodes that have developed..
	 *
	 * @param sol
	 *            the new num of Nodes that have developed.
	 */
	public void setNumOfEvaluatedNodes(int sol) {
		this.NumOfEvol = sol;
	}

	public Solution getSol() {
		return this.sol;
	}

}