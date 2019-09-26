package csc143.test.junit;
/**
 *This class if for testing CSC143Circle for LA5
 *@author James Dansie
 *@vesrion LA5 - JUnit Testing
 */
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import csc143.junit.*;

public class CSC143CircleTest {
        CSC143Circle circ = new CSC143Circle(4);
    
    /** Fixture initialization (common initialization
    *  for all tests). **/
    @Before public void setUp() {
        CSC143Circle circ = new CSC143Circle(4);
    }
    /**
     *This method tests the constructor under normal conditions
     */
    @Test public void constructorTest(){
        assertNotNull(circ);
    }
    /**
     *This method tests the constructor for the lower limit
     */
    @Test(expected = IllegalArgumentException.class) 
    public void constructorTestLow(){
        circ = new CSC143Circle(-1);
    }
    /**
     *This method tests the constructor for the upper limit
     */
    @Test(expected = IllegalArgumentException.class) 
    public void constructorTestHigh(){
        circ = new CSC143Circle(1001);
    }
    /**
     *This method tests the diameter getter under normal conditions
     */
    @Test public void diameterTest(){
        assertEquals("Diameter?", 4, circ.getDiameter());
    }
    /**
     *This method tests the area getter under normal conditions
     */
    @Test public void areaTest(){
        assertEquals("Area?", 3.14/4*16, circ.getArea(), 0.01);
    }
}
