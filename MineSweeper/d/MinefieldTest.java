package testv1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uk.ac.sussex.ianw.minesweeper.Minefield;

/**
 *
 * @author ianw
 */
public class MinefieldTest {

    // Mine the top row, then the corner
    private final String topCentre = "1*1\n111\n000\n";
    private final String thenBottomRight = "1*1\n122\n01*\n";
    // Do it again, but with a clean minefield
    private final String cleanTopRight = "01*\n011\n000\n";
    private final String thenBottomLeft = "01*\n121\n*10\n";
            
   
    @Test
    public void testInsertion() {
        // This is the minimum set of tests to ensure correctness of
        // the updating of adjacent tiles.
        // Thee are many other more complete approaches
        Minefield mf = new Minefield(3, 3, 1);
        mf.mineTile(0, 1); 
        assertEquals(topCentre, mf.toString());
        mf.mineTile(2, 2);
        assertEquals(thenBottomRight,mf.toString());
        Minefield mf1 = new Minefield(3, 3, 1);
        mf1.mineTile(0, 2);
        assertEquals(cleanTopRight,mf1.toString());
        mf1.mineTile(2,0);
        assertEquals(thenBottomLeft,mf1.toString());
        
    }

    @Test
    public void testPopulate() {
        // This is a one off test.  One might argue that this is a random 
        // method, so should be called multiple times.  However, given the
        // mine occupancy used, there are multiple collisions with very
        // high probability
        Minefield mf = new Minefield(10, 10, 90);
        mf.populate();
        String s = mf.toString();
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                counter++;
            }
        }
        assertEquals(90, counter);
        System.out.print(s);
    }
}
