package algorithms.search;

import java.util.PriorityQueue;

/**
 * The CommonSearcher Class
 * 
 * @author Bar and Noa
 * 
 */
public abstract class CommonSearcher implements Searcher {

	/** The open list. */
	protected PriorityQueue<State> openList;

	/** The closed list. */
	protected PriorityQueue<State> closedList;

	/**
	 * Instantiates a new common searcher.
	 */
	public CommonSearcher() {
		openList = new PriorityQueue<State>();
		closedList = new PriorityQueue<State>();
	}
}