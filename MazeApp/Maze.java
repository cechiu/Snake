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
    int cols; //wrong!

    public Maze()
    {
    }
<<<<<<< HEAD

=======
    
>>>>>>> aba2ba7c4ac50c17be7b4a273d6fd8c7f4579043
    public int getRows()
    {
        return rows;
    }
<<<<<<< HEAD

=======
    
>>>>>>> aba2ba7c4ac50c17be7b4a273d6fd8c7f4579043
    public int getCols()
    {
        return cols;
    }
<<<<<<< HEAD

=======
    
>>>>>>> aba2ba7c4ac50c17be7b4a273d6fd8c7f4579043
    public boolean loadMaze(String fileName)
    {
        /*
        rows = 0;
        cols = 0;
        File mazeFile = new File(fileName);
        Scanner scan = null;

        try
        {
            scan = new Scanner(mazeFile);
            //read the number of rows and cols
            rows = in.nextInt();
            cols = in.nextInt();

            this.maze = new Square[rows][cols];

            //read the maze
            for (int col = 0; col < cols; col++)
            {
                for (int row = 0; row < rows; row++)
                {
                    int type = scan.nextInt();
                    this.maze[row][col]
        */

        //let's create a scanner
        Scanner scan;
        try //does the file exist??????
        {
            scan = new Scanner(new File(fileName));
            //System.out.print("reached try");
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
        cols = scan.nextInt();

        //let's populate maze!!!!
        this.maze = new Square[rows][cols];

        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < cols; col++)
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
        if (row + 1 < this.rows)
        {
            neighbors.add(maze[row + 1][col]);
        }
        if (col - 1 >= 0)
        {
            neighbors.add(maze[row][col - 1]);
        }
        if (col + 1 < this.cols)
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
        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < cols; col++)
            {
                maze[row][col].reset();
            }
        }
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < cols; c++)
            {
                sb.append(this.maze[r][c].toString() + " ");
            }
            sb.append("\n");
        }
        
        return new String(sb);
    }
}
