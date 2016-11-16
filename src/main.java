
import java.io.File;
import java.io.IOException;
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
        
       
        String correcao = cl.corrigir("CLIPEx", cl.getBkl(),1);
        System.out.println(correcao);
        correcao = cl.corrigir("A", cl.getBkl(),1);
        System.out.println(correcao);
        correcao = cl.corrigir("HOM3M", cl.getBkl(),2);
        System.out.println(correcao);
        correcao = cl.corrigir("ZUMBI", cl.getBkl(),2);
        System.out.println(correcao);
        correcao = cl.corrigir("ZOMBI", cl.getBkl(),2);
        System.out.println(correcao);
        correcao = cl.corrigir("ZUMBA", cl.getBkl(),2);
        System.out.println(correcao);
        correcao = cl.corrigir("CASA", cl.getBkl(),0);
        System.out.println(correcao);
        correcao = cl.corrigir("CAS", cl.getBkl(),1);
        System.out.println(correcao);
        correcao = cl.corrigir("CA", cl.getBkl(),1);
        System.out.println(correcao);
        
    }
}
