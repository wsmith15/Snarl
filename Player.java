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
  
  private int hasnotmovedover = 0;
  private int nummoveover = 2;
    
  
  public void prompt(){
    Scanner input = new Scanner(System.in);
    String a = input.nextLine();
    a = a.toLowerCase();
    
    if(a.equals("up") || a.equals("north") || a.equals("w")){
      setDirection(0);
      if (hasnotmovedover < nummoveover|| canMove()){
                if(canMove()==false){
         hasnotmovedover++; 
        }
      move();
      }
    }
    
    if(a.equals("down") || a.equals("south")  || a.equals("s")){
      setDirection(180);
      if (hasnotmovedover < nummoveover|| canMove()){
                if(canMove()==false){
         hasnotmovedover++; 
        }
      move();
      }
    }
    
    if(a.equals("right") || a.equals("east")  || a.equals("d")){
      setDirection(90);
      if (hasnotmovedover < nummoveover|| canMove()){
                if(canMove()==false){
         hasnotmovedover++;
        }
      move();
      }
    }
    
    if(a.equals("left") || a.equals("west")  || a.equals("a")){
      setDirection(270);
      if (hasnotmovedover < nummoveover|| canMove()){
        if(canMove()==false){
         hasnotmovedover++;
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
  