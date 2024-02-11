/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dcalha, dsoares 190288017@ips.pt 190288003@ips.pt, dsilva 190288002@ips.pt
 */
public class Logger {

    private class Logs {

        private String text;
        private LocalDateTime timestamp;
/**
 * Construtor da classe Logger
 * @param text
 * @param timestamp 
 */
        public Logs(String text, LocalDateTime timestamp) {
            this.text = text;
            this.timestamp = timestamp;
        }
        /**
         * Método toString que imprime o formato no ficheiro
         * @return 
         */
        @Override
        public String toString() {
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            
            return this.text + " -> " + this.timestamp.format(formatter);
        }
    }

    private String filename;
    private List<Logs> logs;

    public Logger(String filename) {
        this.filename = filename;
        this.logs = new ArrayList<>();
    }

    /*
    Método que adiciona um log a um arraylist
    */
    public void addLog(String text) {
        logs.add(new Logs(text, LocalDateTime.now()));
    }
    
    /**
     * Método flush que escreve no ficheiro
     * @throws IOException 
     */
    public void flush() throws IOException  {
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));

        for (Logs log : logs) {
            System.out.println(log + "\n");
            out.println(log + "\n");
        }

        out.close();
        logs.clear();
    }
}
