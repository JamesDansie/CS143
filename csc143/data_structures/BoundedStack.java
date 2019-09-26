package csc143.data_structures;

public interface BoundedStack<E> {
    public void push(E o) throws OverfillException;
    public E pop() throws UnderemptyException;
    public E peek() throws UnderemptyException;
    public boolean hasRoom();
    public boolean hasItems();
}
