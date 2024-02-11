/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;
import aplicacao.Estado;
import javafx.scene.paint.Color;
/**
 *
 * @author dcalha, dsoares 190288017@ips.pt 190288003@ips.pt, dsilva 190288002@ips.pt
 */
public class Iluminacao extends DispositivoInteligente{
    
    private Color corLuz;
    private int intensidadeLuz;

    /**
     * Método tosTRING que imprime a informação
     * @return 
     */
    @Override
    public String toString() {
        return "Iluminacao{" + "corLuz=" + corLuz + ", intensidadeLuz=" + intensidadeLuz + '}';
    }

 
/**
 * Método que define a iluminação da residência
 * @param corLuz
 * @param intensidadeLuz
 * @param nome
 * @param marca
 * @param modelo
 * @param numSerie
 * @param estado 
 */
    public Iluminacao(Color corLuz, int intensidadeLuz, String nome, String marca, String modelo, int numSerie, Estado estado) {
        super(nome, marca, modelo, numSerie);
        if (corLuz != null) {
            this.corLuz = corLuz;
        } else {
            this.corLuz = Color.WHITE;
        }
        if (intensidadeLuz < 0) {
            intensidadeLuz = 155;
            this.intensidadeLuz = intensidadeLuz;
        } else {
            this.intensidadeLuz = intensidadeLuz;
        }
    } // estará bem?

 
/**
 * Método que define a cor da luz da residÊncia
 * @param corLuz 
 */
    public void setCorLuz(Color corLuz) {
        if (corLuz != null) {
            this.corLuz = corLuz;
        } else {
            this.corLuz = Color.WHITE;
        }
    }

 
/**
 * Método que define a itensidade da luz da residência
 * @param intensidade 
 */
    public void setIntensidadeLuz(int intensidade) {
        this.intensidadeLuz = intensidade;
    }

 /**
  * Método que retorna a cor da luz da residência
  * @return 
  */

    public Color getCorLuz() {
        return corLuz;
    }

 
/**
 * Método que retorna a itensidade da luz
 * @return 
 */
    public int getIntensidadeLuz() {
        return intensidadeLuz;
    }
    /**
     * Método que imprime as informações da lâmpada
     * @return 
     */
    public String imprimirLuz(){
        
        System.out.println("Cor da Luz: " + getCorLuz());
        System.out.println("Intensidade da Luz: " + getIntensidadeLuz());

        return "Informação da luz impressa com sucesso...";
    }


    
}