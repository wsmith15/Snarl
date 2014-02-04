import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.BlackWall;

import java.awt.Color;

/**
 * This class runs a world that contains Termites. <br />
 */
public class SnarlRunner {
    
    public static void main(String[] args) {
        ActorWorld world = new SnarlWorld();
        GenerateMaze.generate();     
        world.show();
    }
}
