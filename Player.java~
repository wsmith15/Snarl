import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Bug
{
  
  public void prompt(){
    Scanner input = new Scanner(System.in);
    String a = input.nextLine();
    a = a.toLowerCase();
    
    if(a.equals("up") || a.equals("north")){
      setDirection(0);
      move();
    }
    
    if(a.equals("down") || a.equals("south")){
      setDirection(180);
      move();
    }
    
    if(a.equals("right") || a.equals("east")){
      setDirection(90);
      move();
    }
    
    if(a.equals("left") || a.equals("west")){
      setDirection(270);
      move();
    }
    
   //moves player to specified location
    
    
   /* for(Actor a : getLocation().getOccupiedAdjacentLocations()){
      if (a instanceof immunewall){//if it hits an immunewall, ends the game
        SnarlRunner.end();
        }
      }
      */
    
    }
    
}
  