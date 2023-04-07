package mazeUI;

import droidPD.Droid;
import mazePD.Maze;
import mazePD.Maze.MazeMode;

public class MazeStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Maze maze = new Maze(5,2,MazeMode.NORMAL );
		System.out.println("Maze - "+maze.toString());
		mazePrint(maze);
		Droid droid = new Droid("BB-77");
		droid.exploree(maze);
	}

	public static void mazePrint(Maze maze) {
		
		for( int i=0;i<maze.getMazeDepth();i++) {
			System.out.println("Level -"+i);
			String[] mazeArray = maze.toStringLevel(i);
			for(int j=0;j<maze.getMazeDim();j++) {
				System.out.println(j+"  "+mazeArray[j]);
			} 
			
		}
	}
}
