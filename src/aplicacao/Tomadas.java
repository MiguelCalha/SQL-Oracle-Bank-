/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import aplicacao.Estado;
import java.util.ArrayList;

/**
 *
 * @author dcalha, dsoares 190288017@ips.pt 190288003@ips.pt, dsilva 190288002@ips.pt
 */
public class Tomadas extends DispositivoInteligente {

    ArrayList<DispositivoInteligente> dispositivosLigados;
    ArrayList<DispositivoInteligente> dispositivosNaoLigados;
    private Estado estado;
    private DispositivoInteligente dispositivo;
    private Casa casa;
/**
 * Contrutor da classe Tomadas
 * @param casa
 * @param nome
 * @param marca
 * @param modelo
 * @param numeroSerie 
 */
    public Tomadas(Casa casa, String nome, String marca, String modelo, int numeroSerie) {
        super(nome, marca, modelo, numeroSerie);
        this.casa = casa;
        dispositivosLigados = new ArrayList();
        dispositivosNaoLigados = new ArrayList();
    }

    /**
     * Método que verifica se existe algum dispositivo ligado À tmada
     *
     * @param dispositivo
     */
    public void ligarDispositivoTomada(DispositivoInteligente dispositivo) {
        if(dispositivosNaoLigados.contains(dispositivo)){
            dispositivosNaoLigados.remove(dispositivo);
        }else{
            dispositivosLigados.add(dispositivo);
            dispositivo.setEstado(Estado.CONECTADO);
        }
    }
    /**
     * Método que desliga o disposito
     * @param dispositivo 
     */
    public void desligarDispositivoTomada(DispositivoInteligente dispositivo){
        
        if(dispositivosLigados.contains(dispositivo)){
            dispositivosLigados.remove(dispositivo);
        }else{
            dispositivosNaoLigados.add(dispositivo);
            dispositivo.setEstado(Estado.DESLIGADO);
        }
    }

}
