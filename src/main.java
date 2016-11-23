
import bktree.damerauLevenshtein;
import java.io.File;
import java.io.IOException;
import spellingcorrector.corretorDamerauLevenshtein;
import spellingcorrector.corretorLevenshtein;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Cliente
 */
public class main {

    public static void main(String[] args) throws IOException {

        File arquivorelativo = new File("dictionary_pt-br.zip");
        String pathRelativo = arquivorelativo.getCanonicalPath();
        corretorLevenshtein cl = new corretorLevenshtein(pathRelativo);        

        cl.raizDaCorrecao("ZOMBI",1);
        cl.raizDaCorrecao("BALL", 1);
        cl.raizDaCorrecao("HOM3M", 1);
        cl.raizDaCorrecao("CAZA", 1);
        cl.raizDaCorrecao("CAS", 1);
        cl.raizDaCorrecao("CASx", 2);
        cl.raizDaCorrecao("CASA",0);
        cl.raizDaCorrecao("AS",1);
        cl.raizDaCorrecao("ASA",0);
        
      System.out.println(damerauLevenshtein.EditDistance("ASA","CASA"));
      System.out.println(damerauLevenshtein.EditDistance("ASA","CoooSA"));
      
      corretorDamerauLevenshtein cdl = new corretorDamerauLevenshtein(pathRelativo);
      
        cdl.raizDaCorrecao("CASAa",1);
        cdl.raizDaCorrecao("ASX", 1);
        cdl.raizDaCorrecao("ZOMBI",1);
        cdl.raizDaCorrecao("BALL", 1);
        cdl.raizDaCorrecao("HOM3M", 1);
        cdl.raizDaCorrecao("CAZA", 1);
        cdl.raizDaCorrecao("CAS", 1);
        cdl.raizDaCorrecao("CASx", 2);
        cdl.raizDaCorrecao("CASA",0);
        cdl.raizDaCorrecao("AS",1);
        cdl.raizDaCorrecao("ASA",0);
      
    }
}
