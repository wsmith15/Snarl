import info.gridworld.grid.*;
import info.gridworld.grid.UnboundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.actor.*;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.BlackWall;
import info.gridworld.actor.Player;



public class SnarlWorld extends ActorWorld
{
public SnarlWorld()
{
setGrid(new UnboundedGrid<Actor>());
}
}