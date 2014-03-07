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
  private ArrayList<Location> doubleVisitCell = new ArrayList<Location>();
  private int counter;
  
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

  super.moveTo(loc);//moves to loc
  adjacentCells.clear();//clears adjacent cells

  for (int i = 0; i<4; i++){
    if (getGrid().isValid(loc.getAdjacentLocation(directions[i]))){
    adjacentCells.add(loc.getAdjacentLocation(directions[i]));//adds new locs to adjacent cells
    }
  }
    for(Location a :adjacentCells){//for every location in adjacent cells
      for(int i = 0; i < 4; i++){
      doubleVisitCell.add(a.getAdjacentLocation(directions[i]));//adds cardinal adjacent cells to arraylist for one adjacent cell
      }
      for (Location b : doubleVisitCell){
        if (visitedCells.contains(b)){//if one of those card cells are visited
          counter++;//adds one ot the counter
        }
      
      if (counter > 1){
       visitedCells.add(b); //if two or more are visited, current card cell is now visi
      }
      }
      counter = 0;//resets counter
      doubleVisitCell.clear();//and card cell list
    }
  
    if (getGrid() == null){
      return;
}
    else{
        i = (int)(Math.random()*adjacentCells.size());
  loc1 = adjacentCells.get(i);
  
  recurseThisMaze(loc1);
  
  /*for(int q = i; q < adjacentCells.size(); q++){
    loc1 = adjacentCells.get(q);
    if (!visitedCells.contains(loc1)){
    System.out.println("recursed"+loc1);
    recurseThisMaze(loc1);
     }
  }
  for (int r = 0; r < i; r++){
    loc1 = adjacentCells.get(r);
  if (!visitedCells.contains(loc1)){
    System.out.println("recursed"+loc1);
    recurseThisMaze(loc1);
  }
  }
  */
      
    }
}
  
}
