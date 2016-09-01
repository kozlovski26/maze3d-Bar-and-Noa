package algorithms.search;



/**
 * The State class
 * State will help as present current state in our problem
 * @author Bar and Noa
 * @param description represent the description of our state.
 * @param cost is the weight of the path - the calculate cost from the start position to this state.
 * @param cameFrom indicate from which state we arrive to this current state.
 */
public class State implements Comparable<State> {
	
	/** The state. */
	private String state;
	
	/** The cost. */
	private double cost;
	
	/** The cam from. */
	private State camFrom;

	
	/**
	 * Instantiates a new state.
	 */
	public State (){};
	

	/*-------------------*/

	/**
	 * Gets the stete.
	 *
	 * @return the stete
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Gets the cost.
	 *
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * Gets the cam from.
	 *
	 * @return the cam from
	 */
	public State getCamFrom() {
		return camFrom;
	}
	
	/**
	 * Sets the stete.
	 *
	 * @param state the new stete
	 */
	public void setStete(String state) {
		this.state = state;
	}
	
	/**
	 * Sets the cost.
	 *
	 * @param cost the new cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	/**
	 * Sets the cam from.
	 *
	 * @param camFrom the new cam from
	 */
	public void setCamFrom(State camFrom) {
		this.camFrom = camFrom;
	}
	
	/**
	 * Instantiates a new state.
	 *
	 * @param state the state
	 */
	public State(String state) {
		this.state = state;
	}


	/**
	 * Compare between to States
	 */
	@Override
	public int compareTo(State s) {
		return (int)(this.cost - s.cost);
	}
	
	/**
	 * Check if the 2 State are equal
	 */
	@Override
	public boolean equals(Object arg0) {
		State state2 = (State)arg0;
		return state.equals(state2.state);
	}
	
	/**
	 * State in String
	 */
	@Override
	public String toString()
	{
		return state;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode(){
		return state.hashCode();
	}
}