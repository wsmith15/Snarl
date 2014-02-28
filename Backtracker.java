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
  private ArrayList<Location> adjacentCells = new ArrayList<Location>();
  Location loc = getLocation();
  private int[] directions = new int[4];
  private boolean isAdding = true;
  
  public Backtracker(){
    directions[0] = 0;
    directions[1] = 90;
    directions[2] = 180;
    directions[3] = 270;
  }
  
  
  public int backTrack(){
    int a = 0;
    int totalCounter=0;
    while (a == 0){
      if (getGrid().get(getLocation().getAdjacentLocation(getDirection())) instanceof ImmuneWall){
        a = 1;
        break;
      }
      if (getGrid().get(getLocation().getAdjacentLocation(getDirection())) instanceof Flower){
        if (isAdding==true) isAdding = false;
        else isAdding = true;
        
      }
      if (isAdding ==true){
        if (canMove()){
          run();
          totalCounter++;
        }
        else{
          run();
          totalCounter--;
        }
      }
      else{
        turn();
        turn();
        isAdding = false;
      }
    }
    return totalCounter;
    
  }
  
  public int cardinalEmpties(){
    loc = getLocation();
    
    for (int i = 0; i<4; i++){
      if (getGrid().isValid(loc.getAdjacentLocation(directions[i]))){
        adjacentCells.add(loc.getAdjacentLocation(directions[i]));
      }
    }
    return adjacentCells.size();
}
  
  public void run()
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
    
    if (cardinalEmpties() > 2){//drops flowers at junctions
      Flower flower = new Flower(getColor());
      flower.putSelfInGrid(gr, loc);
    }
    
    
  }
}