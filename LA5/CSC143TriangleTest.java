//package csc143.junit;

import csc143.junit.*;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class CSC143TriangleTest {

        CSC143Triangle tri = new CSC143Triangle(4, 3);
   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
        
   }
   
   @Test public void heightTest(){
        
        Assert.assertEquals("Height?", 3, tri.getHeight());
   }
}
