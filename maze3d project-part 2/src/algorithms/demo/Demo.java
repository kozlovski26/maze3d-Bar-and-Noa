package algorithms.demo;

import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.RandomCellChoose;
import algorithms.search.BFS;
import algorithms.search.DFS;

/**
 * Demo class
 * 
 * @Bar and Noa
 *
 */
public class Demo {

	public void run() {

		/**
		 * Creating a new maze3d with SimpleMaze3dGenerator,or by the two kinds
		 * of growing tree algorithms that choosing last cell or random cell
		 */
		// Maze3dGenerator myMaze = new SimpleMaze3dGenerator();
		// Maze3dGenerator myMaze = new GrowingTreeGenerator(new
		// LastCellChoose());
		Maze3dGenerator myMaze = new GrowingTreeGenerator(new RandomCellChoose());
		Maze3d maze3d = myMaze.generate(15, 15, 3);

		// create BFS and DFS
		BFS bfs = new BFS();
		DFS dfs = new DFS();
		// Searchable maze with our maze
		SearchableMaze3d searchbleMaze = new SearchableMaze3d(maze3d);
		// print the goal and the start position
		System.out.println(maze3d.getStartPosition());
		System.out.println(maze3d.getGoalPosition());
		// print the maze3d
		System.out.println(maze3d);
		// solve the maze with the BFS and DFS algorithms
		bfs.search(searchbleMaze);
		dfs.search(searchbleMaze);
		// print the numbers of the Evaluated Nodes
		System.out.println("This is the BFS solution" + " " + bfs.getNumOfEvaluatedNodes());
		System.out.println("This is the DFS solution" + " " + dfs.getNumOfEvaluatedNodes());

	}

}
