package algorithms.search;



/**
 * The class Action
 * This class describe the action moves of the player.
 * @author Bar and Noa
 *
 */
public class Action {
	
	
	/** The description. */
	private String description;
	
	/** The cost. */
	private double cost;
	
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	
	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * Sets the cost.
	 *
	 * @param cost the new cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	/**
	 * Instantiates a new action.
	 */
	public Action() {}
	
	
	/**
	 * Instantiates a new action.
	 *
	 * @param description 
	 * @param cost 
	 */
	public Action(String description, double cost) {		
		this.description = description;
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return description;
	}	
}