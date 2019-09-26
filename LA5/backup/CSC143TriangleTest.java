package csc143.junit;
/**
 *This class if for testing CSC143Circle for LA5
 *@author James Dansie
 *@vesrion LA5 - JUnit Testing
 */
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class CSC143TriangleTest {
        //Declaring an object for the methods to use
        CSC143Triangle tri = new CSC143Triangle(4, 3);
        
    /** Fixture initialization (common initialization
    *  for all tests). **/
    @Before public void setUp() {
         tri = new CSC143Triangle(4, 3);
    }
    //Checking that something was created.
    @Test public void constructorTestNormal(){
        tri = new CSC143Triangle(4, 3);
        Assert.assertNotNull(tri);
    }
    //Checking the preconditions in the shape class
    @Test(expected = IllegalArgumentException.class) 
    public void constructorTestLimitLow(){
        tri = new CSC143Triangle(4, -1);
    }
    //Checking the preconditions in the shape class
    @Test(expected = IllegalArgumentException.class) 
    public void constructorTestLimitHigh(){
        tri = new CSC143Triangle(4, 1001);
    }
    //Normal functionality of getBase()
    @Test public void baseTest(){
        Assert.assertEquals("Base?", 4, tri.getBase());
    }
    //Normal functionality of getHeight()
    @Test public void heightTest(){
        Assert.assertEquals("Height?", 3, tri.getHeight());
    }
    //Normal functionality of getArea()
    @Test public void areaTest(){
        Assert.assertEquals("Area?",(tri.getBase()*tri.getHeight()/2), tri.getArea(), 0.001);
    }

}
