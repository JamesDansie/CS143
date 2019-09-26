package csc143.data_structures;
/**
 *This is the interface for a BoundedQueue
 *@author James Dansie
 *@version PA3 - Stack/Queue Link List CSC143
 */
public interface BoundedQueue {
    /**
     *Adds an object to the end of the queue
     *@param o the object that is to be added
     *@throws OverfillException will throw an exception if the queue is overfilled.
     */
    public void enqueue(Object o) throws OverfillException; 
    
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