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
public class raizBKTreeDamerauLevenshtein {

    private String raizPalavra = "@";
    private Map<Integer, noBkTreeDamerauLevenshtein> palavras = new java.util.HashMap<Integer, noBkTreeDamerauLevenshtein>();

    public int indexRaiz(String palavra) {
        String determinante = "";
        determinante += palavra.charAt(0);
        determinante = determinante.toUpperCase();
        int index = 0;
        switch (determinante) {
            case "A":
                index = 1;
                break;
            case "B":
                index = 2;
                break;
            case "C":
                index = 3;
                break;
            case "D":
                index = 4;
                break;
            case "E":
                index = 5;
                break;
            case "F":
                index = 6;
                break;
            case "G":
                index = 7;
                break;
            case "H":
                index = 8;
                break;
            case "I":
                index = 9;
                break;
            case "J":
                index = 10;
                break;
            case "K":
                index = 11;
                break;
            case "L":
                index = 12;
                break;
            case "M":
                index = 13;
                break;
            case "N":
                index = 14;
                break;
            case "O":
                index = 15;
                break;
            case "P":
                index = 16;
                break;
            case "Q":
                index = 17;
                break;
            case "R":
                index = 18;
                break;
            case "S":
                index = 19;
                break;
            case "T":
                index = 20;
                break;
            case "U":
                index = 21;
                break;
            case "V":
                index = 22;
                break;
            case "W":
                index = 23;
                break;
            case "X":
                index = 24;
                break;
            case "Y":
                index = 25;
                break;
            case "Z":
                index = 26;
                break;
            default:
                break;
        }

        if (index > 0) {
            return index;
        } else {
            return index;
        }
    }

    public void insereNaRaiz(String palavra) {
        int onde = indexRaiz(palavra);
        if (palavras.get(onde) != null) {
            palavras.get(onde).insereIrmao(damerauLevenshtein.EditDistance(palavras.get(onde).getPalavra(), palavra), new noBkTreeDamerauLevenshtein(palavra));
        } else {
            palavras.put(onde, new noBkTreeDamerauLevenshtein(palavra));
        }

    }

    public Map<Integer, noBkTreeDamerauLevenshtein> getPalavras() {
        return palavras;
    }

    public void setPalavras(Map<Integer, noBkTreeDamerauLevenshtein> palavras) {
        this.palavras = palavras;
    }
}
