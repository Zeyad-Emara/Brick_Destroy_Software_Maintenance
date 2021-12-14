package ball;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

/**
 *Ball class for managing in game ball 
 * @author Zeyad Hesham Emara 20215171
 *
 */
abstract public class Ball 
{
	
	//ball outline
	/**
	 * ball outline
	 */
    private Shape ballFace;
    
    //ball coordinates 
    /**
     * ball coordinates
     */
    private Point2D center;
    private Point2D up;
    private Point2D down;
    private Point2D left;
    private Point2D right;
    
    //border color
    /**
     * ball's border color
     */
    private Color border;
    //ball color
    /**
     * ball's inner color
     */
    private Color inner;
    
    //ball speed
    /**
     * ball speed
     */
    private int speedX;
    private int speedY;
    
    //ball class constructor, initializes then sets values for the ball coordinates, ball color and border color, and ball speed
    /**
     * 
     * @param center
     * @param radiusA
     * @param radiusB
     * @param inner
     * @param border
     * ball constructor determines ball's characteristics
     */
    public Ball(Point2D center,int radiusA,int radiusB,Color inner,Color border)
    {
        this.center = center;
        
        //initialize the ball coordinates
        up = new Point2D.Double();
        down = new Point2D.Double();
        left = new Point2D.Double();
        right = new Point2D.Double();

        //set ball coordinates on the vertical axis
        up.setLocation(center.getX(),center.getY()-(radiusB / 2));
        down.setLocation(center.getX(),center.getY()+(radiusB / 2));
        //set ball coordinates on horizontal axis
        left.setLocation(center.getX()-(radiusA /2),center.getY());
        right.setLocation(center.getX()+(radiusA /2),center.getY());

        //returning the ball shaped
        ballFace = makeBall(center,radiusA,radiusB);
        //setting the ball's color and border color
        this.border = border;
        this.inner  = inner;
        //setting ball speed
        speedX = 0;
        speedY = 0;
    }
    
    //method to make ball 
    protected abstract Shape makeBall(Point2D center,int radiusA,int radiusB);

    //manages ball movement and manages speed
    /**
     * method to govern ball's movement
     */
    public void move()
    {
    	//typecast ballFace to rectangularShape
        RectangularShape tmp = (RectangularShape) ballFace;
        //place the ball at the center
        center.setLocation((center.getX() + speedX),(center.getY() + speedY));
        //rectangle frame dimensions
        double w = tmp.getWidth();
        double h = tmp.getHeight();
        
        //clearing rectangle and ball coordinates and resetting them to center
        tmp.setFrame((center.getX() -(w / 2)),(center.getY() - (h / 2)),w,h);
        setPoints(w,h);

        
        ballFace = tmp;
    }
    
    /**
     * ball speed setter
     * @param x
     * @param y
     */
    public void setSpeed(int x,int y)
    {
        speedX = x;
        speedY = y;
    }
    /**
     * speed setter x axis
     * @param s
     */
    public void setXSpeed(int s)
    {
        speedX = s;
    }
    /**
     * speed setter y axis
     * @param s
     */
    public void setYSpeed(int s)
    {
        speedY = s;
    }
    /**
     * inverting the ball's speed on the x axis essentially defecting it
     */
    public void reverseX()
    {
        speedX *= -1;
    }
    /**
     * inverting the ball's speed on the y axis essentially defecting it
     */
    public void reverseY()
    {
        speedY *= -1;
    }
    /**
     * ball border color getter method
     * @return
     */
    public Color getBorderColor()
    {
        return border;
    }
    /**
     * ball inner color getter method
     * @return
     */
    public Color getInnerColor()
    {
        return inner;
    }
    /**
     * center position getter
     * @return
     */
    public Point2D getPosition()
    {
        return center;
    }
    /**
     * ball shape getter
     * @return
     */
    public Shape getBallFace()
    {
        return ballFace;
    }

    //move ball to specific point
    /**
     * moving the ball to a specific point
     * @param p
     */
    public void moveTo(Point p)
    {
        center.setLocation(p);

        RectangularShape tmp = (RectangularShape) ballFace;
        double w = tmp.getWidth();
        double h = tmp.getHeight();

        tmp.setFrame((center.getX() -(w / 2)),(center.getY() - (h / 2)),w,h);
        ballFace = tmp;
    }

    /**
     * centering the ball in the screen
     * @param width
     * @param height
     */
    private void setPoints(double width,double height)
    {
        up.setLocation(center.getX(),center.getY()-(height / 2));
        down.setLocation(center.getX(),center.getY()+(height / 2));
        left.setLocation(center.getX()-(width / 2),center.getY());
        right.setLocation(center.getX()+(width / 2),center.getY());
    }
    /**
     * ball speed x axis getter method
     * @return
     */
    public int getSpeedX()
    {
        return speedX;
    }
    /**
     * ball speed y axis getter method
     * @return
     */
    public int getSpeedY()
    {
        return speedY;
    }

    //setter and getters for ball coordinates
    /**
     * setter ball coordinates up
     * @param up
     */
    public void setUp(Point2D up)
    {
    	this.up = up;
    }
    /**
     * getter ball coordinates up
     * @return
     */
    public Point2D getUp()
    {
    	return up;
    }
    /**
     * setter ball coordinates down
     * @param down
     */
    public void setDown(Point2D down)
    {
    	this.down = down;
    }
    /**
     * getter ball coordinates down
     * @return
     */
    public Point2D getDown()
    {
    	return down;
    }
    /**
     * setter ball coordinates right
     * @param right
     */
    public void setRight(Point2D right)
    {
    	this.right = right;
    }
    /**
     * getter ball coordinates right
     * @return
     */
    public Point2D getRight()
    {
    	return right;
    }
    /**
     * setter ball coordinates left
     * @param left
     */
    public void setLeft(Point2D left)
    {
    	this.left = left;
    }
    /**
     * getter ball coordinates left
     * @return
     */
    public Point2D getLeft()
    {
    	return left;
    }
    

}
