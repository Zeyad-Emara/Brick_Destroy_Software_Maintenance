package brick;

import java.awt.*;
import java.awt.Point;
import java.awt.geom.Point2D;


import ball.Ball;



/**
 *Brick class maintains brick shape, size, color and current status (broken,type ect.)
 * 
 */
abstract public class Brick  
{

    
    public static final int DEF_CRACK_DEPTH = 1;
    public static final int DEF_STEPS = 35;


    public static final int UP_IMPACT = 100;
    public static final int DOWN_IMPACT = 200;
    public static final int LEFT_IMPACT = 300;
    public static final int RIGHT_IMPACT = 400;


    
    /**
     * brick shape
     */
    Shape brickFace;
    
    /**
     * brick border color
     */
    private Color border;
    private Color inner;

    private int fullStrength;
    private int strength;
    /**
     * boolean to store ball state (broken/not broken)
     */
    private boolean broken;

    /**
     * brick constructor
     * @param name
     * @param pos
     * @param size
     * @param border
     * @param inner
     * @param strength
     */
    public Brick(String name, Point pos,Dimension size,Color border,Color inner,int strength)
    {
        
        broken = false;
        brickFace = makeBrickFace(pos,size);
        this.border = border;
        this.inner = inner;
        this.fullStrength = this.strength = strength;

    }
    /**
     * brick shape definer
     * @param pos
     * @param size
     * @return
     */
    protected Shape makeBrickFace(Point pos,Dimension size)
    {
    	return new Rectangle(pos, size);
    }
    /**
     * impact setter method
     * @param point
     * @param dir
     * @return
     */
    public  boolean setImpact(Point2D point , int dir)
    {
        if(broken)
            return false;
        impact();
        return  broken;
    }
    /**
     * brick shape getter
     * @return
     */
    public Shape getBrick()
    {
    	return brickFace;
    }


    /**
     * border color getter
     * @return
     */
    public Color getBorderColor()
    {
        return  border;
    }
    /**
     * inner color getter
     * @return
     */
    public Color getInnerColor()
    {
        return inner;
    }

    /**
     * Determining ball impact on brick
     * @param b
     * @return
     */
    public final int findImpact(Ball b)
    {
        if(broken)
            return 0;
        int out  = 0;
        if(brickFace.contains(b.getRight()))
            out = LEFT_IMPACT;
        else if(brickFace.contains(b.getLeft()))
            out = RIGHT_IMPACT;
        else if(brickFace.contains(b.getUp()))
            out = DOWN_IMPACT;
        else if(brickFace.contains(b.getDown()))
            out = UP_IMPACT;
        return out;
    }
    /**
     * checking if brick is broken
     * @return
     */
    public final boolean isBroken()
    {
        return broken;
    }

    public void repair() 
    {
        broken = false;
        strength = fullStrength;
    }
    
    public void impact()
    {
        strength--;
        broken = (strength == 0);
    }



}





