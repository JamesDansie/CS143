package csc143.data_structures;

public class test{
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
    }
}