/**
 * Write a description of class MazeSolver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public abstract class MazeSolver
{
    //private maze variable
    private Maze maze;
    private abstract MazeSolver workList;
    
    //create an empty worklist
    public abstract void makeEmpty();
    
    //return true if the worklist is empty
    public abstract boolean isEmpty();
    
    //add the given square to the worklist
    public abstract void add(Square sq);
    
    //return the "next" item from the worklist
    public abstract Square next();
    
    public MazeSolver(Maze m)
    {
        maze = m;
    }
    
    public boolean isSolved()
    {
        
    }
    
    public String getPath()
    {
        
    }
    
    public Square step()
    {
        //Is the worklist empty? If so, the exit is unreachable; terminate the algorithm.
        if (isEmpty)
        {
            System.out.println("The exit is unreacheable...");
            return null;
        }
        
        //Otherwise, grab the "next" location to explore from the worklist.
        //Does the location correspond to the exit square?
        Square current = this.next();
        if (current.getType == '3')
        {
            return current;
        }
        
        //Otherwise, it is a reachable non-finish location that we haven't explored yet
        //compute all the adjacent up, right, down, left locations that are inside the maze and aren't walls
        ArrayList<Square> add = maze.getNeighbors(current);
        for (int count = 0; count < add.size(); count++)
        {
            Square testing = add.get(count);
            if (testing.getType() == '1') //tests to see if it is a wall
            {
                //does nothing, exits the if statement and is not added to the workList
            }
            else if (testing.getPrevious() != null) //tests to see if the square was alreadly added to the workList
            {
                //does nothing, exits the if statement and is not added to the workList
            }
            else
            {
                testing.setPrevious(current);
                this.add(testing);
            }
        }
    }
    
    public void solve()
    {
        
    }
}