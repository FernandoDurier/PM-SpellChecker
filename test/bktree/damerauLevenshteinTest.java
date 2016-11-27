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
public class damerauLevenshteinTest {

    public damerauLevenshteinTest() {
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
     * Test of EditDistance method, of class damerauLevenshtein.
     */
    @Test
    public void testEditDistance() {
        System.out.println("distance");
        String a = "ZOMBI";
        String b = "ZOMBI";
        int expResult = 0;
        int result = damerauLevenshtein.EditDistance(a, b);

        assertEquals(0, damerauLevenshtein.EditDistance("OVO", "OVO"));
        assertEquals(1, damerauLevenshtein.EditDistance("ASA", "CASA"));
        assertEquals(2, damerauLevenshtein.EditDistance("CORU", "CORUJA"));
        assertEquals(3, damerauLevenshtein.EditDistance("A", "AMAR"));
        assertEquals(4, damerauLevenshtein.EditDistance("A", "ASSIM"));
        assertEquals(5, damerauLevenshtein.EditDistance("A", "BARCOS"));
        assertEquals(6, damerauLevenshtein.EditDistance("A", "ABACAXI"));
        assertEquals(7, damerauLevenshtein.EditDistance("ASA", "ASA BRANCA"));
        assertEquals(8, damerauLevenshtein.EditDistance("COR", "CORPOHUMANO"));
        assertEquals(9, damerauLevenshtein.EditDistance("A", "ANNASTELLA"));

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
