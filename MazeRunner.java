import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import java.awt.Color;
import java.util.ArrayList;

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
  
  
  public void recurseThisMaze(Location loc)
{
  moveTo(loc);
  adjacentCells.clear();
  for (int i = 0; i<4; i++){
    adjacentCells.add(loc.getAdjacentLocation(directions[i]));
  }
  
  i = (int)(Math.random()*4);
  loc1 = adjacentCells.get(i);
  
  if (visitedCells.contains(loc1)){
    for(Location a : adjacentCells){
      if (!visitedCells.contains(a)){
       recurseThisMaze(a); 
      }
    }
  }
  else{
      recurseThisMaze(loc1);
    }
  
}
}