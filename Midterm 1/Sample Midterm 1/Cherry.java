public class Cherry extends Berry{
    public Cherry(){
        System.out.println("Cherry constructor");
    }
    public void snap(int s){
        System.out.println("s = "+s);
        System.out.println("pop: "+pop(s) + 3);
    }
    public int pop(int r){
        System.out.println("r = "+r);
        return super.pop(r)-1;
    }
    public static void main(String[] args){
//             Berry b = new Berry();
//             b.snap(2.5 < 3);
//             System.out.println(b.pop(5));

//         Berry z = new Cherry();
//         int p = z.pop(5);
//         z.snap(p=8);
        
        Apple y = new Berry();
        System.out.println("crackle: "+y.crackle(4));
        y.snap(4.5);
        
        Cherry n = new Berry();
        int r = n.pop(7);
        System.out.println(n.crackle(r+1));
    }
}