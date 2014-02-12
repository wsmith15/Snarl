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
    System.out.println("Please Select a Maze Size by entering the corresponding number.");
    System.out.println("1. Small \n 2. Medium \n 3. Large \n 4. Massive \n 5. INSANE");
    int dimension = input.nextInt()*10;
    //generates an unbounded grid with generate maze - boolean variable isDone set true in a while loop to continuously call act() until maze is done?
    Location origin = new Location(0,0);
    Location alpha = new Location(dimension/2, 0);
    Location omega = new Location(dimension/2,dimension/2);
    
    for (int i=0; i<=dimension; i++){
      for (int j=0; j<=dimension; j++){//makes a fat block of tiles - walls for the maze
        world.add(new Location(i, j), new BlackWall());
      }
    }
    GenerateMaze.generate(dimension);

    world.show();
    
  }
}
