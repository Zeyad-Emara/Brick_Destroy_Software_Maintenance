package brick;

import java.awt.*;
import java.awt.Point;



/**
 * 
 * clay brick is a child of brick class 
 *
 */
public class ClayBrick extends Brick 
{

    private static final String NAME = "Clay Brick";
    private static final Color DEF_INNER = new Color(178, 34, 34).darker();
    private static final Color DEF_BORDER = Color.GRAY;
    private static final int CLAY_STRENGTH = 1;





    /**
     * Method to draw brick with clay characteristics 
     * @param point
     * @param size
     */
    public ClayBrick(Point point, Dimension size)
    {
        super(NAME,point,size,DEF_BORDER,DEF_INNER,CLAY_STRENGTH);
    }

    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) 
    {
        return new Rectangle(pos,size);
    }

    @Override
    public Shape getBrick() 
    {
        return super.brickFace;
    }


}
