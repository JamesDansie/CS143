package csc143.data_structures;
/**
 *This class is for an Unbounded Stack using a Linked List. Implements the unbounded stack interface.
 *@author James Dansie
 *@version PA3 - Stack/Queue Link List CSC143
 */
public class UnboundedStack_LinkedList implements UnboundedStack{
    /**
     *This field stores the stack as a linked list
     */
    private SimpleLinkedList stack;
    
    /**
     *This is the constructor for the stack
     */
    public UnboundedStack_LinkedList(){
        stack = new SimpleLinkedList();
    }
    /**
     *This will add an object to the top of the stack
     *@param o the object to be added
     */
    public void push(Object o){
        stack.add(o);
    }
    /**
     *This will remove an object from the top of the stack
     *@return The removed object
     *@throws UnderemptyException will throw an exception is the stack is empty
     */
    public Object pop() throws UnderemptyException{
        if(!hasItems()){
            throw new UnderemptyException("The stack is empty, can't pop anymore.");
        }else{
            return stack.removelast();
        }
    }
    /**
     *Grants a peek at the next item to be removed. Does not affect the stack
     *@return The object that would have been removed.
     */
    public Object peek(){
        return stack.stackpeek();
    }
    /**
     *Checks if the stack has any items
     *@return true if there are items in the stack
     */
    public boolean hasItems(){
        return stack.hasItems();
    }
}