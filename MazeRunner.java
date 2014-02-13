import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;

public class MazeRunner extends Bug
{
  
  private int[] directions = new int[4];
  private int i = 1;
  
  public MazeRunner()
    {
        setDirection(90);
        directions[0] = 0;
        directions[1] = 90;
        directions[2] = 1;
    }
    
  

    public void act()
    {
      //code for recursion goes here, after bug generates maze it kills itself and then the world shows itself
      //while the placeholder for end maze is not in one of the cardinal directions
      while (i = 1) //while the placeholder for end maze is not in one of the cardinal directions
      int direction = (int)(Math.Random()*4)
        if getlocation().getAdjacentLocation(directions[direction].getAdjacentLocation(directions[direction]).get() instanceof BlackWall{
        
        setDirection(direction);
        move();
        
      }
        
        
        removeSelfFromGrid();
    }
}
