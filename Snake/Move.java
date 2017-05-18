/**
 * Neha Kaki and Claire Chiu
 * Final Project - Snake Game
 * Move Class - allows snake to move using arrow keys on keyboard
 */

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Move
{
    //used to change direction of snake
    public void keyPressed(KeyEvent e)
    {
        //the key that was pressed
        int key = e.getKeyCode();
        
        //what direction the snake is moving in
        //(initially all are set at false)
        boolean rightDirection = false;
        boolean leftDirection = false;
        boolean upDirection = false;
        boolean downDirection = false;
        
        //if the left arrow key was pressed
        //and snake is not moving right
        if ((key == KeyEvent.VK_LEFT) && (!rightDirection))
        {
            //now snake will go left
            leftDirection = true;
            //all the directions the snake will NOT be going in
            upDirection = false;
            downDirection = false;
            rightDirection = false;
        }
        
        //cannot be else if because user must be able to
        //press anything at any time
        
        //right
        if ((key == KeyEvent.VK_RIGHT) && (!leftDirection))
        {
            rightDirection = true;
            upDirection = false;
            downDirection = false;
            leftDirection = false;
        }
        
        //up
        if ((key == KeyEvent.VK_UP) && (!downDirection))
        {
            upDirection = true;
            rightDirection = false;
            leftDirection = false;
            downDirection = false;
        }
        
        //down
        if ((key == KeyEvent.VK_DOWN) && (!upDirection))
        {
            downDirection = true;
            rightDirection = false;
            leftDirection = false;
            upDirection = false;
        }
    }
}
