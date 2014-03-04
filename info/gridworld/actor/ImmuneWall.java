package info.gridworld.actor;
import java.awt.Color;

public class ImmuneWall extends Actor
{
    //wall used to determine the boundaries of the grid
    
    private static final Color DEFAULT_COLOR = Color.BLACK;

    public ImmuneWall()
    {
    }


    public ImmuneWall(Color thisColor)
    {
        setColor(thisColor);
    }
    public void act()
    {
    }
}

