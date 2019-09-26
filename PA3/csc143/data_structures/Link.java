package csc143.data_structures;
/**
 *This is the link code for a linked list
 *@author Dan Jinguji
 *@version PA3 - Stack/Queue Link List CSC143
 */
class Link{
    //data of the link
    Object item;
    
    //next Link
    Link next;
    
    public Link(Object item, Link next){
        this.item = item;
        this.next = next;
    }
}//end Link