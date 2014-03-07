import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;
import info.gridworld.actor.ImmuneWall;

public class Player extends Bug
{
  
  private boolean hasnotmovedover = true;
  
  public void prompt(){
    Scanner input = new Scanner(System.in);
    String a = input.nextLine();
    a = a.toLowerCase();
    
    if(a.equals("up") || a.equals("north")){
      setDirection(0);
      if (hasnotmovedover || canMove()){
                if(canMove()==false){
         hasnotmovedover=false; 
        }
      move();
      }
    }
    
    if(a.equals("down") || a.equals("south")){
      setDirection(180);
      if (hasnotmovedover || canMove()){
                if(canMove()==false){
         hasnotmovedover=false; 
        }
      move();
      }
    }
    
    if(a.equals("right") || a.equals("east")){
      setDirection(90);
      if (hasnotmovedover || canMove()){
                if(canMove()==false){
         hasnotmovedover=false; 
        }
      move();
      }
    }
    
    if(a.equals("left") || a.equals("west")){
      setDirection(270);
      if (hasnotmovedover || canMove()){
        if(canMove()==false){
         hasnotmovedover=false; 
        }
        
      move();
      }
    }
    
   //moves player to specified location
    
    
     for(Location b : getGrid().getOccupiedAdjacentLocations(getLocation())){
      if (getGrid().get(b) instanceof ImmuneWall){//if it hits an immunewall, ends the game
        SnarlRunner.end();
        }
      }
      
    
    }
    
}
  