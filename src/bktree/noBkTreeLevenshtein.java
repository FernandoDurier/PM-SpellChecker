/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bktree;

import java.util.Map;

/**
 *
 * @author Cliente
 */
public class noBkTreeLevenshtein {

    private String palavra;
    private Map<Integer, noBkTreeLevenshtein> irmaos = new java.util.HashMap<Integer, noBkTreeLevenshtein>();

    public noBkTreeLevenshtein(String palavra) {
        this.palavra = palavra;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public void insereIrmao(int peso, noBkTreeLevenshtein irmao) {
        if (irmaos.get(peso) != null) {
            //System.out.println("Inserindo " + irmao.getPalavra() + " abaixo de " + irmaos.get(peso).getPalavra() +" com peso relativo de "+levenshtein.distance(irmao.getPalavra(),this.getPalavra()));
            int pesoNovo = levenshtein.distance(irmaos.get(peso).getPalavra(), irmao.getPalavra());
            irmaos.get(peso).insereIrmao(pesoNovo, irmao);
        } else {
           // System.out.println("Inserindo " + irmao.getPalavra() +" com peso de "+peso);
            irmaos.put(peso, irmao);
        }
    }

    public noBkTreeLevenshtein getIrmao(int peso) {
        return irmaos.get(peso);
    }
}
