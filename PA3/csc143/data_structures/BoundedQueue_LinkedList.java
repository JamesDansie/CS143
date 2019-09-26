package csc143.data_structures;
/**
 *This class is for a Bounded Queue using a Linked List. Implements the bounded queue interface.
 *@author James Dansie
 *@version PA3 - Stack/Queue Link List CSC143
 */
public class BoundedQueue_LinkedList implements BoundedQueue{
    /**
     *This field stores the queue as a linked list.
     */
    private SimpleLinkedList queue;
    /**
     *This is the maximum size of the queue
     */
    private int max;
    
    /**
     *This is the queue constructor
     *@param max The maximum size of the queue
     */
    public BoundedQueue_LinkedList(int max){
        queue = new SimpleLinkedList();
        this.max = max;
    }
    
    /**
     *This will add an object to the front of the queue
     *@param o the object to be added
     *@throws OverfillException if the queue is too full this exception will be thrown.
     */
    public void enqueue(Object o) throws OverfillException{
        if(!this.hasRoom()){
            throw new OverfillException("The queue is too full");
        }else{
            queue.add(o);
        }
    }
    
    /**
     *Removes an object from the front of the queue
     *@return The object that was removed
     *@throws UnderemptyException will throw an exception if it tries to remove from an empty queue.
     */
    public Object dequeue() throws UnderemptyException{
        if(!this.hasItems()){
            throw new UnderemptyException("The queue is already empty");
        }else{
            return queue.remove(0);
        }
    }
    
    /**
     *Grants a peek at the next item to be removed. Does not affect the queue
     *@return The object that would have been removed.
     */ 
    public Object peek(){
        return queue.get(0);
    }
    
    /**
     *Checks if the queue has any items
     *@return true if there are items in the queue
     */
    public boolean hasItems(){
        return queue.hasItems();
    }
    
    /**
     *Checks if the queue has room for more objects
     *@return true if there is still room available.
     */
    public boolean hasRoom(){
        return queue.hasRoom(max-1);
    }
}