package info.gridworld.actor;
import java.awt.Color;

public class BlackWall extends Actor
{
    
    
    private static final Color DEFAULT_COLOR = Color.BLACK;

    public BlackWall()
    {
        setColor(DEFAULT_COLOR);
    }


    public BlackWall(Color thisColor)
    {
        setColor(thisColor);
    }
    public void act()
    {
    }
}

