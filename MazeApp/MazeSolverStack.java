

/**
 * Write a description of class MazeSolverStack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MazeSolverStack extends MazeSolver
{
    private Maze maze;
    private Square end;
    private MyStack<Square> workList;
    
    //constructor
    public MazeSolverStack(Maze m)
    {
        super(m);
    }
    
    //create an empty worklist
    public void makeEmpty()
    {
        workList = new MyStack<Square>();
    }
    
    public boolean isEmpty()
    {
        return workList.isEmpty();
    }
    
    public void add(Square sq)
    {
        workList.push(sq);
    }
    
    public Square next()
    {
        return workList.pop();
    }
}
