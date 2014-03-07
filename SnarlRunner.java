import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.ImmuneWall;
import java.util.Scanner;
import info.gridworld.grid.Location;
import info.gridworld.actor.BlackWall;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.actor.Actor;

import java.awt.Color;

public class SnarlRunner {
   public static boolean mazeIsDone = false;
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int steps = 0;
    
    System.out.println("Please Select a Maze Size by entering the corresponding number.");
    System.out.println("1. Small \n 2. Medium \n 3. Large \n 4. Massive");
    int dimension = input.nextInt()*10;
    ActorWorld world = new ActorWorld(new BoundedGrid<Actor>(dimension,dimension));
    world.setMessage("GET TO THE BLUE NOLAN. Move by typing into the console the direction you want (north, right etc). You also may destroy one wall by moving over it, but you may only destroy one.");
    
    
    
    for (int i=0; i<dimension; i++){
      for (int j=0; j<dimension; j++){//makes a fat block of tiles - walls for the maze
        world.add(new Location(i, j), new BlackWall());//unsure if this has to go here - can a world span multiple classes?
      }//screw blockrunners, imma just generate this here.
      }
    
    MazeRunner slave = new MazeRunner();
    
    world.add(new Location(dimension/2, 1), slave);
    world.step();
    world.step();
    slave.removeSelfFromGrid();
    world.show();
    world.add(new Location(dimension/2, dimension-1), new ImmuneWall());
    
    Player realPlayer = new Player();
    
    world.add(new Location(dimension/2, 1), realPlayer);
    //spawns a player
    world.show();
    //shows world
    while (!mazeIsDone){//while the player hasn't yet completed the maze, prompt the player for the next move.
     realPlayer.prompt();
      steps++;
      world.show();
    }
    
    //Backtracker back = new Backtracker();
    
   System.out.println("You took "+steps+" steps. GOOD JOB.");
  }
  
  public static void end(){
   mazeIsDone = true; 
  }
  
}
