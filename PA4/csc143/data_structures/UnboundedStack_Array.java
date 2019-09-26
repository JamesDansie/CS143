package csc143.data_structures;
/**
 *This class makes a unbounded stack with a simple array list
 *@author James Dansie
 *@version PA4 - Stack/Queue Array Implemenatation
 */
public class UnboundedStack_Array<E> implements UnboundedStack<E>{
    /**
     *This field stores the list
     */
    private SimpleArrayList<E> stack;
    
    /**
     *This is the stack constructor
     */
    @SuppressWarnings("unchecked")
    public UnboundedStack_Array(){
        stack = new SimpleArrayList();
    }
    
    /**
     *This will add an object to the top of the stack
     *@param o the object to be added
     */
    public void push(E o){
        stack.add(o);
    }
    
    /**
     *This will remove an object from the top of the stack
     *@return The removed object
     *@throws UnderemptyException will throw an exception is the stack is empty
     */
    public E pop() throws UnderemptyException{
        if( ! this.hasItems()){
            throw new UnderemptyException("The stack is empty, can't pop anymore.");
        }
        return stack.remove(stack.size()-1);
    }
    
    /**
     *Grants a peek at the next item to be removed. Does not affect the stack
     *@return The object that would have been removed.
     *@throws UnderemptyException will throw an exception is the stack is empty
     */
    public E peek() throws UnderemptyException{
        if( ! this.hasItems()){
            throw new UnderemptyException("The stack is empty, can't pop anymore.");
        }
        return stack.get(stack.size()-1);
    }
    
    /**
     *Checks if the stack has any items
     *@return true if there are items in the stack
     */
    public boolean hasItems(){
        return ! stack.isEmpty();
    }
}