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
package level;

import java.awt.*;
import java.awt.geom.Point2D;


import ball.Ball;
import ball.RubberBall;
import brick.Brick;
import brick.Crack;
import player.Player;

/**
 * 
 * Wall class which manages gameplay parts concerning the ball/brick interactions and their behaviors
 *
 */
public class Wall 
{

   

    
    private Rectangle area;

    private Brick[] bricks;
    private Ball ball;
    private Player player;
    private int score =0;

    private Brick[][] levels;
    private int level;
    

    private Point startPoint;
    private int brickCount;
    private int ballCount;
    private boolean ballLost;
    
    private int speedX;
    private int speedY;

    /**
     * Wal constructor
     * @param drawArea
     * @param ballPos
     */
    public Wall(Rectangle drawArea, Point ballPos)
    {
    	
        this.startPoint = new Point(ballPos);

        ballCount = 3;
        ballLost = false;
       
        
        speedX = 4;
        speedY = -4;
        

        makeBall(ballPos);
        

        ball.setSpeed(speedX,speedY);

        player = new Player((Point) ballPos.clone(),150,10, drawArea);

        area = drawArea;


    }

    /**
     * spawning ball
     * @param ballPos
     */
    private void makeBall(Point2D ballPos)
    {
        ball = new RubberBall(ballPos);
    }

    /**
     * moving ball and player
     */
    public void move()
    {
        player.move();
        ball.move();
    }
    
    /**
     * look for all impacts (with bricks screen edges or player model) 
     */
    public void findImpacts()
    {
        if(player.impact(ball))
        {
            ball.reverseY();
        }
        else if(impactWall())
        {
            /*for efficiency reverse is done into method impactWall
            * because for every brick program checks for horizontal and vertical impacts
            */
            brickCount--;
        }
        else if(impactBorder()) 
        {
            ball.reverseX();
        }
        else if(ball.getPosition().getY() < area.getY())
        {
            ball.reverseY();
        }
        else if(ball.getPosition().getY() > area.getY() + area.getHeight())
        {
            ballCount--;
            ballLost = true;
        }
    }
    /**
     * Ball impact with a brick and reversing the ball direction depending on direction of impact 
     * @return
     */
    private boolean impactWall()
    {
        for(Brick b : bricks){
            switch(b.findImpact(ball)) 
            {
                //Vertical Impact
                case Brick.UP_IMPACT:
                	score += 1;
                    ball.reverseY();
                    return b.setImpact(ball.getDown(), Crack.UP);
                case Brick.DOWN_IMPACT:
                	score +=1;
                    ball.reverseY();
                    return b.setImpact(ball.getUp(),Crack.DOWN);

                //Horizontal Impact
                case Brick.LEFT_IMPACT:
                	score +=1;
                    ball.reverseX();
                    return b.setImpact(ball.getRight(),Crack.RIGHT);
                case Brick.RIGHT_IMPACT:
                	score +=1;
                    ball.reverseX();
                    return b.setImpact(ball.getLeft(),Crack.LEFT);
            }
        }
        return false;
    }

    private boolean impactBorder()
    {
        Point2D p = ball.getPosition();
        return ((p.getX() < area.getX()) ||(p.getX() > (area.getX() + area.getWidth())));
    }
    /**
     * Brick count getter method
     * @return
     */
    public int getBrickCount()
    {
        return brickCount;
    }
    /**
     * Ball count getter method
     * @return
     */
    public int getBallCount()
    {
        return ballCount;
    }
    /**
     * determining is ball is lost
     * @return
     */
    public boolean isBallLost()
    {
        return ballLost;
    }
    /**
     * reseting ball to center and setting speed to zero
     */
    public void ballReset()
    {
        player.moveTo(startPoint);
        ball.moveTo(startPoint);
        ball.setSpeed(speedX,speedY);
        ballLost = false;
    }
    /**
     * reseting wall
     */
    public void wallReset()
    {
        for(Brick b : bricks)
            b.repair();
        brickCount = bricks.length;
        ballCount = 3;
    }
    /**
     * Determining when player is out of balls
     * @return
     */
    public boolean ballEnd()
    {
        return ballCount == 0;
    }
    /**
     * Checking is player destroyed all bricks
     * @return
     */
    public boolean isDone()
    {
        return brickCount == 0;
    }
    /**
     * Initiating next level
     */
    public void nextLevel()
    {
        bricks = levels[level++];
        this.brickCount = bricks.length;
    }

    public boolean hasLevel()
    {
        return level < levels.length;
    }
    /**
     * Ball x speed setter method
     * @param s
     */
    public void setBallXSpeed(int s)
    {
        ball.setXSpeed(s);
    }
    /**
     * Ball y speed setter method
     * @param s
     */
    public void setBallYSpeed(int s)
    {
        ball.setYSpeed(s);
    }
    /**
     * reseting ball count(lives) to 3
     */
    public void resetBallCount()
    {
        ballCount = 3;
    }

    /**
     * birck getter method
     * @return
     */
    public Brick[] getBricks() 
    {
        return bricks;
    }
    /**
     * Brick setter method
     * @param bricks
     */
    public void setBricks(Brick[] bricks) 
    {
        this.bricks = bricks;
    }
    /**
     * ball getter method
     * @return
     */
    public Ball getBall() 
    {
        return ball;
    }
    /**
     * ball setter method
     * @param ball
     */
    public void setBall(Ball ball) 
    {
        this.ball = ball;
    }
    /**
     * player getter method
     * @return
     */
    public Player getPlayer() 
    {
        return player;
    }
    /**
     * player setter method
     * @param player
     */
    public void setPlayer(Player player) 
    {
        this.player = player;
    }
    /**
     * Brick count setter method
     * @param brickCount
     */
    public void setBrickCount(int brickCount)
    {
        this.brickCount = brickCount;
    }
    /**
     * score getter method
     * @return
     */
    public int getScore()
    {
    	return score;
    }
    /**
     * score setter method
     * @param x
     */
    public void setScore(int x)
    {
    	score=x;
    }

}