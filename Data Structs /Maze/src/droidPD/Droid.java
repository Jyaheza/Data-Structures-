package droidPD;

import mazePD.Coordinates;
import mazePD.DroidInterface;
import droidPD.LinkedStack;
import mazePD.Maze;
import mazePD.Maze.Content;
import mazePD.Maze.Direction;

public class Droid implements DroidInterface {
	int[] dx= {0,1,0,-1};
	int[] dy= {-1,0,1,0};
	private class MazeCell{
		Content content;
		Boolean visited=false;
		
		public MazeCell(Content content) {
			this.content=content;
			this.visited=false;
		}
		public MazeCell() {
			// TODO Auto-generated constructor stub
		}
		public Content getContent() {
			return this.content;
		}
		public Boolean getVisited() {
			return this.visited;
		}
		public void setContent( Content c ) {
			this.content=c;
		}
		public void setVisited( Boolean b) {
			this.visited=b;
		}
	}
	String name; 
	public Droid() {
		
	}
	
	public Droid(String name) {
		this.name= name;
	}

	Maze myMaze = new Maze();
	DroidInterface d;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	
	public void exploree(Maze maze) {
		
         MazeCell mazeMap[][][]= new MazeCell[maze.getMazeDim()][maze.getMazeDim()][maze.getMazeDepth()];
	
		Coordinates nextMove= null;
		 
		Coordinates currentLocation = maze.enterMaze(this);
		
		LinkedStack<Coordinates> mazePath= new LinkedStack<Coordinates>();
		
		for(int i=0;i<maze.getMazeDim();i++) {
			for(int j=0;j<maze.getMazeDim();j++) {
				for(int k=0;k<maze.getMazeDepth();k++) {
					mazeMap[i][j][k] = new MazeCell();
				}
			}
		}
		
		 mazeMap[currentLocation.getX()][currentLocation.getY()][currentLocation.getZ()]= new MazeCell(maze.scanCurLoc(this));
		 
		 mazePath.push(maze.getCurrentCoordinates(this));
		 
		 
		 while(!(mazePath.isEmpty())&& maze.scanCurLoc(this)!= Content.END ) {
			 
		
			 currentLocation = mazePath.peek();
			 
			 
			 System.out.println("moved to"+currentLocation);
			 System.out.println("and current Location "+maze.getCurrentCoordinates(this));
			 
			 mazeMap[currentLocation.getX()][currentLocation.getY()][currentLocation.getZ()]=new MazeCell(maze.scanCurLoc(this));
			 
			 mazeMap[currentLocation.getX()][currentLocation.getY()][currentLocation.getZ()].setVisited(true);;
			 
			 
			 Content [] lookAround= maze.scanAdjLoc(this);
			 //test
			 for(int j=0;j<4;j++) {
				 System.out.println(lookAround[j]);
			 }
			 
			 for(int i=0;i<4;i++) {
				 
				 if(lookAround[i]!=Content.NA) {
					 
				mazeMap[currentLocation.getX()+dx[i]][currentLocation.getY()+dy[i]][currentLocation.getZ()].setContent(lookAround[i]);
					 
				 }}
			 nextMove=null;
			 for(int i=0;i<4;i++) {
				 
				 if(lookAround[i]!=Content.NA) {
				 
					nextMove= findNextMovee(mazeMap,i,maze);
					
					if(nextMove!=null)
						break;
				 }
			 } 
				
			 if(nextMove!=null) {
					System.out.println("Found next Move");
					
				if(mazeMap[nextMove.getX()][nextMove.getY()][nextMove.getZ()].getContent()==Content.PORTAL_DN){
						nextMove=maze.usePortal(this, Direction.DN);
						System.out.println("Pusshed "+nextMove);
						mazePath.push(nextMove);
					}
					
					else {
						
						System.out.println("Pusshed "+nextMove);
						
						mazePath.push(nextMove);
							
					}
						//break;
					
				}
				else {
					System.out.println("pop "+mazePath.peek());
					mazePath.pop();
					Coordinates backCoord=moveDroid(currentLocation,mazePath.peek(),maze);
					System.out.println("Backed up to "+backCoord);
					
				}
			 
			}
			
			if(!mazePath.isEmpty())
				
			printPath(mazePath);
			
			else
				System.out.println("NO PATH");
		
	}
	
	
	public Coordinates findNextMovee(MazeCell[][][] mazeMap, int direction,Maze maze) {
		
	 
		Content content=mazeMap[maze.getCurrentCoordinates(this).getX()+dx[direction]][maze.getCurrentCoordinates(this).getY()+dy[direction]][maze.getCurrentCoordinates(this).getZ()].getContent();
		Boolean isVisited= mazeMap[maze.getCurrentCoordinates(this).getX()+dx[direction]][maze.getCurrentCoordinates(this).getY()+dy[direction]][maze.getCurrentCoordinates(this).getZ()].getVisited();
		
		System.out.println("found "+content + " "+isVisited+" at "+direction);
		
		Coordinates moveTo=null;
		if(content!=Content.BLOCK &&isVisited!=true) {
			moveTo=null;
			if(direction==0) {
				
				moveTo=maze.move(this, Direction.D00);
				
				
					return  moveTo;
			}
				
			
			if(direction==1) {
				
				moveTo=maze.move(this, Direction.D90);
				
				
					return  moveTo;
				
			}

			
			if(direction==2) {
				
				moveTo=maze.move(this, Direction.D180);
				
				
					return  moveTo;
				
			}
				
			
			if(direction==3) {
				
				
				moveTo=maze.move(this, Direction.D270);
				
				
				return  moveTo;
				
			}
			

			
		}
//		if(moveTo==null) {
//			moveDroid(currentLocation)
//		}
		return moveTo;
	}
	
	public Coordinates moveDroid(Coordinates currentLocation, Coordinates nextMove, Maze maze) {
		System.out.println("moving droid from "+currentLocation+" to"+nextMove);
		Coordinates coord=null;
		if(currentLocation.getX()== nextMove.getX()) {
			switch(currentLocation.getY()-nextMove.getY()) {
			case 1:
				coord= maze.move(this, Direction.D00);
				break;
			case -1:
				coord= maze.move(this, Direction.D180);
				break;
			}
		}
		if(currentLocation.getY()==nextMove.getY()) {
			switch(currentLocation.getX()-nextMove.getX()) {
			case 1:
				coord=maze.move(this,Direction.D270);
				break;
			case-1:
				coord=maze.move(this, Direction.D90);
				break;
			
			}
			
		}
		return coord;
	}
	
	public void printPath(LinkedStack<Coordinates> mazePath) {
		
		while(!(mazePath.isEmpty())) {
			
			System.out.print("Move to :"+mazePath.pop().toString());
			
		}
	}
}