
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*  
 Verificador Ortográfico
 Autor: Ashish Sharma
 Fonte: http://www.ashishsharma.me/2012/01/spelling-palavraCorretaor-algorithm-java-code.html
 Versão: Júlio Campos e Fernando Durier

 Referências
 - http://norvig.com/spell-palavraCorreta.html
 - http://raelcunha.com/spell-palavraCorreta.php
 - http://surguy.net/articles/scala-spelling.xml

 Componentes
 - Dicionário (pré-populado), mapa com palavra para testar
 - Operações: inserir, remover, inverter, substituir
 - Candidatos: 

 - candidates : loop edits and populate. map to weight to word */
public class SpellingCorrector {

    public static void main(String[] args) throws IOException {

        // Adicionar palavras com grafia correta ao dicionário
         BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Cliente\\Desktop\\bolsa ic 2\\unirio-workspace\\Msc\\Portuguese-Realizer\\src\\test\\resources\\corpus-substantivos.txt"));
        try {
            String line = br.readLine();
            while (line != null) {
                dicionario.put(line, 1);
                line = br.readLine();
            }
            
        } finally {
            br.close();
        }

        Scanner input = new Scanner(System.in);
        System.out.print("Digite uma palavra: ");
        String palavra = input.next(); // Só realiza leitura de palavras simples

//        dicionario.put("hoje", 1);
//        dicionario.put("another", 1);
//        dicionario.put("merci", 1);
        // Verificar ortografia de palavra entrada
        String palavraCorreta = palavraCorreta(palavra);
        System.out.println("Você quis dizer '" + palavraCorreta + "'? \n");
    }

    // Mapa para contar palavra, quantas vezes uma palavra está presente ou um peso associado a uma palavra
    public static Map<String, Integer> dicionario = new HashMap<String, Integer>();

    public static String palavraCorreta(String palavra) {

        if (dicionario.containsKey(palavra)) {
            return palavra;
        }

        // Obter todas as operações possíveis para a palavra entrada
        List<String> operacoes = operacoes(palavra);

        // Here we can either iterate through list of edits and find the 1st word that is in dicionario and return.
        // Or we can go to below logic to return the word with most weight (that we would have already stored in dicionario map)
        // map to hold the possible matches
        Map<Integer, String> candidates = new HashMap<Integer, String>();

        // keep checking the dicionario and populate the possible matches
        // it stores the count (or weight) of word and the actual word
        for (String s : operacoes) {
            if (dicionario.containsKey(s)) {
                candidates.put(dicionario.get(s), s);
            }
        }

        // one we have found possible matches - we want to return most popular (most weight) word
        if (candidates.size() > 0) {
            return candidates.get(Collections.max(candidates.keySet()));
        }

        // If none matched.
        // We will pick every word from edits and again do edits (using same previous logic) on that to see if anything matches
        // We don't do recursion here because we don't the loop to continue infinitely if none matches
        // If even after doing edits of edits, we don't find the palavraCorreta word - then return.
        for (String s : operacoes) {

            List<String> novasOperacoes = operacoes(s);
            for (String ns : novasOperacoes) {
                if (dicionario.containsKey(ns)) {
                    candidates.put(dicionario.get(ns), ns);
                }
            }
        }
        if (candidates.size() > 0) {
            return candidates.get(Collections.max(candidates.keySet()));
        } else {
            return palavra;
        }
    }

    // Word EDITS
    // Getting all possible palavraCorretaions c of a given word w. 
    // It is the edit distance between two words: the number of edits it would take to turn one into the other
    public static List<String> operacoes(String word) {

        if (word == null || word.isEmpty()) {
            return null;
        }

        List<String> list = new ArrayList<String>();

        String w = null;

        // deletes (remove one letter)
        for (int i = 0; i < word.length(); i++) {
            w = word.substring(0, i) + word.substring(i + 1); // ith word skipped
            list.add(w);
        }

        // transpose (swap adjacent letters)
        // note here i is less than word.length() - 1
        for (int i = 0; i < word.length() - 1; i++) { // < w.len -1 :: -1 because we swapped last 2 elements in go.
            w = word.substring(0, i) + word.charAt(i + 1) + word.charAt(i) + word.substring(i + 2); // swapping ith and i+1'th char
            list.add(w);
        }

        // replace (change one letter to another)
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                w = word.substring(0, i) + c + word.substring(i + 1); // replacing ith char with all possible alphabets
                list.add(w);
            }
        }

        // insert (add a letter)
        // note here i is less than and EQUAL to
        for (int i = 0; i <= word.length(); i++) { // <= because we want to insert the new char at the end as well
            for (char c = 'a'; c <= 'z'; c++) {
                w = word.substring(0, i) + c + word.substring(i); // inserting new char at ith position
                list.add(w);
            }
        }

        return list;
    }

}
