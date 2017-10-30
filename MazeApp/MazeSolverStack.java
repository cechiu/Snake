

/**
 * Write a description of class MazeSolverStack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MazeSolverStack extends MazeSolver
{
    //STACK
    private Maze maze;
    private Square end;
    private MyStack<Square> stack;
    
    //constructor
    public MazeSolverStack (Maze m)
    {
        super(m);
    }
    
    public void add(Square sq)
    {
        stack.push(sq);
    }
    
    public void makeEmpty()
    {
        stack = new MyStack<Square>();
    }
    
    public boolean isEmpty()
    {
        return stack.isEmpty();
    }
    
    public Square next()
    {
        return stack.pop();
    }
}
