/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bktree;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Cliente
 */
public class noBkTreeDamerauLevenshtein {
     private String palavra;
    private HashMap<Integer, noBkTreeDamerauLevenshtein> irmaos = new java.util.HashMap<Integer, noBkTreeDamerauLevenshtein>();

    public noBkTreeDamerauLevenshtein(String palavra) {
        this.palavra = palavra;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public void insereIrmao(int peso, noBkTreeDamerauLevenshtein irmao) {
        if (irmaos.get(peso) != null) {
            //System.out.println("Inserindo " + irmao.getPalavra() + " abaixo de " + irmaos.get(peso).getPalavra() +" com peso relativo de "+levenshtein.distance(irmao.getPalavra(),this.getPalavra()));
            int pesoNovo = damerauLevenshtein.EditDistance(irmaos.get(peso).getPalavra(), irmao.getPalavra());
            irmaos.get(peso).insereIrmao(pesoNovo, irmao);
        } else {
            // System.out.println("Inserindo " + irmao.getPalavra() +" com peso de "+peso);
            irmaos.put(peso, irmao);
        }
    }

    public noBkTreeDamerauLevenshtein getIrmao(int peso) {
        return irmaos.get(peso);
    }
}
