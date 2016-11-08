/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
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
public class SpellingCorrectorTest {
    
    public SpellingCorrectorTest() {
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
     * Test of main method, of class SpellingCorrector.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        SpellingCorrector.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of palavraCorreta method, of class SpellingCorrector.
     */
    @Test
    public void testPalavraCorreta() {
        System.out.println("palavraCorreta");
        String palavra = "";
        String expResult = "";
        String result = SpellingCorrector.palavraCorreta(palavra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of operacoes method, of class SpellingCorrector.
     */
    @Test
    public void testOperacoes() {
        System.out.println("operacoes");
        String word = "";
        List<String> expResult = null;
        List<String> result = SpellingCorrector.operacoes(word);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
