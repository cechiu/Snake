

/**
 * Write a description of class MazeSolverQueue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MazeSolverQueue extends MazeSolver
{
    //QUEUE
    private Maze maze;
    private Square end;
    private MyQueue<Square> queue;
    
    //constructor
    public MazeSolverQueue (Maze m)
    {
        super(m);
    }
    
    public void add(Square sq)
    {
        queue.enqueue(sq);
    }
    
    public void makeEmpty()
    {
        queue = new MyQueue<Square>();
    }
    
    public boolean isEmpty()
    {
        return queue.isEmpty();
    }
    
    public Square next()
    {
        return queue.dequeue();
    }
}
