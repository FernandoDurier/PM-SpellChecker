/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bktree;

/**
 *
 * @author Cliente
 */
public class damerauLevenshtein {

    @SuppressWarnings("empty-statement")
    public static int EditDistance(String palavraInserida, String palavraDicionario) {
        //Variaveis que definem o tamanho da matriz
        int tamanhoPalavraInserida = palavraInserida.length(),
                tamanhoPalavraDicionario = palavraDicionario.length();
        /**
         * Variável da Matriz
         */
        int[][] distancia = new int[tamanhoPalavraInserida + 1][tamanhoPalavraDicionario + 1];

        //Define o valor que irá popular a tabela da matriz
        int custoDistancia = 0;

        //cria a matriz com a tabela de distancia
        for (int i = 0; i <= tamanhoPalavraInserida; i++) {
            distancia[i][0] = i;
        }
        for (int j = 0; j <= tamanhoPalavraDicionario; j++) {
            distancia[0][j] = j;
        }

        //popula a tabela e faz a verificação da distancia de cada letra
        for (int k = 1; k <= tamanhoPalavraInserida; k++) {
            for (int l = 1; l <= tamanhoPalavraDicionario; l++) {
                if (palavraInserida.charAt(k - 1) == palavraDicionario.charAt(l - 1)) {
                    custoDistancia = 0;
                } else {
                    custoDistancia = 1;
                }
                distancia[k][l] = Math.min(distancia[k - 1][l] + 1,
                        Math.min(distancia[k][l - 1] + 1, distancia[k - 1][l - 1] + custoDistancia));
                if (k > 1 && l > 1
                        && palavraInserida.charAt(k - 1) == palavraDicionario.charAt(l - 2)
                        && palavraInserida.charAt(k - 2) == palavraDicionario.charAt(l - 1)) {
                    distancia[k][l] = Math.min(distancia[k][l], distancia[k - 2][l - 2] + custoDistancia);
                }
            }

        }

        return distancia[tamanhoPalavraInserida][tamanhoPalavraDicionario];
    }
}
