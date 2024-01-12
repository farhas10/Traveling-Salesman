import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TourTest
{
    @Test
    public void lengthTestEmpty()
    {
    	Tour t = new Tour();
        assertEquals(0, t.length(), 0.001);
    }
    
    @Test
    public void lengthTestZero()
    {
        Tour t = new Tour();
        t.insertNearest(new Point(0,0));
        assertEquals(0, t.length(), 0.001);
        
    }
    
    @Test
    public void lengthTestWithPoints()
    {
        Tour t = new Tour(new Point(0,0), new Point(3,0), new Point(2,0), new Point(5, 0));
        assertEquals(10, t.length(), 0.001);
    }
    
    @Test
    public void toStringTestWithPoints()
    {
        Tour t = new Tour(new Point(1,0), new Point(0,1), new Point(-2,-3), new Point(-3, -1));
        assertEquals("(1.0, 0.0)\n(0.0, 1.0)\n(-2.0, -3.0)\n(-3.0, -1.0)\n", t.toString());
    }
    
    
    @Test
    public void insertNearestTest()
    {
        Tour t = new Tour();
        t.insertNearest(new Point(2,2));
        assertEquals("(2.0, 2.0)\n", t.toString());
    }
    
    @Test
    public void insertSmallesTest()
    {
        Tour t = new Tour(new Point(1,0), new Point(-1,0), new Point(0,0), new Point(6,0));
        t.insertSmallest(new Point(4, 4));
        assertEquals("(1.0, 0.0)\n(-1.0, 0.0)\n(0.0, 0.0)\n(6.0, 0.0)\n(4.0, 4.0)\n", t.toString());
    }
    
}
