package csc143.packages;
import csc143.packages.string.Double;
import csc143.packages.temp.Converter;
/**
 * A simple class that uses classes in named packages. For LA3
 *@author James Dansie
 *@version LA3 plus
 */
public class TempTable {

    /**
    * A program that prints out a temperature conversion table
    * @param args The command-line arguments
    */
    public static void main(String[] args) {
           
        // print out headers
        System.out.println("Celsius  Fahrenheit");
          
        // print out values
        for(int row = 0; row <= 10; row++){
            System.out.print(Double.format1(row*10));
            System.out.println(Double.format3(Converter.c2f(row*10)));
        }
        
        //print out headers
        System.out.println("Fahrenheit  Celsius");        
        
        //print out values
        double[] Fs = {32, 52, 72, 92, 112, 132, 152, 172, 192, 212};
        for(int row=0; row < 10; row++){
            double F = Fs[row];
            System.out.print(Double.format1(F));
            double C = Converter.f2c(F);
            System.out.println(Double.format3(C));
        }
          
    }
   
}