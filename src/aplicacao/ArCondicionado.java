/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;


/**
 *
 *@author dcalha, dsoares 190288017@ips.pt 190288003@ips.pt, dsilva 190288002@ips.pt
 */
public class ArCondicionado extends DispositivoInteligente {

	private int temperatura;
        
	/**
         * Construtor da classe Ar Condicionado
         * @param nome
         * @param marca
         * @param modelo
         * @param numeroSerie
         * @param estado
         * @param temperatura 
         */
	public ArCondicionado(String nome, String marca, String modelo, int numeroSerie, Estado estado, int temperatura) {
		super(nome, marca, modelo, numeroSerie);
		this.temperatura = temperatura;
	}
	
        /**
         * Método que ajusta a temperatura do ar condicionado
         * @param temperaturaNova 
         */
	public void ajustarTemperatura(int temperaturaNova) {
		this.temperatura = temperaturaNova;
                
	}
        /**
         * Método que retorna a temperatura atual
         * @return 
         */
        public int getTemperatura(){
            return temperatura;
        }
	


}