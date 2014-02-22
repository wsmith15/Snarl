import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.ImmuneWall;
import java.util.Scanner;
import info.gridworld.grid.Location;
import info.gridworld.actor.BlackWall;
import info.gridworld.actor.ActorWorld;

import java.awt.Color;

public class SnarlRunner {
  
  public static void main(String[] args) {
    ActorWorld world = new SnarlWorld();
    Scanner input = new Scanner(System.in);
    boolean mazeIsDone = false;
    int steps = 0;
    
    
    System.out.println("Please Select a Maze Size by entering the corresponding number.");
    System.out.println("1. Small \n 2. Medium \n 3. Large \n 4. Massive \n 5. INSANE");
    int dimension = input.nextInt()*10;
    world.add(new Location(0,0), new BlockRunner());
    world.step();//spawns block runner which runs around placing tiles
    
    /*for (int i=0; i<=dimension; i++){
      for (int j=0; j<=dimension; j++){//makes a fat block of tiles - walls for the maze
        world.add(new Location(i, j), new BlackWall());//unsure if this has to go here - can a world span multiple classes?
      } THIS IS THE CODE FOR MAKING A BLOCK - XFER TO BLOCKRUNNER
    }
    */
    
    world.add(new Location(dimension/2, 0), new MazeRunner());
    world.step();//spawns a mazerunner which fleshes out a maze from the block
    
    world.add(new Location(dimension/2, 0), new Player());
    //spawns a player
    world.show();
    //shows world
    while (!mazeIsDone){//while the player hasn't yet completed the maze, prompt the player for the next move.
      Player.prompt();
      steps++;
    }
    
    Backtracker.backTrack();
    
  }
}
