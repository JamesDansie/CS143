package csc143.data_structures;

public class test{

    public int doOvers(int a, int b){
        System.out.println("called doOvers("+a+", "+b+");");
        if(a == 0) return 1;
        if(b == 1) return 0;
        return a + doOvers(b-1, a-2);
    }

    public static void main(String[] args){
        SimpleTreeSet<String> tree = new SimpleTreeSet<String>();
        tree.add("5");
        tree.add("4");
        tree.add("7");
        tree.add("2");
        tree.add("3");
        tree.add("6");
        tree.add("9");
        tree.add("8");
        System.out.println(tree.contains("7"));
        //duplicate added
        //tree.add("5");
        System.out.println(tree);
        System.out.println(tree.size());
        tree.clear();
        System.out.println(tree.isEmpty());
        
        SimpleTreeSet<String> SAT = new SimpleTreeSet<String>();
        SAT.add(4);
        SAT.add(2);
        SAT.add(7);
        SAT.add(8);
        SAT.add(5);
        
        java.util.ArrayList<String> c = new java.util.ArrayList<String>();
        c.add("3");
        c.add("4");
        c.add("5");
        c.add("5");
        c.add("6");
        
        java.util.Iterator itr = c.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        test t = new test();
        System.out.println("The value is " + t.doOvers(5,4));
    }
}