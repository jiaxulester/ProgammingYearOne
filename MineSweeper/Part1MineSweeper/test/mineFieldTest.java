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
 * @author jl824
 */
public class mineFieldTest {
    
    public mineFieldTest() {
        
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
   @Test
    public void testmineTile(){
        System.out.println("&&&Test mineTile&&&");
        mineField test= new mineField(5,5,3);
        test.mineTile(2, 2);
        System.out.println(test.mineTile(2, 2));
        
        
    }
    
    @Test
    public void testpopulate(){
        System.out.println("&&&Test populate for 10 mines&&&");
        mineField obj= new mineField(10,10,10);
        obj.populate();
        obj.toString();
        
        System.out.println("&&&Test populate for 20 mines&&&");
        mineField obj1= new mineField(12,12,20);
        obj1.populate();
        obj1.toString();
        
        System.out.println("&&&Test populate for 30 mines&&&");
        mineField obj2= new mineField(10,10,30);
        obj2.populate();
        obj2.toString();
        //System.out.println(obj.mineTile(2,5));
    }
    
   @Test
    public void testtoString(){
        System.out.println("&&&Test toString for 5 mines&&&");
        mineField obj= new mineField(10,10,5);
        obj.populate();
        obj.toString();
    }
}
