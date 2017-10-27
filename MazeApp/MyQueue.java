/**
 * Write a description of class MyQueue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class MyQueue<T> implements QueueADT<T>
{
    private ArrayList<T> data;
    
    public MyQueue()
    {
        data = new ArrayList<T>();
    }
    
    public void enqueue(T item)
    {
        data.add(item);
    }
    
    public T dequeue() throws NoSuchElementException
    {
        if (data.size() == 0)
        {
            throw new NoSuchElementException();
        }
        else
        {
            return data.remove(0);
        }
    }
    
    public T front() throws NoSuchElementException
    {
        if (data.size() == 0)
        {
            throw new NoSuchElementException();
        }
        else
        {
            return data.get(0);
        }
    }
    
    public int size()
    {
        return data.size();
    }
    
    public boolean isEmpty()
    {
        if (data.size() == 0)
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