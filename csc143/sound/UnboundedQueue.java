package csc143.sound;

public interface UnboundedQueue<E> {
    public void enqueue(E o); 
    public E dequeue() throws UnderemptyException; 
    public E peek() throws UnderemptyException;
    public boolean hasItems();
}
