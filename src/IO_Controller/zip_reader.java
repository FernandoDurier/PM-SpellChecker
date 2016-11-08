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
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 *
 * @author Cliente
 */
public class zip_reader {
    public static void read() throws IOException{
         ZipFile zipFile = new ZipFile("C:\\Users\\Cliente\\Desktop\\teste.zip");
        InputStream stream = null;
        Enumeration<? extends ZipEntry> entries = zipFile.entries();

        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            System.out.println(entry);

            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Cliente\\Desktop\\bolsa ic 2\\unirio-workspace\\Msc\\Portuguese-Realizer\\src\\test\\resources\\corpus-substantivos.txt"));
            try {
                String line = br.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = br.readLine();
                }

            } finally {
                br.close();
            }

            stream = zipFile.getInputStream(entry);
        }
        System.out.println(stream.toString());
    }
}
