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
  private int a = 1;
  private int c = 0;
  private ArrayList<Location> visitedCells = new ArrayList<Location>();
  private Location exit = getLocation();
  private Location loc1 = getLocation();
  private ArrayList<Location> doubleAdjCells = new ArrayList<Location>();
  private int counter;
  
  public MazeRunner(){
    directions[0] = 0;
    directions[1] = 90;
    directions[2] = 180;
    directions[3] = 270;
  }
  
  
  public void act(){
    while(numBlocks() < halfnumMaze()+10){
      if (a==1){
    recurseThisMaze(getLocation());
    a = 0;
      }
      else{
        recurseThisMaze(randomLocation());
      }
    }
  }
  
  public int numBlocks(){
    return visitedCells.size();
  }
  
  public int halfnumMaze(){
    int a = 0;
    int row = 0;
    int col = 0;
    row = getGrid().getNumRows();
    col = getGrid().getNumCols();
    a = row*col;
    a = a/2;
    return a;
  }
  
  public Location randomLocation(){ 
        c = (int)(Math.random()*getGrid().getOccupiedLocations().size());
    return getGrid().getOccupiedLocations().get(c);
  }
  
  
  
  
  
  
  public void recurseThisMaze(Location loc)
  {
    if( getGrid().isValid(loc)){
    moveTo(loc);//moves to loc
    visitedCells.add(loc);
    adjacentCells.clear();//clears adjacent cells araylist
    
    for (int i = 0; i<4; i++){
      if (getGrid().isValid(loc.getAdjacentLocation(directions[i]))){
        adjacentCells.add(loc.getAdjacentLocation(directions[i]));//adds new locs to adjacent cells
      }
    }
    
    i = (int)(Math.random()*adjacentCells.size());
    loc1 = adjacentCells.get(i);
    
    for (int q = i; i < 3 ; i++){
      if (canBecomePart(adjacentCells.get(q)) && getGrid().isValid(adjacentCells.get(q))){
        recurseThisMaze(adjacentCells.get(q));
      }
    }
    for (int r = 0; r < i; r++){
      if(r==adjacentCells.size()){
        break;
      }
      if (canBecomePart(adjacentCells.get(r)) && getGrid().isValid(adjacentCells.get(r))){
        recurseThisMaze(adjacentCells.get(r));
      }
    }
    }
  }
    public boolean canBecomePart(Location loc){
      int counter = 0;
      boolean output = true;
      Location thisLoc = getLocation();
      
      for (int i = 0; i<4; i++){
        if (getGrid().isValid(loc.getAdjacentLocation(directions[i]))){
          doubleAdjCells.add(loc.getAdjacentLocation(directions[i]));
        }
      }
      for (Location a : doubleAdjCells){
        if (visitedCells.contains(a)){
          counter++; 
        }
      }
      
      
      if (counter > 1){ output = false;
        
      }
      doubleAdjCells.clear();  
      
      return output;
    }
    
    
  }

/*
 public boolean canBecomePart(Location loc){
 int counter = 0;
 boolean output = false;
 Location thisLoc = getLocation();
 System.out.println("entered canBecomePart");
 for (int i = 0; i<4; i++){
 if (getGrid().isValid(loc.getAdjacentLocation(directions[i]))){
 System.out.println("checked if first adjacent loc is valid");
 thisLoc = loc.getAdjacentLocation(directions[i]);
 System.out.println("set it equal to loc");
 if(visitedCells.contains(thisLoc)) {counter ++;
 }
 }
 }
 if (counter > 2){ output = false;
 System.out.println("set output to false");
 }
 
 return output;
 }
 
 public void recurseThisMaze(Location loc)
 {
 
 super.moveTo(loc);//moves to loc
 adjacentCells.clear();//clears adjacent cells
 
 for (int i = 0; i<4; i++){
 if (getGrid().isValid(loc.getAdjacentLocation(directions[i]))){
 adjacentCells.add(loc.getAdjacentLocation(directions[i]));//adds new locs to adjacent cells
 }
 }
 
 i = (int)(Math.random()*adjacentCells.size());
 loc1 = adjacentCells.get(i);
 System.out.println("randomly chose"+loc1);
 
 
 for(int q = i; q < adjacentCells.size(); q++){
 loc1 = adjacentCells.get(q);//starting with a random neighboring location in adjacent cells, recurses this one as
 if (canBecomePart(loc1)){
 System.out.println("recursed"+loc1);
 visitedCells.add(loc1);
 recurseThisMaze(loc1);
 }
 }
 for (int r = 0; r < i; r++){
 loc1 = adjacentCells.get(r);
 if (canBecomePart(loc1)){
 System.out.println("recursed"+loc1);
 visitedCells.add(loc1);
 recurseThisMaze(loc1);
 }
 }
 
 
 }
 }
 */

