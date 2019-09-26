public abstract class Apple{
    public Apple(){
        System.out.println("Apple Constructor");
    }
    public void snap(boolean i){
        System.out.println("i = "+i);
    }
    public abstract int crackle(int m);
    public double pop(double x){
        System.out.println("x = "+x);
        return x*2;
    }
}