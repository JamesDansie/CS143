package csc143.packages.string;

/**
 * A class to handle conversion of double values to String representations.
 *@author James Dansie
 *@version LA3 plus
 */
public class Double {

   /**
    * Creates a String representation of the given double value.
    * The string representation will have one place following the
    * decimal point and be right justified within an output string
    * of six characters.
    * @param value  The double value to be formatted
    * @return       The formatted string
    */
   public static String format1(double value) {
   
      return String.format("%6.1f", value);
      
   }
   
   /**
    * Creates a String representation of the given double value.
    * The string representation will have three places following the
    * decimal point and be right justified within an output string
    * of twelve characters.
    * @param value  The double value to be formatted
    * @return       The formatted string
    */
   public static String format3(double value) {
   
      return String.format("%12.3f", value);
      
   }
   
   /**
    * Creates a String representation of the given double value.
    * @param value  The double value to be formatted
    * @param places The number of places after the decimal point
    * @param width  The length of the output String. The value will be
    *               right justified within the output String.
    * @return       The formatted string
    */
   public static String format(double value, int places, int width) {
   
      return String.format("%"+width+"."+places+"f", value);
      
   }
   
}