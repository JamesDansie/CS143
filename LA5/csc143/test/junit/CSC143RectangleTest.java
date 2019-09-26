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

public class CSC143RectangleTest {

        //Declaring an object for the methods to use
        CSC143Rectangle box = new CSC143Rectangle(4, 3);
        
    /** Fixture initialization (common initialization
    *  for all tests). **/
    @Before public void setUp() {
         box = new CSC143Rectangle(4, 3);
    }
    //Checking that something was created.
    @Test public void constructorTestNormal(){
        box = new CSC143Rectangle(4, 3);
        Assert.assertNotNull(box);
    }
    //Checking the preconditions in the shape class
    @Test(expected = IllegalArgumentException.class) 
    public void constructorTestLimitLow(){
        box = new CSC143Rectangle(-4, -1);
    }
    //Checking the preconditions in the shape class
    @Test(expected = IllegalArgumentException.class) 
    public void constructorTestLimitHigh(){
        box = new CSC143Rectangle(4, 1001);
    }
    //Normal functionality of getBase()
    @Test public void baseTest(){
        Assert.assertEquals("Base?", 4, box.getWidth());
    }
    //Normal functionality of getHeight()
    @Test public void heightTest(){
        Assert.assertEquals("Height?", 3, box.getHeight());
    }
    //Normal functionality of getArea()
    @Test public void areaTest(){
        Assert.assertEquals("Area?",(box.getWidth()*box.getHeight()), box.getArea(), 0.001);
    }
}
