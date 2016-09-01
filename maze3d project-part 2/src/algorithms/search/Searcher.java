package algorithms.search;

/**
 * The searcher interface
 * This interface will define for each 'searcher' object we may want to
 * implement other searching algorithms in the future as well.
 * 
 * @author Bar and Noa
 *
 */
public interface Searcher {
	
/**
 * Search.
 *
 * @param s the Searchable maze
 * @return the solution
 */
public Solution search(Searchable s);


}
