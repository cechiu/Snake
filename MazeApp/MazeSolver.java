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
<<<<<<< HEAD
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
=======
>>>>>>> aba2ba7c4ac50c17be7b4a273d6fd8c7f4579043
    
    //create an empty worklist
    public abstract void makeEmpty();
    
    //return true if the worklist is empty
    public abstract boolean isEmpty();
    
    //add the given square to the worklist
    public abstract void add(Square sq);
    
    //return the "next" item from the worklist
    public abstract Square next();
    
<<<<<<< HEAD
    public boolean isSolved()
    {
        return (this.isFound || this.isEmpty());
=======
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
>>>>>>> aba2ba7c4ac50c17be7b4a273d6fd8c7f4579043
    }
    
    public String getPath()
    {
<<<<<<< HEAD
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
=======
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
>>>>>>> aba2ba7c4ac50c17be7b4a273d6fd8c7f4579043
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
<<<<<<< HEAD
            this.isFound = true;
            this.getPath();
=======
>>>>>>> aba2ba7c4ac50c17be7b4a273d6fd8c7f4579043
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