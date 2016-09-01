package algorithms.search;


import java.util.ArrayList;

/**
 * The Solution class
 * 
 * The class Solution shows us the expected solution - 
 * the path from the start state to the goal state.
 * @author Bar and Noa
 * @param ArrayList of states
 */
public class Solution {
	
	/** The states. */
	private ArrayList<State> states;

	/**
	 * Gets the states.
	 *
	 * @return the states
	 */
	public ArrayList<State> getStates() {
		return states;
	}
	
	/**
	 * Sets the states.
	 *
	 * @param states the new states
	 */
	public void setStates(ArrayList<State> states) {
		this.states = states;
	}		
	
	/**
	 * Solution in String
	 */
	@Override
	public String toString() {
		String str = " ";
		for (State state:states){
			str += state.getState() + "\n ";
				}
		return str;
	}
	
	/**
	 * Gets the states num.
	 *
	 * @return the states num
	 */
	public int getStatesNum() {
		return states.size();
	}
}