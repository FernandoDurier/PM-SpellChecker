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
    public static int EditDistance(String original, String modified) {
        int len_orig = original.length();
        int len_diff = modified.length();

        int[][] matrix = new int[len_orig + 1][len_diff + 1];
        for (int i = 0; i <= len_orig; i++) {
            matrix[i][0] = i;
        }
        for (int j = 0; j <= len_diff; j++) {
            matrix[0][j] = j;
        }

        for (int i = 1; i <= len_orig; i++) {
            for (int j = 1; j <= len_diff; j++) {
                int cost = -1;//? 0 : 1;
                if (modified.charAt(j - 1) == original.charAt(i - 1)) {
                    cost = 0;
                } else {
                    cost = 1;
                }
                int[] vals = {matrix[i - 1][j] + 1, matrix[i][j - 1] + 1, matrix[i - 1][j - 1] + cost};
                int minimo = -1;
                int index = 0;
                for (int m = 1; m < vals.length; m++) {
                    if (vals[m] < vals[index]) {
                        minimo = vals[m];
                        index = m;
                    }
                }
                matrix[i][j] = minimo;
                if (i > 1 && j > 1 && original.charAt(i - 1) == modified.charAt(j - 2) && original.charAt(i - 2) == modified.charAt(j - 1)) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i - 2][j - 2] + cost);
                }
            }
        }
        return matrix[len_orig][len_diff];
    }
}
