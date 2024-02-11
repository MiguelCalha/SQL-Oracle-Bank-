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
public class Camera extends DispositivoInteligente {

    private boolean filmar;
    private int contadorFotos;

    /**
 * Contrutor
 * @param nome
 * @param marca
 * @param modelo
 * @param numeroSerie 
 */
    public Camera(String nome, String marca, String modelo, int numeroSerie) {
        super(nome, marca, modelo, numeroSerie);
    }
    /**
     * Método que verifica se está a filmar ou não
     * @return 
     */
    public boolean isFilmar() {
        return filmar;
    }

    /**
     * Método que define se está a filmar ou não
     * @param filmar 
     */
    public void setFilmar(boolean filmar) {
        this.filmar = filmar;
    }
/**
 * método que retorna quantas fotos foram tiradas
 * @return 
 */
    public int getContadorFotos() {
        return contadorFotos;
    }

    /**
     * Método que define quantas fotos foram tiradas
     * @param contadorFotos 
     */
    public void setContadorFotos(int contadorFotos) {
        this.contadorFotos = contadorFotos;
    }

    /**
     * Método que liga a camara de filmar
     * @return 
     */
    public boolean ligarCamara() {
        if(super.getEstado() == Estado.DESLIGADO) {
            this.filmar = true;
            super.setEstado(Estado.CONECTADO);
            System.out.println("A Câmera está agora a filmar...");
            return true;
        } else {
            return false;
        }
    }
    /**
     * Método que desliga a camara
     * @return 
     */
    public boolean desligarCamara() {
        if(super.getEstado() == Estado.CONECTADO) {
            this.filmar = false;
            super.setEstado(Estado.DESLIGADO);
            System.out.println("A Câmera parou filmar...");
            return true;
        } else {
            return false;
        }
    }
    /**
     * Método que tira foto
     * @return 
     */
    public int tirarFoto() {
        if(super.getEstado() == Estado.CONECTADO) {
            return ++contadorFotos;
        } else {
            return -1;
        }
    }
    /**
     * Método que imprime as informaçoes da camera
     * @return 
     */
    public String consultarCamera(){
        
        System.out.println("Camera: " +getEstado());
        System.out.println("Fotos Tiradas: " + getContadorFotos());
        System.out.println("Filmar: " + isFilmar());
        
        return "Info impressa com sucesso";
    }
    
}
