public class Main{
    public static void main(String[] args){
        Main.hello();
        run.Fido.hello();
        outer.inner.Lassie.hello();
    }
    public static void hello(){
        System.out.println("Hello World.");
    }
}