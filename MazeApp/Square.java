/**
 * Neha Kaki
 * Help
 */

public class Square
{
    public enum State
    {
        UNEXPLORED, //_
        ONLIST, //o
        EXPLORED, //.
        FINALPATH, //x
    }
    
    //enum
    State state;
    
    //type of square
    int type;
    static int original;
    
    //defining four types
    int space = 0;
    int wall = 1;
    int start = 2;
    int end = 3;
    
    //where is this square?
    int row;
    int col;
    
    //what previous square added this one to the workList?
    Square previous;
    
    public Square(int r, int c, int t)
    {
        row = r;
        col = c;
        type = t;
        original = t;
        if (type == space)
        {
            state = State.UNEXPLORED;
        }
        previous = null;
    }
    
    public int getRow()
    {
        return row;
    }
    
    public int getCol()
    {
        return col;
    }
    
    public int getType()
    {
        return type;
    }
    
    public void setPrevious(Square sq)
    {
        previous = sq;
    }
    
    public Square getPrevious()
    {
        return previous;
    }
    
    public void reset()
    {
        type = original;
    }
    
    public String toString()
    {
        String s = "no nonononn nO";
        
        switch (type)
        {
            case 1: s = "#"; break;
            case 2: s = "S"; break;
            case 3: s = "E"; break;
            
            case 0:
            switch (state)
            {
                case UNEXPLORED: s = "_"; break;
                case ONLIST: s = "o"; break;
                case EXPLORED: s = "."; break;
                case FINALPATH: s = "x"; break;
            }
        }
        
        return s;    
    }
}