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
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;


/**
 *
 * @author 215896
 */
public class MinesweeperTest {
    
    public MinesweeperTest() {
    }

    /**
     * Test of main method, of class Minesweeper.
     */
    @Test
    public void testMain() throws IOException{
        System.out.println("main");
        Minesweeper one = new Minesweeper();
        String initialString = "new 3 3";
        InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
        
        // I am not sure how to do with this Test for Minesweeper, but you can go
        // to Minesweeper to try the game.
    }
    
}
