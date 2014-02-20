import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import java.awt.Color;
import java.util.ArrayList;

public class MazeRunner extends Bug
{
  
  
  private ArrayList<Location> visitedCells = new ArrayList<Location>();
  private int[] directions = new int[4];
  private int i = 1;
  ArrayList<Location> adjacentCells = new ArrayList<Location>
    
    
    
public ArrayList getCardinalAdjacentOccupiedLocations(Location loc){
    ArrayList<Location> output = new ArrayList<Location>();
    
    for (int i = 0; i<4; i++){
      output.add(loc.getAdjacentLocation(directions[i]));
    }
    return output;
  }
  
  
  
  public void act()
  {
    
    Location exit = getLocation();
    visitedCells.add(getLocation());
    recurseThisMaze(getLocation());
  }
  
  
  //code for recursion goes here, after bug generates maze it kills itself and then the world shows itself
  //while the placeholder for end maze is not in one of the cardinal directions
  
  
  
  public void recurseThisMaze(Location loc)
  {
    adjacentCells.clear();
    for (int i = 0; i<4; i++){
      adjacentCells.add(loc.getAdjacentLocation(directions[i]));
    }
    
    a = (int)(Math.Random()*4);
    
    for (Location a : adjacentCells){
      if (!visitedCells.contains(a)) recurseThisMaze(a); 
    }
    
  }
  
}