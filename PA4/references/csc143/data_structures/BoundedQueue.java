package csc143.data_structures;

public interface BoundedQueue<E> {
    public void enqueue(E o) throws OverfillException; 
    public E dequeue() throws UnderemptyException; 
    public E peek() throws UnderemptyException;
    public boolean hasRoom();
    public boolean hasItems();
}
