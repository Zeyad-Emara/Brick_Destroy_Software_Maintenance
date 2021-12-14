package brick;


import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;

public class DiamondBrick extends Brick
{

	private static final String NAME = "Diamond Brick";
    private static final Color DEF_INNER = new Color(185, 242, 255);
    private static final Color DEF_BORDER = Color.CYAN;
    private static final int Diamond_STRENGTH = 1;
    private static final double Diamond_PROBABILITY = 0.3;

    private Random rnd;
    private Shape brickFace;
    
    public DiamondBrick(Point point, Dimension size)
    {
    	super(NAME,point,size,DEF_BORDER,DEF_INNER,Diamond_STRENGTH);
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

    public void impact()
    {
        if(rnd.nextDouble() < Diamond_PROBABILITY)
        {
            super.impact();
        }
    }

    
}