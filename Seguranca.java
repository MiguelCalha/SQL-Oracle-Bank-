/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import aplicacao.Estado;

/**
 *
 * @author dcalha, dsoares 190288017@ips.pt 190288003@ips.pt, dsilva 190288002@ips.pt
 */
public class Seguranca{

    private String code;
    Casa casa = new Casa("1");
/**
 * Contrutor da classe Seguranca
 * @param code 
 */
    public Seguranca(String code) {
       
        this.code = casa.getCode();
    }

    /**
     * Pega no codigo gerado na classe anterior e verifca se este é valido ou nao
     * @param codigo
     * @return 
     */
    public boolean acederResidencia(String codigo) {
        
        int tentativas = 5;
        String validacaoCodigo = " ";
        Reader r = new Reader();
        System.out.println("Insira o codigo da residencia:");
        validacaoCodigo = r.readText("->");
        code = validacaoCodigo;
        if (code.equals(codigo)) {
        System.out.println("Acertou no código pode entrar na residência");
        return true;
        } else{
        do {
            tentativas--;
            System.out.println("Inseriu o código errado");
            System.out.println("Por favor insira o código novamente, têm " + tentativas + " restantes");
            validacaoCodigo = r.readText("->");
            if (validacaoCodigo.equals(this.code)){
                System.out.println("Acertou no código pode entrar à residência");
                return true;
                
            }
        } while(tentativas > 0 && validacaoCodigo != code);
        }
        System.out.println("Ultrapassou o número de tentativas, por favor reinicie a aplicação");
        System.exit(0);
        return false;
    }
}
