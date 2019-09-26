public class Berry extends Apple{
    public Berry(){
        System.out.println("Berry constructor");
    }
    public void snap(double d){
        System.out.println("d = "+d);
        System.out.println("pop: "+pop(d));
    }
    public int crackle(int w){
        System.out.println("w = "+w);
        snap(w);
        return w+5;
    }
    public int pop(int k){
        System.out.println("k = "+k);
        return k+3;
    }
}