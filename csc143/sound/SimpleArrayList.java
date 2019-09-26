package csc143.sound;
/**
 *This is the class for an array list for PA4
 *@author James Dansie
 *@version PA4 - ArrayList
 */
import java.util.*;
 
public class SimpleArrayList<E> {
//implements List{
    /**
     *Holds the list
     */
    private E[] elements;
    /**Keeps track of size*/
    private int numElems;
    /** default capacity */
    private static final int defaultCapacity = 10;
     
    /**
     *Constructor with specified capacity
     *@param capacity the initial capacity of the list
     */
    @SuppressWarnings("unchecked")
    public SimpleArrayList(int capacity){
        elements = (E[]) new Object[capacity];
        numElems = 0;
    }
    /**Constructor with default capacity */
    public SimpleArrayList(){
        this(defaultCapacity);
    }
    
    /**
     *Gets the size
     *@return returns the number of elements as size
     */
    public int size(){
        return numElems;
    }
    /**
     *Checks if the list is empty
     *@return true if numElems is zero
     */
    public boolean isEmpty(){
        return (numElems == 0);
    }
    
    /**
     *Will ensure that elements[] has enough space
     *@param extraCapacity the amount of space to be checked
     */
    @SuppressWarnings("unchecked")
    private void ensureExtraCapacity(int extraCapacity){
        //check if we need to grow
        if(numElems + extraCapacity > elements.length){
            int newCapacity = elements.length * 2 + extraCapacity;
            E[] newElements = (E[]) new Object[newCapacity];
            for(int row = 0; row < numElems; row++){
                newElements[row] = elements[row];
            }
            elements = newElements;
        }
    }
     
    /**
     *Adds the object to the end of the end of the list
     *@param obj the object to be added
     *@return true if successfully added
     */
    public boolean add(E obj){
        ensureExtraCapacity(1);
        elements[numElems] = obj;
        numElems++;
        return true;
    }
    
    /**
     *Add object at position
     *@param obj the object to be added
     *@param pos the position to add the object
     *@return true if successfully added
     */
    public boolean add(int pos, E obj){
        if(pos < 0 || pos >= numElems){
            throw new IndexOutOfBoundsException();
        }
        if(numElems >= elements.length){
            //out of room
            throw new RuntimeException("Ahhh! It's full!");
        }
        //preconditions met, make space
        for(int row = numElems - 1; row >= pos; row--){
            //count down and slide one to the right
            elements[row + 1] = elements[row];
        }
        numElems++;
        //store the object
        elements[pos] = obj;
        return true;
    }
    
    /**
     *Empty out the list and remove references
     */
    public void clear(){
        for(int k = 0; k < numElems; k++){
            elements[k] = null;
        }
        numElems = 0;
    }
    
    /**
     *Gets the object at a given location
     *@param pos the position of the object
     *@return the object at positoin
     */
    public E get(int pos){
        if(pos < 0 || pos >= numElems){
            throw new IndexOutOfBoundsException();
        }
        return elements[pos];
    }
    
    /**
     *returns the index of the first object that matches, otherwise returns -1
     *@param obj Object to be found
     *@return the index of the object
     */
    public int indexOf(E obj){
        for(int k = 0; k < size(); k++){
            E elem = get(k);
            if(elem.equals(obj)){
                //found the item
                return k;
            }
        }
        return -1;
    }
    
    /**
     *returns true if the object is in the list
     *@param obj the object to be found
     *@return true if the object is found
     */
    public boolean contains(E obj){
        return indexOf(obj) != -1;
    }
    
    /**
     *Remove the object at pos and return it.
     *@param pos the target position
     *@return the object at the position
     */
    public E remove(int pos){
        if(pos < 0 || pos >= numElems){
            throw new IndexOutOfBoundsException();
        }
        E removedElem = elements[pos];
        for(int k = pos+1; k < numElems; k++){
            //slide the k element to the left
            elements[k-1] = elements[k];
        }
        //erase the extra object at the end
        elements[numElems - 1] = null;
        numElems--;
        return removedElem;
    }
    
    /**
     *Remove the first occurence of the object, returns false if not found
     *@param obj the target object
     *@return return false if the object is not found
     */
    public boolean remove(E obj){
        int pos = indexOf(obj);
        if(pos != -1){
            remove(pos);
            return true;
        }else{
            return false;
        }
    }
    
    /**
     *Creates the iterator of the list
     *@return Iterator returns an iterator class of type E
     */
    public Iterator<E> iterator(){
        return new SimpleListIterator();
    }
    
    private class SimpleListIterator implements Iterator<E>{
        
        /**
         *position of the next element 
         */
        private int nextItemPos;
        //invariant: 0 <= nextItemPos <= list.size()
        
        /**
         *Constructor method of the iterator
         */
        public SimpleListIterator(){
            nextItemPos = 0;
        }
        
        /**
         *returns true if there are more objects in the list
         *@return true if there are more items in the list
         */
        public boolean hasNext(){
            return nextItemPos < size();
        }
        
        /**
         *returns the next item in the list. Changes the iterator, but not the list
         *@throws NoSuchElementException if the list doesn't have enough elements
         */
        public E next(){
            if( ! hasNext()){
                throw new NoSuchElementException();
            }
            E result = get(nextItemPos);
            nextItemPos++;
            return result;
        }
    }                                   
}