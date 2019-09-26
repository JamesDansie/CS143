package csc143.data_structures;
/**
 *This class is for a Bounded Stack using a Linked List. Implements the bounded stack interface.
 *@author James Dansie
 *@version PA3 - Stack/Queue Link List CSC143
 */
public class BoundedStack_LinkedList implements BoundedStack{
    /**
     *Stores the stack as a linked list
     */
    private SimpleLinkedList stack;
    /**
     *Stores the maximum size of the stack
     */
    private int max;
    /**
     *This is the contructor for the stack
     *@param max the maximum size of the stack
     */
    public BoundedStack_LinkedList(int max){
        stack = new SimpleLinkedList();
        this.max = max;
    }
    /**
     *This will add an object to the top of the stack
     *@param o the object to be added
     *@throws OverfillException Will throw an exception if the stack is too full.
     */
    public void push(Object o) throws OverfillException{
        if(!this.hasRoom()){
            throw new OverfillException("The stack is too full");
        }else{
            stack.add(o);
        }
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
    /**
     *Checks if the stack has room for more objects
     *@return true if there is still room available.
     */
    public boolean hasRoom(){
        return stack.hasRoom(max-1);
    }
}