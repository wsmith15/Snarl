import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.ImmuneWall;
import java.util.Random;

public class MazeRunner extends Bug
{
  private int[] directions = new int[4];
  private ArrayList<Location> wallCells = new ArrayList<Location>();
  private int i = 0;
  private ArrayList<Location> visitedCells = new ArrayList<Location>();
  private Location exit = getLocation();
  private Location loc1 = getLocation();
  private Random r = new Random();
  private int random = 0;
  
  public MazeRunner(){
   directions[0] = 0;
   directions[1] = 90;
   directions[2] = 180;
   directions[3] = 270;
  }
  
  
  public void act(){
    recurseThisMaze(getLocation());
  }
  
  
  
  
  
  
  
  
  public void recurseThisMaze(Location loc)
{
    
  super.moveTo(loc);
  visitedCells.add(loc);
  
  for (int i = 0; i<4; i++){
    if (getGrid().isValid(loc.getAdjacentLocation(directions[i]))){
    wallCells.add(loc.getAdjacentLocation(directions[i]));
    //adds adjacent cells to the list of walls
    }
  }
  while (wallCells.size() > 0){
  random = r.nextInt(wallCells.size());
  loc = wallCells.get(random);
  
  if (visitedCells.contains(loc.getAdjacentLocation(getLocation().getDirectionToward(loc)))){
    wallCells.remove(random);
  }
  else{
    moveTo(loc);
    for (int i = 0; i<4; i++){
    if (getGrid().isValid(loc.getAdjacentLocation(directions[i]))){
    wallCells.add(loc.getAdjacentLocation(directions[i]));
    //adds adjacent cells to the list of walls
    }
  }
      
  }
  }
}
 
}
