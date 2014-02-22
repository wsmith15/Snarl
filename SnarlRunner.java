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
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    boolean mazeIsDone = false;
    int steps = 0;
    
    System.out.println("Please Select a Maze Size by entering the corresponding number.");
    System.out.println("1. Small \n 2. Medium \n 3. Large \n 4. Massive \n 5. INSANE");
    int dimension = input.nextInt()*10;
    ActorWorld world = new ActorWorld(new BoundedGrid<Actor>(dimension,dimension));
    //world.add(new Location(0,0), new BlockRunner());
    world.step();//spawns block runner which runs around placing tiles
    
    
    world.add(new Location(dimension/2, dimension-1), new ImmuneWall());
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
