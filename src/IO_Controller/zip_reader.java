/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO_Controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 *
 * @author Cliente
 */
public class zip_reader {

    public static void read(String path, Map<String, Integer> dicionario) throws IOException {
        ZipFile zipFile = new ZipFile(path);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        String filepath = null;
        InputStream input = null;
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            if (entry.toString().equals("dictionary pt-br.dic")) {
                System.out.println("Achei dicionario !!");
                input = zipFile.getInputStream(entry);
                System.out.println("Esse é seu dicionario, " + input);
                break;
            }
            System.out.println("Procurando dicionario !!");
        }
        if (input != null) {
            BufferedReader br = new BufferedReader(new InputStreamReader(input, "UTF-8"));
            try {
                System.out.println("Carregando as Palavras do Dicionario");
                String line = br.readLine();
                while (line != null) {
                    //System.out.println(line);
                    dicionario.put(line, 1);
                    line = br.readLine();
                }

            } finally {
                br.close();
            }
        }
    }
}
