/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

/**
 *
 * @author dcalha, dsoares 190288017@ips.pt 190288003@ips.pt, dsilva 190288002@ips.pt
 */

import java.util.Scanner;


/**
 * Uma classe que lê dados inseridos pelo utilizador
 * @author Rui Pedro
 */
public class Reader {
     private Scanner sc;

    /**
     * Construtor
     */
    public Reader() {
        sc = new Scanner(System.in);
    }
    
    /**
     * Exibe uma mensagem ao utilizador
     * @param message Mensagem a mostrar
     */
    public void showMessage(String message) {
        if (message == null) {
            message = "";
        }
        System.out.println("> " + message);
    }

    /**
     * Lê um inteiro inserido pelo utilizador
     * @param message Mensagem a ser exibida
     * @return O inteiro lido
     */
    public int readInt(String message) {
        showMessage(message);
        while (!sc.hasNextInt()) {
            showMessage(message);
            sc.next();
        }
        return sc.nextInt();
    }

    /**
     * Lê um double inserido pelo utilizador
     * @param message Mensagem a ser exibida
     * @return O double lido
     */
    public double readDouble(String message) {
        showMessage(message);
        while (!sc.hasNextDouble()) {
            showMessage(message);
            sc.next();
        }
        return sc.nextDouble();
    }

    /**
     * Lê um char inserido pelo utilizador
     * @param message Mensagem a ser exibida
     * @return O char lido
     */
    public char readChar(String message) {
        String strAux = readText(message);
        if ("".equals(strAux))
            strAux = " ";

        return strAux.charAt(0);
    }

    /**
     * Lê um bool inserido pelo utilizador
     * @param message Mensagem a ser exibida
     * @return O bool lido
     */
    public boolean readBool(String message) {
        String strAux = "";
        while ("true".equals(strAux.toLowerCase()) && "false".equals(strAux.toLowerCase())) {
            strAux = readText(message);
        }
        if ("true".equals(strAux.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Lê um texto inserido pelo utilizador
     * @param message Mensagem a ser exibida
     * @return  O texto lido
     */
    public String readText(String message) {
        showMessage(message);

        return sc.nextLine();
    }
}

