package csc143.data_structures;
/**
 *This is the interface for an Unbounded Queue
 *@author James Dansie
 *@version PA3 - Stack/Queue Link List CSC143
 */
public interface UnboundedQueue {
    /**
     *Adds an object to the end of the queue
     *@param o the object that is to be added
     */
    public void enqueue(Object o); 
    /**
     *Removes an object from the front of the queue
     *@return The object that was removed
     *@throws UnderemptyException will throw an exception if it tries to remove from an empty queue.
     */
    public Object dequeue() throws UnderemptyException;
    /**
     *Grants a peek at the next item to be removed. Does not affect the queue
     *@return The object that would have been removed.
     */  
    public Object peek();
    /**
     *Checks if the queue has items
     *@return true if the queue has items
     */
    public boolean hasItems();
}