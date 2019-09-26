package csc143.data_structures;
/**
 *This class makes a bounded queue with a simple array list
 *@author James Dansie
 *@version PA4 - Stack/Queue Array Implemenatation
 */
public class BoundedQueue_Array<E> implements BoundedQueue<E>{
    /**
     *This field stores the lsit
     */
    private SimpleArrayList<E> queue;
    
    /**
     *This field stores the max size of the list
     */
    private int max;
    
    /**
     *This is the queue constructor
     *@param max The maximum size of the queue
     */
    @SuppressWarnings("unchecked")
    public BoundedQueue_Array(int max){
        queue = new SimpleArrayList(max);
        this.max = max;
    }
    
    /**
     *This will add an object to the front of the queue
     *@param o the object to be added
     *@throws OverfillException if the queue is too full this exception will be thrown.
     */
    public void enqueue(E o) throws OverfillException{
        if(queue.size() >= max){
            throw new OverfillException("The queue is too full");
        }
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
     *Checks if the queue has room for more objects
     *@return true if there is still room available.
     */
    public boolean hasRoom(){
        return max > queue.size()+1;
    }
    
    /**
     *Checks if the queue has any items
     *@return true if there are items in the queue
     */
    public boolean hasItems(){
        return ! queue.isEmpty();
    }
}