package brick;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

/**
 * 
 * 
 *Cement brick is a child of brick class 
 */
public class CementBrick extends Brick 
{


    private static final String NAME = "Cement Brick";
    private static final Color DEF_INNER = new Color(147, 147, 147);
    private static final Color DEF_BORDER = new Color(217, 199, 175);
    private static final int CEMENT_STRENGTH = 2;

    private Crack crack;
    private Shape brickFace;

    /**
     * Method to draw brick with Cement characteristics 
     * @param point
     * @param size
     */
    public CementBrick(Point point, Dimension size)
    {
        super(NAME,point,size,DEF_BORDER,DEF_INNER,CEMENT_STRENGTH);
        crack = new Crack(DEF_CRACK_DEPTH,DEF_STEPS);
        brickFace = super.brickFace;
    }

    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) 
    {
        return new Rectangle(pos,size);
    }
    /**
     * method to determine if should draw crack
     */
    @Override
    public boolean setImpact(Point2D point, int dir) 
    {
        if(super.isBroken())
            return false;
        super.impact();
        if(!super.isBroken()){
            crack.makeCrack(point,dir, brickFace.getBounds());
            updateBrick();
            return false;
        }
        return true;
    }


    @Override
    public Shape getBrick() 
    {
        return brickFace;
    }
    /**
     * Method drawing crack on cement brick
     */
    private void updateBrick()
    {
        if(!super.isBroken())
        {
            GeneralPath gp = crack.draw();
            gp.append(super.brickFace,false);
            brickFace = gp;
        }
    }
    /**
     * resetting bricks to full health
     */
    public void repair()
    {
        super.repair();
        crack.reset();
        brickFace = super.brickFace;
    }
}