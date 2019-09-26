package csc143.data_structures;
/**
 *This is the class for a linked list. Based on the lecture notes.
 *@author Dan Jinguji, James Dansie
 *@version PA3 - Stack/Queue Link List CSC143
 */
public class SimpleLinkedList{
    /**
     *This is the head of the chain
     */
    private Link first;
    /**
     *This is the tail of the chain
     */
    private Link last;
    /**
     *This tracks the number of links
     */
    private int numLinks;
    /**
     *This is the constructor.
     */
    public SimpleLinkedList(){
        first = null;
        last = null;
        numLinks = 0;
    }
    
    /**
     *This will add a new link in the chain, and point at the new link. It will increase numLink also.
     *@param o this is the object to be added
     *@return true if the link was added
     */
    public boolean add(Object o){
        Link newLink = new Link(o, null);
        if(first == null){
            first = newLink;
        }else{
            last.next = newLink;
        }
        last = newLink;
        numLinks++;
        return true;
    }
    
    /**
     *This clears out the list. By removing links to the objects, the objects are now available for garbage clean up.
     */
    public void clear(){
        first = null;
        last = null;
        numLinks = 0;
    }
    /**
     *This will get the object at a given position in the chain
     *@param pos will look at this position in the chain
     *@return will return the item from the given position
     */
    public Object get(int pos){      
        Link p = first;

        p = getLinkAtPos(pos);
        return p.item;
    }
    /**
     *This will return the Link at a given position in the chian.
     *@param pos will look for the link at this position
     *@return will return the link from the given position
     *@throws IndexOutOfBoundsException if looking for position outside of the list
     */
    private Link getLinkAtPos(int pos){
        if(pos<0 || pos >= numLinks){throw new IndexOutOfBoundsException();}

        Link p = first;
        for(int linknum=0; linknum<pos; linknum++){
            p=p.next;
        }
        return p;
    }
    /**
     *This will remove and return the object at a given position
     *@param pos will look for the object at this position
     *@return the object that was removed
     *@throws IndexOutOfBoundsException if looking outside of the list
     */
    public Object remove(int pos){
        if(pos<0 || pos >= numLinks){throw new IndexOutOfBoundsException();}
        
        Object removedElem;
        if(pos == 0){
            removedElem = first.item;
            first = first.next;
            if(first == null){
                last = null;
            }
        }else{
            Link prev = getLinkAtPos(pos-1);
            removedElem = prev.next.item;
            prev.next = prev.next.next;
            if(prev.next == null)
                last = prev;
        }
        numLinks--;
        return removedElem;
    }
    /**
     *This removes the last item from the stack
     *@return this is the last object from the stack
     *@throws IndexOutOfBoundsException will throw an exception if last item is removed
     */
    public Object removelast(){
        if(last == first){throw new IndexOutOfBoundsException("Can't remove only obejct");}
        return remove(numLinks-1);       
    }
    /**
     *This will compare numLinks to an outside integer.
     *@param max this is the number that numLink will compare against
     *@return will return true if numLinks is less than or equal to the parameter
     */
    public boolean hasRoom(int max){
        return (numLinks <= max);
    }
    /**
     *This will check if the list has any items.
     *@return will return true is numLinks is greater than or equal to 1
     */
    public boolean hasItems(){
        return (numLinks >= 1);
    }
    /**
     *This will return the object at the end of the list.
     *@return will return the object at the end of the list.
     */
    public Object stackpeek(){
        return get(numLinks-1);
    }
}