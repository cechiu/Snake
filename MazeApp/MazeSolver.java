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
    
    //create an empty worklist
    public abstract void makeEmpty();
    
    //return true if the worklist is empty
    public abstract boolean isEmpty();
    
    //add the given square to the worklist
    public abstract void add(Square sq);
    
    //return the "next" item from the worklist
    public abstract Square next();
    
    //constructor
    public MazeSolver(Maze m)
    {
        maze = m;
        makeEmpty();
        add(maze.getStart());
    }
    
    public boolean isSolved()
    {
        ArrayList<Square> checkNeighbors = maze.getNeighbors(end); //checks to see if any space around the end space is explored
        boolean yesaround = false;
        for (int count = 0; count < checkNeighbors.size(); count++)
        {
            if (checkNeighbors.get(count).state == Square.State.EXPLORED) //if there is a space around it that is 'o'
            {
                yesaround = true;
            }
        }
        if (this.isEmpty())
        {
            return true;
        }
        else if (this.getPath().charAt(0) != 'N')
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public String getPath()
    {
        if (this.isEmpty()) //it isn't solved
        {
            return "No path found"; //no way to get out of maze
        }
        else //it is solved
        {
            String path = "[ " + end.getRow() + ", " + end.getCol() + "]";
            end.getPrevious().state = Square.State.FINALPATH;
            Square previous = end.getPrevious();
            path = "[ " + end.getRow() + ", " + end.getCol() + "]";
            while (previous.getPrevious().getType() != '2')
            {
                previous = previous.getPrevious(); //goes to the next earliest all the way back to the start (2)
                previous.state = Square.State.FINALPATH;
                path = "[ " + end.getRow() + ", " + end.getCol() + "]";
            }
            path = "[ " + maze.getStart().getRow() + ", " + maze.getStart().getCol() + "]";
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
            end = current;
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