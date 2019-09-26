package csc143.data_structures;
/**
 *This is the class for an array list for LA8
 *@author James Dansie
 *@version LA8 - SimpleSet Check Level
 */

//did implement SimpleSet
public class SimpleTreeSet<E> implements SimpleSet<E>{
    /**
     *This field stores the overall root
     */
    private BTNode<E> root;
    /**
     *This constructor creates an empty tree
     */
    public SimpleTreeSet(){
        root = null;
    }
    /**
     *This method searchs to see if E is contained in the set
     *@param e This is the item to be searched for
     *@return Will read true if e is contained in the set
     */
    public boolean contains(E e){
        return subtreeContains(root, (Comparable) e);
    }
    /**
     *This method searches the tree recursively looking for e
     *@param e the item to be looked for
     *@return Will return true if the item is contained in the tree
     */
    @SuppressWarnings("unchecked")
    private boolean subtreeContains(BTNode<E> r, Comparable e){
        if(r == null){
            return false;
        }else{
            int comp = e.compareTo(r.item);
            if(comp == 0){return true;}
            else if(comp < 0){ return subtreeContains(r.left, e);}
            else{return subtreeContains(r.right, e);}
        }
    }
    /**
     *This method adds the object to the tree
     *@param elem The element to be added
     *@return Will return true if the item is added
     */
    public boolean add(Object elem){
        try{
            root = addToSubtree(root, (Comparable) elem);
            return true;
        }catch(DuplicateAdded e){
            //debugging code
            System.out.println("Duplicate added");
            return false;
        }
    }
    /**
     *This method will add the object to the tree
     *@param r this is the root to be added
     *@param elem this is the item to be added
     *@return Will return the new tree structure
     */
    @SuppressWarnings("unchecked")
    private BTNode<E> addToSubtree(BTNode<E> r, Comparable elem) 
    throws DuplicateAdded{
        
        if(r == null){return new BTNode<E>((E) elem, null, null);}
        int comp = elem.compareTo(r.item);
        if(comp == 0){throw new DuplicateAdded("Duplicate added");}
        if(comp < 0){
            r.left = addToSubtree(r.left, elem);
        }else{
            r.right = addToSubtree(r.right, elem);
        }
        return r;
    }
    /**
     *This will return a string representation of the tree in pre order traversal
     *@return a string of the tree in preorder
     */
    public String toString(){
        return printPreorder(root, "");
    }
    /**
     *This will return a string of the tree in preorder traversal with empty leafs being "()"
     *@param r Binary Search Tree root
     *@param str string of the tree
     *return the full string of the tree
     */
    private String printPreorder(BTNode<E> r, String str){
        if(r == null){
            str += "()";
        }else if(r != null){
            str += "(" + r.item + " ";
            str += printPreorder(r.left, "");
            str += printPreorder(r.right, "")+")";
        }
        return str;
    }
    /**
     *counts the size of the tree
     *@return the size of the tree
     */
    public int size(){
        return subtreeSize(root);
    }
    /**
     *Counts the size of the tree
     *@param r the node of the tree
     *@return the size of the tree
     */
    private int subtreeSize(BTNode<E> r){
        if(r == null){
            return 0;
        }else{
            return 1 + subtreeSize(r.left) + subtreeSize(r.right);
        }
    }
    /**
     *Checks to see if the tree is empty
     *@return true if empty
     */
    public boolean isEmpty(){
        if(root == null){
            return true;
        }else{
            return false;
        }
    }
    /**
     *Clears out the tree
     */
    public void clear(){
        root = null;
    }
}