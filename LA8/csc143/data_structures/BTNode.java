package csc143.data_structures;
/**
 *This is the class for an array list for LA8
 *@author James Dansie
 *@version LA8 - SimpleSet Check Level
 */
class BTNode<E>{
    /**
     *This field stores the data
     */
    public E item;
    /**This points to the left leaf*/
    public BTNode<E> left;
    /**This points to the right leaf*/
    public BTNode<E> right;
    /**
     *This method is a constructor that take one E input
     *@param item this is the item to be stored in the node
     */
    public BTNode(E item){
        this(item, null, null);
    }
    /**
     *This is a constructor for a binary search tree
     *@param item this is the item to be stored in the node
     *@param left this is the left leaf to be stored
     *@param right this is the right the right leaf to be stored.
     */
    public BTNode(E item, BTNode<E> left, 
                            BTNode<E> right){
        this.item = item;
        this.left = left;
        this.right = right;
    }
}