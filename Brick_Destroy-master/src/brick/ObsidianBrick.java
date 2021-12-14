package brick;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.util.Random;
/**
 * 
 * ObsidianBrick class is a child of Brick class
 *
 */
public class ObsidianBrick extends Brick
{

	private static final String NAME = "Diamond Brick";
    private static final Color DEF_INNER = new Color(48, 25, 52);
    private static final Color DEF_BORDER = Color.BLACK;
    private static final int Obsidian_STRENGTH = 5;
    private static final double Obsidian_PROBABILITY = 0.1;

    private Random rnd;
    private Shape brickFace;
    /**
     * Method to draw brick with obsidian characteristics
     * @param point
     * @param size
     */
    public ObsidianBrick(Point point, Dimension size)
    {
    	super(NAME,point,size,DEF_BORDER,DEF_INNER,Obsidian_STRENGTH);
        rnd = new Random();
        brickFace = super.brickFace;
    }
    
    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) 
    {
        return new Rectangle(pos,size);
    }

    @Override
    public Shape getBrick() 
    {
        return brickFace;
    }

    public  boolean setImpact(Point2D point , int dir)
    {
        if(super.isBroken())
            return false;
        impact();
        return  super.isBroken();
    }

    /**
     * method to randomly weaken brick by hitting it
     */
    public void impact()
    {
        if(rnd.nextDouble() < Obsidian_PROBABILITY)
        {
            super.impact();
        }
    }

    
}



