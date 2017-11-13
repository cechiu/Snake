

/**
 * Write a description of class MazeSolverStack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MazeSolverStack extends MazeSolver
{
<<<<<<< HEAD
    private Maze maze;
    private Square end;
    private MyStack<Square> workList;
    
    //constructor
    public MazeSolverStack(Maze m)
=======
    //STACK
    private Maze maze;
    private Square end;
    private MyStack<Square> stack;
    
    //constructor
    public MazeSolverStack (Maze m)
>>>>>>> aba2ba7c4ac50c17be7b4a273d6fd8c7f4579043
    {
        super(m);
    }
    
<<<<<<< HEAD
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
=======
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
>>>>>>> aba2ba7c4ac50c17be7b4a273d6fd8c7f4579043
    }
    
    public Square next()
    {
<<<<<<< HEAD
        return workList.pop();
=======
        return stack.pop();
>>>>>>> aba2ba7c4ac50c17be7b4a273d6fd8c7f4579043
    }
}
