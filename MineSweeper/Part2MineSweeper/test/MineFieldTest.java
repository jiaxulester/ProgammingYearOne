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

/**
 *
 * @author 215896
 */
public class MineFieldTest {
    
    // Mark the flag then cancel it 
    private final String markFlagged = ".F.\n...\n...\n";
    private final String cancelMarkFlagged = "...\n...\n...\n";
    // Open up the cover(revealed) if revealed will shows ture
    private final boolean stepField = true;
    
    
    public MineFieldTest() {
    }
    
    @Test
    public void testflagged() {
        System.out.println("flagged");
        MineField mf = new MineField(3, 3, 1);
        mf.flagged(0, 1); 
        assertEquals(markFlagged, mf.toString());
        mf.flagged(0, 1);
        assertEquals(cancelMarkFlagged, mf.toString());
    }
    
    @Test
    public void teststep() {
        System.out.println("step");
        MineField mf = new MineField(3, 3, 1);
        mf.step(0, 0);
        assertTrue(stepField);
    }
        
}
