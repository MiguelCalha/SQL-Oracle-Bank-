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
import static java.lang.System.currentTimeMillis;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Casa {
    private ArrayList<Comodo> comodos;
    private String nome;
    private String code;
/**
 * Construtor da classe casa
 * @param nome 
 */
    public Casa(String nome) {
        this.comodos = new ArrayList();
        this.nome = nome;
        this.code = "1234"; //Default code
    }
/**
 * Método que retorna o código da residência
 * @return 
 */
    public String getCode() {
        return code;
    }

    /**
     * Método que retorna o nome da residência
     * @return 
     */
    public String getNome() {
        return nome;
    }
    /**
     * Método que define o nome da residência
     * @param nome 
     */
    public void setNome(String nome){
        this.nome = nome;
    }
/**
 * Método que retorna todos os cómodos
 * @return 
 */
    public List<Comodo> getComodos() {
        return comodos;
    }

    
    /**
     * Método que gera um códito para aceder à residências
     */
    public String gerarCodigoResidencia() {
        Random rd = new Random(currentTimeMillis());
        String num = "1234567890";
        code = "";
        for (int i = 0; i < 5; i++) {
            code = code + num.charAt(rd.nextInt(num.length()));
        }
        return num;
    }         
    /**
     * Método que regista um cómodo na residência adicionando-o a uma arraylist
     * @param nome 
     */
    public void registarComodo(Comodo nome) {
        if(comodos.contains(nome)){
            System.out.println("O cómodo já existe...");
        } else{
            comodos.add(nome);
        }
        System.out.println("Cómodo adicionado com sucesso!");
        
    }      
    /**
     * Método que percorre a arraylist e remove um cómodo
     * @param nome 
     */
    public void removerComodo(Comodo nome){
        
        if(comodos.contains(nome)){
            comodos.remove(nome);
        }else{
            System.out.println("O cómodo não existe...");
        }
        System.out.println("Cómodo removido com sucesso!!");
    }

  
}
