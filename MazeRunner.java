import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;




public class MazeRunner extends Bug
{
  
  public MazeRunner()
    {
        setDirection(90);
    }
    
  

    public void act()
    {
      
      //code for recursion goes here, after bug generates maze it kills itself and then the world shows itself
      
        
        
        removeSelfFromGrid();
    }
}
