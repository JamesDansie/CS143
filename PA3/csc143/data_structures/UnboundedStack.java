package csc143.data_structures;
/**
 *This is the interface for a unbounded Stack using a Linked List.
 *@author James Dansie
 *@version PA3 - Stack/Queue Link List CSC143
 */
public interface UnboundedStack {
    /**
     *This will add an object to the top of the stack
     *@param o the object to be added
     */
    public void push(Object o);
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
     *Checks if the stack has any items
     *@return true if there are items in the stack
     */
    public boolean hasItems();
}