package csc143.data_structures;
/**
 *This class makes a bounded stack with a simple array list
 *@author James Dansie
 *@version PA4 - Stack/Queue Array Implemenatation
 */
public class BoundedStack_Array<E> implements BoundedStack<E>{
    /**
     *This field stores the list
     */
    private SimpleArrayList<E> stack;
    
    /**
     *This field stores the max size of the list
     */
    private int max;
    
    /**
     *This is the stack constructor
     *@param max The maximum size of the stack
     */
    @SuppressWarnings("unchecked")
    public BoundedStack_Array(int max){
        stack = new SimpleArrayList(max);
        this.max = max;
    }
    
    /**
     *This will add an object to the top of the stack
     *@param o the object to be added
     *@throws OverfillException Will throw an exception if the stack is too full.
     */
    public void push(E o) throws OverfillException{
        if(stack.size() >= max){
            throw new OverfillException("The stack is too full");
        }
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
     *Checks if the stack has room for more objects
     *@return true if there is still room available.
     */
    public boolean hasRoom(){
        return max > stack.size()+1;
    }
    
    /**
     *Checks if the stack has any items
     *@return true if there are items in the stack
     */
    public boolean hasItems(){
        return ! stack.isEmpty();
    }
}