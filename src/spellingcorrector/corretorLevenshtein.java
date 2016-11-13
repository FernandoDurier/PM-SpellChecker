/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spellingcorrector;

import IO_Controller.zip_reader;
import bktree.levenshtein;
import bktree.noBkTreeLevenshtein;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Cliente
 */
public class corretorLevenshtein {

    private noBkTreeLevenshtein bkl;
    private BufferedReader dicionario;

    public corretorLevenshtein(String pathDoDicionario) throws IOException {
        BufferedReader dicionario = zip_reader.read(pathDoDicionario);
        this.dicionario = dicionario;
        gerarArvore();
    }

    public void gerarArvore() throws IOException {
        String line = dicionario.readLine();
        bkl = new noBkTreeLevenshtein(line); //primeira palavra do dicionario vai ser a raiz
        line = dicionario.readLine();
        while (line != null) {
            //System.out.println(line);
            bkl.insereIrmao(levenshtein.distance(bkl.getPalavra(), line), new noBkTreeLevenshtein(line));
            line = dicionario.readLine();
        }
        dicionario.close();
    }

    public String corrigir(String palavraErrada, noBkTreeLevenshtein no) {
        //System.out.println("Palavra Buscada: "+palavraErrada);
        if(no != null){
            //System.out.println("Palavra Comparada: " + no.getPalavra());
           // System.out.println(no.getPalavra() + " com distancia de " + levenshtein.distance(no.getPalavra(), palavraErrada));
            if (levenshtein.distance(no.getPalavra(), palavraErrada) <= 2) {
                String resposta = no.getPalavra();
                //System.out.println("Achei a correção para " + palavraErrada + " , eh " +resposta+ " !!");
                return resposta;
            } 
            else {
                int dist = levenshtein.distance(no.getPalavra(), palavraErrada);
                noBkTreeLevenshtein irmao = no.getIrmao(dist);
                return corrigir(palavraErrada, irmao);
            }
        }
        else{
            return "Nao consta no dicionario a correcao para tal palavra.";
        }
    }

    public noBkTreeLevenshtein getBkl() {
        return bkl;
    }

    public void setBkl(noBkTreeLevenshtein bkl) {
        this.bkl = bkl;
    }

    public BufferedReader getDicionario() {
        return dicionario;
    }

    public void setDicionario(BufferedReader dicionario) {
        this.dicionario = dicionario;
    }

}
