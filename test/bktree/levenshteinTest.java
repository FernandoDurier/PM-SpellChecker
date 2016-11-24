/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bktree;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cliente
 */
public class levenshteinTest {
    
    public levenshteinTest() {
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

    /**
     * Test of distance method, of class levenshtein.
     */
    @Test
    public void testDistance() {
        System.out.println("distance");
        String a = "ZOMBI";
        String b = "ZOMBI";
        int expResult = 0;
        int result = levenshtein.distance(a, b);
        
        assertEquals(0, levenshtein.distance("OVO", "OVO"));
        assertEquals(1, levenshtein.distance("ASA","CASA"));
        assertEquals(2, levenshtein.distance("CORUJA","CORU"));
        assertEquals(3, levenshtein.distance("A","AMAR"));
        assertEquals(4, levenshtein.distance("A","ASSIM"));
        assertEquals(5, levenshtein.distance("A","BARCOS"));
        assertEquals(6, levenshtein.distance("A","ABACAXI"));
        assertEquals(7, levenshtein.distance("ASA","ASA BRANCA"));
        assertEquals(8, levenshtein.distance("COR","CORPOHUMANO"));
        assertEquals(9, levenshtein.distance("A","ANNASTELLA"));
        
        // TODO review the generated test code and remove the default call to fail.
       //fail("The test case is a prototype.");
    }
    
}
