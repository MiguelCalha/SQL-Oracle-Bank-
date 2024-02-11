/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javafx.scene.paint.Color;

/**
 *
 * @author dcalha, dsoares 190288017@ips.pt 190288003@ips.pt, dsilva 190288002@ips.pt
 */
public class DispositivoInteligente {

    private String nome;
    private String marca;
    private String modelo;
    private int numeroSerie;
    private Estado estado;
    private Color cor;
  
    /**
     * Construtor da classe Dispositivo Inteligente
     * @param nome
     * @param marca
     * @param modelo
     * @param numeroSerie 
     */

    public DispositivoInteligente(String nome, String marca, String modelo, int numeroSerie) {
        if (nome == null) {
            nome = "Lâmpada";
        } else {
            this.nome = nome;
        }

        if (marca == null) {
            marca = "Sony";
        } else {
            this.marca = marca;
        }

        if (modelo == null) {
            modelo = "ZPK100";
        } else {
            this.modelo = modelo;
        }
        if (numeroSerie == 0) {
            numeroSerie = 11111111;
        } else {
            this.numeroSerie = numeroSerie;
        }

        this.estado = Estado.DESLIGADO;
    }
/**
 * Método que retorna o nome dos dispositivo
 * @return 
 */
    public String getNome() {
        return nome;
    }
/**
 * nome que define o nome do dispositivo
 * @param nome 
 */
    public void setNome(String nome) {
        this.nome = nome;
    }
/**
 * Método que retorna a marca
 * @return 
 */
    public String getMarca() {
        return marca;
    }
/**
 * Método que define a marca
 * @param marca 
 */
    public void setMarca(String marca) {
        this.marca = marca;
    }
/**
 * Método que retrona o modelo
 * @return 
 */
    public String getModelo() {
        return modelo;
    }
/**
 * Método que define o Modelo
 * @param modelo 
 */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
/**
 * Método que retorna o número de série
 * @return 
 */
    public int getNumeroSerie() {
        return numeroSerie;
    }
/**
 * Método que define o número de série
 * @param numeroSerie 
 */
    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
/**
 * Método que retorna o estado do dispositivo
 * @return 
 */
    public Estado getEstado() {
        return estado;
    }
/**
 * Método define o estado do dispositivo
 * @param estado 
 */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
/**
 * Método que liga o dispositivo
 * @param estado 
 */
    public void ligarDispositivo(DispositivoInteligente dispositivo) {

        dispositivo.setEstado(Estado.CONECTADO);
    }
/**
 * Método que desliga os dispositivos
 * @param dispositivo 
 */
    public void desligarDispositivo(DispositivoInteligente dispositivo) {

        dispositivo.setEstado(Estado.DESLIGADO);
    }
/**
 * método que imprime o estado dos dispositivos
 * @return 
 */
    public String estadoDispositivos(){
        System.out.println("Nome: " +getNome());
        System.out.println("Estado: " + getEstado());
        
        return "Estado mostrado com sucesso...";

    }
    /**
     * Método que imprime a informação dos dispositivo
     * @return 
     */
    public String imprimirInfoDispositivo() {

        System.out.println("\n");
        System.out.println("Nome do Dispositivo: " + getNome());
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Numero de Serie: " + getNumeroSerie());
        System.out.println("Estado: " + getEstado());
        return "Dispositivos Impressos com Sucesso!";
        
    }
    
    
    
}
