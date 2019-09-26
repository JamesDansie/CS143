package csc143.data_structures;
/**
 *This is the interface for a Bounded Stack using a Linked List.
 *@author James Dansie
 *@version PA3 - Stack/Queue Link List CSC143
 */
public interface BoundedStack {
    /**
     *This will add an object to the top of the stack
     *@param o the object to be added
     *@throws OverfillException Will throw an exception if the stack is too full.
     */
    public void push(Object o) throws OverfillException;
    /**
     *This will remove an object from the top of the stack
     *@return The removed object
     *@throws UnderemptyException will throw an exception is the stack is empty
     */
    public Object pop() throws UnderemptyException;
    /**
     *Grants a peek at the next item to be removed. Does not affect the stack
     *@return The object that would have been removed.
     */ 
    public Object peek();
     /**
     *Checks if the stack has room for more objects
     *@return true if there is still room available.
     */
    public boolean hasRoom();
    /**
     *Checks if the stack has any items
     *@return true if there are items in the stack
     */
    public boolean hasItems();
}