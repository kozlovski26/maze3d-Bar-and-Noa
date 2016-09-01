package algorithms.search;

import java.util.HashMap;

/**
 * This interface will define to each 'searchable' object the start-state ,
 * goal-state and all-possible-moves from the current state.
 * 
 * @author Bar and Noa
 */
public interface Searchable
{
		   
   		/**
   		 * Gets the start state.
   		 *
   		 * @return the start state
   		 */
   		State getStartState();
		   
   		/**
   		 * Gets the goal state.
   		 *
   		 * @return the goal state
   		 */
   		State getGoalState();
		   
   		/**
   		 * Gets the all possible states.
   		 *
   		 * @param s the s
   		 * @return the all possible states
   		 */
   		HashMap<Action,State> getAllPossibleStates(State s);
		}
