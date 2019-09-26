import csc143.data_structures.*;

public class test{
    public static void main(String[] args) throws OverfillException, UnderemptyException{
        System.out.println("**********Simple List*******");
        SimpleArrayList<String> list = new SimpleArrayList<String>();
        list.add("hi");
        list.add("hello");
        list.add("hope this works");
        System.out.println(list.get(0));
        System.out.println(list.get(2));
        list.add("Where did it go?");
        list.remove(2);
        System.out.println(list.get(2));
        
        System.out.println("**********UB stack*******");
        UnboundedStack_Array<String> ubstack = new UnboundedStack_Array<String>();
        ubstack.push("hi");
        ubstack.push("hello");
        ubstack.push("hope this works");
        System.out.println(ubstack.peek());
        System.out.println(ubstack.pop());
        System.out.println(ubstack.peek());
        ubstack.push("bye");
        System.out.println(ubstack.peek());
        System.out.println(ubstack.hasItems());
//         System.out.println(ubstack.pop()); //uncomment to make too small
//         System.out.println(ubstack.pop());
//         System.out.println(ubstack.pop());
//         System.out.println(ubstack.pop());        
        
        System.out.println("**********UB Queue*******");
        UnboundedQueue_Array<String> ubqueue = new UnboundedQueue_Array<String>();
        ubqueue.enqueue("hi");
        ubqueue.enqueue("hello");
        ubqueue.enqueue("hope this works");
        System.out.println(ubqueue.peek());
        System.out.println(ubqueue.dequeue());
        System.out.println(ubqueue.peek());
        System.out.println(ubqueue.hasItems());
//         System.out.println(ubqueue.dequeue()); //uncomment to make too small
//         System.out.println(ubqueue.dequeue());
//         System.out.println(ubqueue.dequeue());

        System.out.println("**********Bound stack*******");
        BoundedStack_Array<String> bstack = new BoundedStack_Array<String>(3);
        bstack.push("hi");
        bstack.push("hello");
        bstack.push("hope this works");
        System.out.println(bstack.peek());
        System.out.println(bstack.pop());
        System.out.println(bstack.peek());
        bstack.push("bye");
        //bstack.push("too much!"); //uncomment to make too big
//         System.out.println(bstack.pop()); //uncomment to make too small
//         System.out.println(bstack.pop());
//         System.out.println(bstack.pop());
        System.out.println(bstack.peek());
        System.out.println(bstack.hasItems());
        System.out.println(bstack.hasRoom());

        System.out.println("**********Bound Queue*******");
        BoundedQueue_Array<String> bqueue = new BoundedQueue_Array<String>(3);
        bqueue.enqueue("hi");
        bqueue.enqueue("hello");
        bqueue.enqueue("hope this works");
        //bqueue.enqueue("too big!"); //uncomment to make too big
        System.out.println(bqueue.peek());
        System.out.println(bqueue.dequeue());
        System.out.println(bqueue.peek());
//         System.out.println(bqueue.dequeue()); //uncomment to make too small
//         System.out.println(bqueue.dequeue());
//         System.out.println(bqueue.dequeue());
        System.out.println(bqueue.hasItems());
        System.out.println(bqueue.hasRoom());
    }
}