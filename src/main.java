
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

        corretorLevenshtein cl = new corretorLevenshtein("C:\\Users\\Cliente\\Desktop\\dictionary_pt-br.zip");
        
        
        String correcao = cl.corrigir("CLIPEx", cl.getBkl());
        System.out.println(correcao);
        correcao = cl.corrigir("A", cl.getBkl());
        System.out.println(correcao);
        correcao = cl.corrigir("HOM3M", cl.getBkl());
        System.out.println(correcao);
        correcao = cl.corrigir("ZUMBI", cl.getBkl());
        System.out.println(correcao);
        correcao = cl.corrigir("ZOMBI", cl.getBkl());
        System.out.println(correcao);
        correcao = cl.corrigir("ZUMBA", cl.getBkl());
        System.out.println(correcao);
        
    }
}
