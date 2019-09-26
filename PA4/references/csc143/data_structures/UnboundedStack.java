package csc143.data_structures;

public interface UnboundedStack<E> {
    public void push(E o);
    public E pop() throws UnderemptyException;
    public E peek() throws UnderemptyException;
    public boolean hasItems();
}
