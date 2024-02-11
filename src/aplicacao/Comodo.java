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
import java.util.ArrayList;
import java.util.List;

public class Comodo {

    private String nome;
    public ArrayList<DispositivoInteligente> dispositivos;
    public ArrayList<DispositivoInteligente> tomadas;

    /**
     * Contrutor da classe Cómodo
     *
     * @param nome
     */
    public Comodo(String nome) {
        this.nome = nome;
        dispositivos = new ArrayList<>();
        tomadas = new ArrayList<>();
    }

    /**
     * Método que imprime o nome do cómodo
     */
    public void imprimirInfo() {
        System.out.println("Nome do Cómodo: " + getNome());
    }

    /**
     * Método que retorna o nme do cómodo
     *
     * @return
     */
    public String getNome() {

        return nome;
    }

    /**
     * método que define o nome do cómodo
     *
     * @param nome
     */
    public void setNome(String nome) {
        if (nome != null) {
            this.nome = nome;
        }
    }

    public void adicionarTomadas(Tomadas tomadaAdd) {

        tomadas.add(tomadaAdd);

    }

    public void removerTomadas(Tomadas tomadaRemove) {
        tomadas.remove(tomadaRemove);
    }
    
    public ArrayList<DispositivoInteligente> getTomadas(){
        return tomadas;
    }


    /**
     * Método que adiciona dispositivos ao cómodo
     *
     * @param novoDispositivo
     */
    public void adicionarDispositivos(DispositivoInteligente novoDispositivo) {
        dispositivos.add(novoDispositivo);
    }

    /**
     * Método que remove um dispositivo de um cómodo
     *
     * @param removerDispositivo
     */
    public void removerDispositivo(DispositivoInteligente removerDispositivo) {

        if (dispositivos.contains(removerDispositivo)) {
            dispositivos.remove(removerDispositivo);
        }
    }

    /**
     * Método que imprime os dispositivos do cómodo
     */
    public void imprimirDispositivos() {

        for (DispositivoInteligente dispositivo : dispositivos) {
            dispositivo.imprimirInfoDispositivo();

        }

    }

    /**
     * Método que retorna todos os dispositivos da arraylist
     *
     * @return
     */
    public ArrayList<DispositivoInteligente> getDispositivos() {
        return dispositivos;
    }

    /**
     * Método que retorna o nome do cómodo
     *
     * @return
     */
    @Override
    public String toString() {
        return "Nome do Cómodo->" + " " + nome;
    }

}
