/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spellingcorrector;

import bktree.noBkTreeDamerauLevenshtein;
import bktree.raizBKTreeDamerauLevenshtein;
import java.io.BufferedReader;
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
public class corretorDamerauLevenshteinTest {

    public corretorDamerauLevenshteinTest() {
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
     * Test of gerarArvore method, of class corretorDamerauLevenshtein.
     */
    @Test
    public void testGerarArvore() throws Exception {
        System.out.println("gerarArvore");
        corretorDamerauLevenshtein instance = null;
        instance.gerarArvore();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of corrigir method, of class corretorDamerauLevenshtein.
     */
    @Test
    public void testCorrigir() {
        System.out.println("corrigir");
        String palavraErrada = "";
        noBkTreeDamerauLevenshtein no = null;
        int precisao = 0;
        corretorDamerauLevenshtein instance = null;
        String expResult = "";
        String result = instance.corrigir(palavraErrada, no, precisao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of raizDaCorrecao method, of class corretorDamerauLevenshtein.
     */
    @Test
    public void testRaizDaCorrecao() {
        System.out.println("raizDaCorrecao");
        String palavra = "";
        int tolerancia = 0;
        corretorDamerauLevenshtein instance = null;
        String expResult = "";
        String result = instance.raizDaCorrecao(palavra, tolerancia);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBkl method, of class corretorDamerauLevenshtein.
     */
    @Test
    public void testGetBkl() {
        System.out.println("getBkl");
        corretorDamerauLevenshtein instance = null;
        raizBKTreeDamerauLevenshtein expResult = null;
        raizBKTreeDamerauLevenshtein result = instance.getBkl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBkl method, of class corretorDamerauLevenshtein.
     */
    @Test
    public void testSetBkl() {
        System.out.println("setBkl");
        raizBKTreeDamerauLevenshtein bkl = null;
        corretorDamerauLevenshtein instance = null;
        instance.setBkl(bkl);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDicionario method, of class corretorDamerauLevenshtein.
     */
    @Test
    public void testGetDicionario() {
        System.out.println("getDicionario");
        corretorDamerauLevenshtein instance = null;
        BufferedReader expResult = null;
        BufferedReader result = instance.getDicionario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDicionario method, of class corretorDamerauLevenshtein.
     */
    @Test
    public void testSetDicionario() {
        System.out.println("setDicionario");
        BufferedReader dicionario = null;
        corretorDamerauLevenshtein instance = null;
        instance.setDicionario(dicionario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
