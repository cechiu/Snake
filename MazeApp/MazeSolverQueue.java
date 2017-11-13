

/**
 * Write a description of class MazeSolverQueue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MazeSolverQueue extends MazeSolver
{
    private Maze maze;
    private Square end;
    private MyQueue<Square> workList;
    
    public MazeSolverQueue(Maze m)
    {
        super(m);
    }
    
    public void makeEmpty()
    {
        workList = new MyQueue<Square>();
    }
    
    public boolean isEmpty()
    {
        return workList.isEmpty();
    }
    
    public void add(Square sq)
    {
        workList.enqueue(sq);
    }
    
    public Square next()
    {
        return workList.dequeue();
    }
}
