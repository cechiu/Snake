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
    private Square end;
    private MazeSolver workList;
    private boolean isFound;
    
    //constructor
    public MazeSolver(Maze m)
    {
        maze = m;
        this.isFound = false;
        this.makeEmpty();
        this.add(maze.getStart());
        end = maze.getFinish();
    }
    
    //create an empty worklist
    public abstract void makeEmpty();
    
    //return true if the worklist is empty
    public abstract boolean isEmpty();
    
    //add the given square to the worklist
    public abstract void add(Square sq);
    
    //return the "next" item from the worklist
    public abstract Square next();
    
    public boolean isSolved()
    {
        return (this.isFound || this.isEmpty());
    }
    
    public String getPath()
    {
        //if it isn't solved
        if (!this.isSolved())
        {
            return "Not finished yet.";
        }
        
        //if it is solved
        if (this.isEmpty())
        {
            return "No such path exists.";
        }
        else
        {
            String path = "[" + end.getRow() + "," + end.getCol() + "]";
            //retracing steps and putting everything on the final path
            end.getPrevious().state = Square.State.FINALPATH;
            Square previous = end.getPrevious();
            path = "[" + previous.getRow() + "," + previous.getCol() + "]" + path;
            while (previous.getPrevious().getType() != '2')
            {
                previous = previous.getPrevious();
                previous.state = Square.State.FINALPATH;
                path = "[" + previous.getRow() + "," + previous.getCol() + "]" + path;
            }
            path = "[" + maze.getStart().getRow() + "," + maze.getStart().getCol() + "]" + path;
            return path;
        }
    }
    
    public Square step()
    {
        //Is the worklist empty? If so, the exit is unreachable; terminate the algorithm.
        if (this.isEmpty())
        {
            System.out.println("The exit is unreacheable...");
            return null;
        }
        
        //Otherwise, grab the "next" location to explore from the worklist.
        //Does the location correspond to the exit square?
        Square current = this.next();
        if (current.getType() == '3')
        {
            this.isFound = true;
            this.getPath();
            end = current;
            return current;
        }
        
        //Otherwise, it is a reachable non-finish location that we haven't explored yet
        //compute all the adjacent up, right, down, left locations that are inside the maze and aren't walls
        ArrayList<Square> add = maze.getNeighbors(current);
        current.state = Square.State.EXPLORED;
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
                testing.state = Square.State.ONLIST;
                this.add(testing);
            }
        }
        return current;
    }
    
    public void solve()
    {
        Square test = this.step();
        while (test.getType() != '3')
        {
            test = this.step();
        }
    }
}