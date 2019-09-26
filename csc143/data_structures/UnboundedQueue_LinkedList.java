package csc143.data_structures;
/**
 *This class is for a Unbounded Queue using a Linked List. Implements the unbounded queue interface.
 *@author James Dansie
 *@version PA3 - Stack/Queue Link List CSC143
 */
public class UnboundedQueue_LinkedList implements UnboundedQueue{
    /**
     *This field stores the queue as a linked list.
     */
    private SimpleLinkedList queue;
    /**
     *This is the constructor for the queue
     */
    public UnboundedQueue_LinkedList(){
        queue = new SimpleLinkedList();
    }
    /**
     *Adds an object to the end of the queue
     *@param o the object that is to be added
     */
    public void enqueue(Object o){
        queue.add(o);
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
     *Checks if the queue has items
     *@return true if the queue has items
     */
    public boolean hasItems(){
        return queue.hasItems();
    }
}