import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.BlackWall;

import java.awt.Color;

public class SnarlRunner {
    
    public static void main(String[] args) {
        ActorWorld world = new SnarlWorld();
        GenerateMaze.generate();     
        world.show();
        //generates an unbounded grid with generate maze - boolean variable isDone set true in a while loop to continuously call act() until maze is done?
        
    }
}
