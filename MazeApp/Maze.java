/**
 * Neha Kaki
 * I need help
 */

import java.util.*;
import java.io.*;

public class Maze
{
    //the actual maze, full of squares
    Square[][] maze;
    
    //number of rows and cols
    int rows;
    int cols;
    
    public Maze()
    {
    }
    
    public boolean loadMaze(String fileName)
    {
        //let's create a scanner
        Scanner scan;
        try //does the file exist??????
        {
            scan = new Scanner(new File(fileName));
        }
        catch(FileNotFoundException e) //I guess not
        {
            System.out.println("Error " + e.getMessage());
            return false;
        }
        
        //count up rows plz
        String rowNum = scan.next();
        if (rowNum.length() == 1)
        {
            rows = (int) rowNum.charAt(0) - 48;
        }
        else
        {
            rows = (int) ((rowNum.charAt(0) - 48) * 10) + (rowNum.charAt(1) - 48);
        }
        
        //count up cols plz
        String colNum = scan.next();
        if (colNum.length() == 1)
        {
            cols = (int) colNum.charAt(0) - 48;
        }
        else
        {
            cols = (int) ((colNum.charAt(0) - 48) * 10) + (rowNum.charAt(1) - 48);
        }
        
        //let's populate maze!!!!
        this.maze = new Square[rows][cols];
        
        for (int col = 0; col < cols; col++)
        {
            for (int row = 0; row < rows; row++)
            {
                maze[row][col] = new Square(row, col, scan.next().charAt(0));
            }
        }
        
        return true;
    }
    
    public ArrayList<Square> getNeighbors(Square sq)
    {
        int row = sq.getRow();
        int col = sq.getCol();
        
        ArrayList<Square> neighbors = new ArrayList<Square>();
        
        //checking and adding four cardinal directions
        if (row - 1 >= 0)
        {
            neighbors.add(maze[row - 1][col]);
        }
        if (row + 1 >= 0)
        {
            neighbors.add(maze[row + 1][col]);
        }
        if (col - 1 >= 0)
        {
            neighbors.add(maze[row][col - 1]);
        }
        if (col + 1 >= 0)
        {
            neighbors.add(maze[row][col + 1]);
        }
        
        return neighbors;
    }
    
    public Square getStart() //going through the entire maze array and
    {                 //finding the square that has the start type
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < cols; c++)
            {
                if (this.maze[r][c].getType() == '2')
                {
                    return this.maze[r][c];
                }
            }
        }
        return new Square(0, 0, '0');
    }
    
    public Square getFinish() //going through the entire maze array and
    {                 //finding the square that has the end type
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < cols; c++)
            {
                if (this.maze[r][c].getType() == '3')
                {
                    return this.maze[r][c];
                }
            }
        }
        return new Square(0, 0, '0');
    }
    
    public void reset()
    {
        for (int col = 0; col < cols; col++)
        {
            for (int row = 0; row < rows; row++)
            {
                maze[row][col].reset();
            }
        }
    }
    
    public String toString()
    {
        for (int col = 0; col < cols; col++)
        {
            for (int row = 0; row < rows; row++)
            {
                System.out.print(maze[row][col]);
                System.out.print(" ");
            }
        }
        
        return null;
    }
}
