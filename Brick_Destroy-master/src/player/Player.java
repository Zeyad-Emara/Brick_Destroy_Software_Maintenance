/*
 *  Brick Destroy - A simple Arcade video game
 *   Copyright (C) 2017  Filippo Ranza
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package player;

import java.awt.*;

import ball.Ball;

//Player class is the rectangle shape that we control and we must connect with the ball
public class Player 
{

	//border color of rectangle
    public static final Color BORDER_COLOR = Color.GREEN.darker().darker();
    //inner color of rectangle
    public static final Color INNER_COLOR = Color.GREEN;
    //player move rate
    private static final int DEF_MOVE_AMOUNT = 7;

    private Rectangle playerFace;
    private Point ballPoint;
    private int moveAmount;
    private int min;
    private int max;


    public Player(Point ballPoint,int width,int height,Rectangle container) 
    {
        this.ballPoint = ballPoint;
        moveAmount = 0;
        playerFace = makeRectangle(width, height);
        //creating bounds for player movement
        min = container.x + (width / 2);
        max = min + container.width - width;

    }
    
    //rectangle shape constructor
    private Rectangle makeRectangle(int width,int height)
    {
        Point p = new Point((int)(ballPoint.getX() - (width / 2)),(int)ballPoint.getY());
        return  new Rectangle(p,new Dimension(width,height));
    }

    //checking if ball contacted rectangle(player)
    public boolean impact(Ball b)
    {
        return playerFace.contains(b.getPosition()) && playerFace.contains(b.getDown()) ;
    }

    //allowing player movement if the ball still present inside the gameframe
    public void move()
    {
        double x = ballPoint.getX() + moveAmount;
        if(x < min || x > max)
            return;
        ballPoint.setLocation(x,ballPoint.getY());
        playerFace.setLocation(ballPoint.x - (int)playerFace.getWidth()/2,ballPoint.y);
    }

    //player left movement
    public void moveLeft()
    {
        moveAmount = -DEF_MOVE_AMOUNT;
    }

    //player right movement
    public void movRight()
    {
        moveAmount = DEF_MOVE_AMOUNT;
    }

    //player movement stop
    public void stop()
    {
        moveAmount = 0;
    }

    public Shape getPlayerFace()
    {
        return  playerFace;
    }

    //moving the player bar to specific location in the game 
    public void moveTo(Point p)
    {
        ballPoint.setLocation(p);
        playerFace.setLocation(ballPoint.x - (int)playerFace.getWidth()/2,ballPoint.y);
    }
}
