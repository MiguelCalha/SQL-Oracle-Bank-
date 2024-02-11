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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;

public class Sensores extends DispositivoInteligente {

	private double temperatura;
	private double mediaUltimas10;
	private ArrayList<Double> temperaturas = new ArrayList();
	private PrintWriter ficheiro;
	/**
         * Contrutor da Classe Sensores
         * @param nome
         * @param marca
         * @param modelo
         * @param numeroSerie
         * @param temperatura
         * @throws FileNotFoundException 
         */
	public Sensores(String nome, String marca, String modelo, int numeroSerie, double temperatura) throws FileNotFoundException {
		super(nome, marca, modelo, numeroSerie);
		this.temperatura = temperatura;
		this.ficheiro = new PrintWriter("Temperaturas");
		this.mediaUltimas10 = 0;
	}

       /**
        * Método que regista a temperatura 
        * @param temperaturaNova 
        */
	public void registarTemperatura(double temperaturaNova) {
		this.temperatura = temperaturaNova;
                temperaturas.add(temperaturaNova);
	}
        /**
         * Método que regista a tempertaura média
         */
	public void registarMedia() {
		int media = 0;
		if (temperaturas.size() >= 10) {
			for (int i = temperaturas.size() - 10 - 1; i < temperaturas.size() - 1; i++)
				media += temperaturas.get(i);
			this.mediaUltimas10 = media / 10;
		}
	}
	
        /**
         * Método que retorna a temperatura
         * @return 
         */
	public double mostrarTemperaturaAtual() {
		return temperatura;
	}
	
        /*
        Método que regista num ficheiro as temperaturas
        */
	private void registarFicheiro() {
		ficheiro.println(temperaturas);
		ficheiro.close();
	}
	
	
}
