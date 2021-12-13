package ball;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;


abstract public class Ball 
{
	
	//ball outline
    private Shape ballFace;
    
    //ball coordinates 
    private Point2D center;
    private Point2D up;
    private Point2D down;
    private Point2D left;
    private Point2D right;
    
    //border color
    private Color border;
    //ball color
    private Color inner;
    
    //ball speed
    private int speedX;
    private int speedY;
    
    //ball class constructor, initializes then sets values for the ball coordinates, ball color and border color, and ball speed
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

    public void setSpeed(int x,int y)
    {
        speedX = x;
        speedY = y;
    }

    public void setXSpeed(int s)
    {
        speedX = s;
    }

    public void setYSpeed(int s)
    {
        speedY = s;
    }

    public void reverseX()
    {
        speedX *= -1;
    }

    public void reverseY()
    {
        speedY *= -1;
    }

    public Color getBorderColor()
    {
        return border;
    }

    public Color getInnerColor()
    {
        return inner;
    }

    public Point2D getPosition()
    {
        return center;
    }

    public Shape getBallFace()
    {
        return ballFace;
    }

    //move ball to specific point
    public void moveTo(Point p)
    {
        center.setLocation(p);

        RectangularShape tmp = (RectangularShape) ballFace;
        double w = tmp.getWidth();
        double h = tmp.getHeight();

        tmp.setFrame((center.getX() -(w / 2)),(center.getY() - (h / 2)),w,h);
        ballFace = tmp;
    }

    private void setPoints(double width,double height)
    {
        up.setLocation(center.getX(),center.getY()-(height / 2));
        down.setLocation(center.getX(),center.getY()+(height / 2));

        left.setLocation(center.getX()-(width / 2),center.getY());
        right.setLocation(center.getX()+(width / 2),center.getY());
    }

    public int getSpeedX()
    {
        return speedX;
    }

    public int getSpeedY()
    {
        return speedY;
    }

    //setter and getters for ball coordinates
    public void setUp(Point2D up)
    {
    	this.up = up;
    }
    
    public Point2D getUp()
    {
    	return up;
    }
    
    public void setDown(Point2D down)
    {
    	this.down = down;
    }
    
    public Point2D getDown()
    {
    	return down;
    }
    
    public void setRight(Point2D right)
    {
    	this.right = right;
    }
    
    public Point2D getRight()
    {
    	return right;
    }
    
    public void setLeft(Point2D left)
    {
    	this.left = left;
    }
    
    public Point2D getLeft()
    {
    	return left;
    }
    

}
