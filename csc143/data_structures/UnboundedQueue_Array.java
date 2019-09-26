package csc143.data_structures;
/**
 *This class makes an unbounded queue with a simple array list
 *@author James Dansie
 *@version PA4 - Stack/Queue Array Implemenatation
 */
public class UnboundedQueue_Array<E> implements UnboundedQueue<E>{
    /**
     *This field stores the lsit
     */
    private SimpleArrayList<E> queue;
    
    /**
     *This is the constructor for the queue
     */
    @SuppressWarnings("unchecked")
    public UnboundedQueue_Array(){
        queue = new SimpleArrayList();
    }
    
    /**
     *Adds an object to the end of the queue
     *@param o the object that is to be added
     */
    public void enqueue(E o){
        queue.add(o);
    }
    
    /**
     *Removes an object from the front of the queue
     *@return The object that was removed
     *@throws UnderemptyException will throw an exception if it tries to remove from an empty queue.
     */
    public E dequeue() throws UnderemptyException{
        if(queue.isEmpty()){
            throw new UnderemptyException("The queue is already empty");
        }else{
            return queue.remove(0);
        }
    }
    
    /**
     *Grants a peek at the next item to be removed. Does not affect the queue
     *@return The object that would have been removed.
     */ 
    public E peek() throws UnderemptyException{
        return queue.get(0);
    }
    
    /**
     *Checks if the queue has any items
     *@return true if there are items in the queue
     */
    public boolean hasItems(){
        return ! queue.isEmpty();
    }
}