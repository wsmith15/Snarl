import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.Flower;
import info.gridworld.actor.ImmuneWall;

public class Backtracker extends Bug
{
  
  public static int backTrack(){
    int a = 0;
    int output = 0;
      while (a == 0){
        if (getLocation().getAdjacentLocationTowards(getDirection()) instanceof ImmuneWall){
         a = 1; 
        }
        run();
        
      }
      
      return output;
  }

  
  public void act(){
   if (canMove()) move();
   else{
    turn();
    turn();
   }
   
  }
  //runs along maze dropping flower at junctions. keeps a counter of running total of steps and a separate counter of steps in particular junction.
  // if it sees a flower in front of it, subtracts current total of junctionsteps from running total of steps. repeats this until it sees the immunewall, or end of the maze.
  
  
      public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
        if (getGrid().getEmptyAdjacentLocations(getLocation()).size() > 2){//drops flowers at junctions
        Flower flower = new Flower(getColor());
        flower.putSelfInGrid(gr, loc);
        }
    }
  
  
}