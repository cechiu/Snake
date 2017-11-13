

/**
 * Write a description of class MazeSolverQueue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MazeSolverQueue extends MazeSolver
{
<<<<<<< HEAD
    private Maze maze;
    private Square end;
    private MyQueue<Square> workList;
    
    public MazeSolverQueue(Maze m)
=======
    //QUEUE
    private Maze maze;
    private Square end;
    private MyQueue<Square> queue;
    
    //constructor
    public MazeSolverQueue (Maze m)
>>>>>>> aba2ba7c4ac50c17be7b4a273d6fd8c7f4579043
    {
        super(m);
    }
    
<<<<<<< HEAD
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
=======
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
>>>>>>> aba2ba7c4ac50c17be7b4a273d6fd8c7f4579043
    }
    
    public Square next()
    {
<<<<<<< HEAD
        return workList.dequeue();
=======
        return queue.dequeue();
>>>>>>> aba2ba7c4ac50c17be7b4a273d6fd8c7f4579043
    }
}
