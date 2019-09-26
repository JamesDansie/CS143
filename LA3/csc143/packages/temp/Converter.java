package csc143.packages.temp;

/**
 * A simple supplier class that converts temperature values.
 *@author James Dansie
 *@version LA3 plus
 */
public class Converter {

   /**
    * Converts Celsius to Fahrenheit.
    * @param value The Celsius temperature to be converted
    * @return      The calculated Fahrenheit temperature
    */
   public static double c2f(double value) {
   
      return 1.8*value+32;
      
   }
   /**
    *Converts Fahrenheit to Celsius
    *@param value The Fahrenheit temperature to be converted
    *@return the calculated Celsius temperature
    */
   public static double f2c(double value){
      return ((value-32)*(.5555555));
   }
   
}