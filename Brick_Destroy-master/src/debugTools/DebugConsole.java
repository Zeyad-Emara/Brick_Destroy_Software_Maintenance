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
package debugTools;

import javax.swing.*;

import ball.Ball;
import gui.GameBoard;
import level.LevelGenerator;
import level.Wall;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/**
 * 
 * DebugConsol class responsible for processing user interaction with debug menu
 *
 */
public class DebugConsole extends JDialog implements WindowListener
{

    private static final String TITLE = "Debug Console";


    private JFrame owner;
    private DebugPanel debugPanel;
    private GameBoard gameBoard;
    private Wall wall;
    private LevelGenerator level;

    /**
     * Creating debug menu interface
     * @param owner
     * @param wall
     * @param level
     * @param gameBoard
     */
    public DebugConsole(JFrame owner,Wall wall,LevelGenerator level,GameBoard gameBoard)
    {
    	this.level = level;
        this.wall = wall;
        this.owner = owner;
        this.gameBoard = gameBoard;
        initialize();

        debugPanel = new DebugPanel(wall,level);
        this.add(debugPanel,BorderLayout.CENTER);


        this.pack();
    }
    /**
     * Initializing debug menu interface
     */
    private void initialize()
    {
        this.setModal(true);
        this.setTitle(TITLE);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.addWindowListener(this);
        this.setFocusable(true);
    }


    private void setLocation()
    {
        int x = ((owner.getWidth() - this.getWidth()) / 2) + owner.getX();
        int y = ((owner.getHeight() - this.getHeight()) / 2) + owner.getY();
        this.setLocation(x,y);
    }


    @Override
    public void windowOpened(WindowEvent windowEvent) 
    {

    }

    @Override
    public void windowClosing(WindowEvent windowEvent) 
    {
        gameBoard.repaint();
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) 
    {

    }

    @Override
    public void windowIconified(WindowEvent windowEvent) 
    {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) 
    {

    }

    @Override
    public void windowActivated(WindowEvent windowEvent) 
    {
        setLocation();
        Ball b = wall.getBall();
        debugPanel.setValues(b.getSpeedX(),b.getSpeedY());
    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) 
    {

    }
}
