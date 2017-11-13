/**
 * Neha Kaki
 * Creates an arbitrarily large stack
 */

import java.util.*;

public class MyStack<T> implements StackADT<T>
{
    //arraylist that is a stack
    private ArrayList<T> data;
    
    public MyStack()
    {
        data = new ArrayList<T>();
    }
    
    public void push(T item)
    {
        data.add(item);
    }
    
    public T pop() throws NoSuchElementException
    {
        if (data.size() == 0)
        {
            throw new NoSuchElementException();
        }
        else
        {
            return data.remove(data.size()-1);
        }
    }
    
    public T peek() throws NoSuchElementException
    {
        if (data.size() == 0)
        {
            throw new NoSuchElementException();
        }
        else
        {
            return data.get(data.size());
        }
    }
    
    public int size()
    {
        return data.size();
    }
    
    public boolean isEmpty()
    {
        if (data.size() ==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void clear()
    {
        data = null;
    }
}