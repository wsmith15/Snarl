import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.ImmuneWall;

public class MazeRunner extends Bug
{
  private int[] directions = new int[4];
  private ArrayList<Location> adjacentCells = new ArrayList<Location>();
  private int i = 0;
  private ArrayList<Location> visitedCells = new ArrayList<Location>();
  private Location exit = getLocation();
  private Location loc1 = getLocation();
  
  public MazeRunner(){
   directions[0] = 0;
   directions[1] = 90;
   directions[2] = 180;
   directions[3] = 270;
  }
  
  
  public void act(){
    recurseThisMaze(getLocation());
    removeSelfFromGrid();
  }
  
  public void recurseThisMaze(Location loc)
{
  super.moveTo(loc);
  System.out.println("moved to"+loc);
  adjacentCells.clear();
  for (int i = 0; i<4; i++){
    adjacentCells.add(loc.getAdjacentLocation(directions[i]));
  }
    for(Location a :adjacentCells){
      if (getGrid().get(a) instanceof ImmuneWall){
       return; 
      }
    }
  i = (int)(Math.random()*4);
  loc1 = adjacentCells.get(i);
  
  for(int q = i; q < 3; q++){
    loc1 = adjacentCells.get(q);
    if (!visitedCells.contains(loc1)){
      if (getGrid().isValid(loc1)){
    recurseThisMaze(loc1);
      }
     }
  }
  for (int r = 0; r < i; r++){
    loc1 = adjacentCells.get(r);
  if (!visitedCells.contains(loc1)){
    if (getGrid().isValid(loc1)){
    recurseThisMaze(loc1);
      }
  }
  }
}
  
}
