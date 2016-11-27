
import IO_Controller.leitorDeTeclado;
import bktree.damerauLevenshtein;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import keyboard.layout;
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

        File arquivorelativo = new File("./dictionary_pt-br.zip");
        String pathRelativo = arquivorelativo.getCanonicalPath();
        corretorLevenshtein cl = new corretorLevenshtein(pathRelativo);        

      System.out.println("-----------------------------------------------");
      System.out.println("-----------Com Levenshtein---------------------");
      System.out.println("-----------------------------------------------");
        
        cl.raizDaCorrecao("ZOMBI",1);
        cl.raizDaCorrecao("BALL", 1);
        cl.raizDaCorrecao("HOM3M", 1);
        cl.raizDaCorrecao("CAZA", 1);
        cl.raizDaCorrecao("CAS", 1);
        cl.raizDaCorrecao("CASx", 2);
        cl.raizDaCorrecao("CASA",0);
        cl.raizDaCorrecao("AS",1);
        cl.raizDaCorrecao("ASA",0);
        
      System.out.println("----------------------------------------------");
      System.out.println("-----------Com Damerau------------------------");
      System.out.println("----------------------------------------------");
      
      corretorDamerauLevenshtein cdl = new corretorDamerauLevenshtein(pathRelativo);
      
        cdl.raizDaCorrecao("CASAa",2);
        cdl.raizDaCorrecao("ASX", 2);
        cdl.raizDaCorrecao("ZOMBI",1);
        cdl.raizDaCorrecao("BALL", 1);
        cdl.raizDaCorrecao("HOM3M", 1);
        cdl.raizDaCorrecao("CAZA", 1);
        cdl.raizDaCorrecao("CAS", 1);
        cdl.raizDaCorrecao("CASx", 2);
        cdl.raizDaCorrecao("CASA",0);
        cdl.raizDaCorrecao("AS",1);
        cdl.raizDaCorrecao("ASA",0);
        
        leitorDeTeclado lt = new leitorDeTeclado();
        ArrayList<layout> lista =  lt.getLayoutTecladoDoXML();
        for(int i = 0;i<lista.size();i++){
            System.out.println("Tipo: " + lista.get(i).getTipo());
            System.out.println("linha1: " + lista.get(i).getLine1());
            System.out.println("offset1:" + lista.get(i).getOffset1());
            System.out.println("linh2: "+lista.get(i).getLine2());
            System.out.println("offset2: "+lista.get(i).getOffset2());
            System.out.println("linha3: "+lista.get(i).getLine3());
            System.out.println("offset3: "+lista.get(i).getOffset3());
            System.out.println("");
        }
        
        double [][] m = lista.get(0).prepararDistancias();
        
        for(int x = 0;x<26;x++){
            for(int y = 0;y<26;y++){
                System.out.println("Diferença de "+ x + " para " + y + " = " + m[x][y]);
            }
        }
    }
}
