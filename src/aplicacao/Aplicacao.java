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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javafx.scene.paint.Color;

/**
 * Método onde está localizado o menu, funciona através de um switch case onde todos os métodos são chamados
 *
 * @author dcalha
 */
public class Aplicacao {

    private Color corAva;
    private boolean menu = false;
    private static Logger logger;
    private String codigoResidencia = "";
    StringBuilder menuResidencia = new StringBuilder();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder menuInicial = new StringBuilder();
    StringBuilder dispositivos = new StringBuilder();
    Casa novaCasa = new Casa("Casa do Duarte");
    Seguranca seguranca = new Seguranca("12345");

    public boolean start() throws IOException {
        ArCondicionado arcondicionado = new ArCondicionado("ArCondicionado", "LG", "ZPLO12", 12983, Estado.DESCONECTADO, 12);
        Iluminacao iluminacao = new Iluminacao(Color.WHITE, 12, "Lampada", "Sonny", "KLOS", 123, Estado.DESCONECTADO);
        Camera camera = new Camera("Camera de Vigilância", "Sonny", "LJSD", 2);
        Tomadas tomada = new Tomadas(novaCasa, "NOME", "LG", "LIUL", 3489);

        menuResidencia.append("(1). Código Residência \n(2). Aceder a Residência \n(3). Nome Casa \n(4). Adicionar Cómodo \n(5). Listar Cómodos \n(6). Adicionar Dispositivos \n(7). Listar Dispositivos por cómodo \n(8). Ligar Dispositivos  \n(9). Desligar Dispositivos \n(10). Mostrar Estado dos Dispositivos \n(11). Remover Dispositivos \n(12). Alterar Cor da Luz/Intensidade \n(13). Ver Informações das Lâmpadas \n(14). Ajustar Temperatura da Residência \n(15). Temperatura Atual da Casa \n(16). Câmera de Vigilância \n(17). Ver estado da Câmara \n(18). Remover Cómodo \n(19). Mudar nome da casa \n(0). Sair");
        System.out.println(menuResidencia);
        String opcao = reader.readLine();
        do {

            if (menu == true && opcao != "0") {
                System.out.println(menuInicial);
                opcao = reader.readLine();
                menu = false;

            }

            switch (opcao) {
                case "1":
                    novaCasa.gerarCodigoResidencia();
                    System.out.println("\nO seu código de residência é:" + novaCasa.getCode());
                    codigoResidencia = novaCasa.getCode();
                    logger.addLog("Gerou código de residência ");
                    menu = true;

                    break;

                case "2":
                    System.out.println("Aceder à residência: " + novaCasa.getNome());
                    seguranca.acederResidencia(codigoResidencia);
                    logger.addLog("Acedeu à residencia " + novaCasa.getNome());
                    menu = true;
                    break;

                case "3":
                    seguranca.acederResidencia(codigoResidencia);
                    System.out.println("Nome da Casa-> " + novaCasa.getNome());
                    logger.addLog("Viu o nome da casa ");
                    menu = true;

                    break;

                case "4":
                    seguranca.acederResidencia(codigoResidencia);
                    System.out.println("Insira o nome do cómodo: ");
                    opcao = reader.readLine();
                    novaCasa.registarComodo(new Comodo(opcao));
                    logger.addLog("Adicionou um novo cómodo à casa " + novaCasa.getNome());
                    menu = true;
                    break;

                case "5":
                    seguranca.acederResidencia(codigoResidencia);
                    for (int i = 0; i < novaCasa.getComodos().size(); i++) {
                        System.out.println(novaCasa.getComodos().get(i));
                    }
                    logger.addLog("Imprimiu todos os cómodos");
                    menu = true;
                    break;

                case "6":
                    Color cor = Color.WHITE;
                    int intensidade = 0;
                    String nome = "";
                    String marca = " ";
                    String modelo = " ";
                    String numeroSerie = "";
                    Estado estado = Estado.DESCONECTADO;
                    seguranca.acederResidencia(codigoResidencia);
                    System.out.println("Insira o nome do cómodo a qual quer adicionar um dispositivo: ");
                    opcao = reader.readLine();
                    for (int i = 0; i < novaCasa.getComodos().size(); i++) {
                        if (opcao.equals(novaCasa.getComodos().get(i).getNome())) {
                            System.out.println("Qual o dispositivo que deseja adicionar? (Escreva o nome)");
                            dispositivos.append("\n (1). Lâmpada\n (2). Ar-Condicionado\n (3). Tomadas\n (4). Sensor\n (5). Câmera de VigiLância");
                            System.out.println(dispositivos);
                            opcao = reader.readLine();

                            switch (opcao) {

                                case "1":
                                    System.out.println("Insira o nome do dispositivo: ");
                                    nome = reader.readLine();

                                    System.out.println("Insira a Marca: ");
                                    marca = reader.readLine();
                                    System.out.println("Insira o Modelo: ");
                                    modelo = reader.readLine();
                                    System.out.println("Insira o número de série: ");
                                    numeroSerie = reader.readLine();
                                    int numero = Integer.parseInt(numeroSerie);
                                    novaCasa.getComodos().get(i).adicionarDispositivos(new Iluminacao(cor, 1, nome, marca, modelo, numero, estado));
                                    System.out.println("Dispositivo adicionado com sucesso...");
                                    logger.addLog("Adicionou uma lâmpada ao cómodo" + novaCasa.getComodos().get(i).getNome());
                                    break;
                                case "2":
                                    System.out.println("Insira o nome do dispositivo: ");
                                    nome = reader.readLine();

                                    System.out.println("Insira a Marca: ");
                                    marca = reader.readLine();
                                    System.out.println("Insira o Modelo: ");
                                    modelo = reader.readLine();
                                    System.out.println("Insira o número de série: ");
                                    numeroSerie = reader.readLine();
                                    numero = Integer.parseInt(numeroSerie);
                                    novaCasa.getComodos().get(i).adicionarDispositivos(new ArCondicionado(nome, marca, modelo, numero, estado, 20));
                                    System.out.println("Dispositivo adicionado com sucesso...");
                                    logger.addLog("Adicionou um Ar condicionado ao cómodo" + novaCasa.getComodos().get(i).getNome());
                                    break;

                                case "3":
                                    System.out.println("Insira o nome do dispositivo: ");
                                    nome = reader.readLine();

                                    System.out.println("Insira a Marca: ");
                                    marca = reader.readLine();
                                    System.out.println("Insira o Modelo: ");
                                    modelo = reader.readLine();
                                    System.out.println("Insira o número de série: ");
                                    numeroSerie = reader.readLine();
                                    numero = Integer.parseInt(numeroSerie);
                                    novaCasa.getComodos().get(i).adicionarDispositivos(new Tomadas(novaCasa, nome, marca, modelo, numero));
                                    System.out.println("Dispositivo adicionado com sucesso...");
                                    logger.addLog("Adicionou uma tomada ao cómodo" + novaCasa.getComodos().get(i).getNome());
                                    break;

                                case "4":
                                    System.out.println("Insira o nome do dispositivo: ");
                                    nome = reader.readLine();

                                    System.out.println("Insira a Marca: ");
                                    marca = reader.readLine();
                                    System.out.println("Insira o Modelo: ");
                                    modelo = reader.readLine();
                                    System.out.println("Insira o número de série: ");
                                    numeroSerie = reader.readLine();
                                    numero = Integer.parseInt(numeroSerie);
                                    novaCasa.getComodos().get(i).adicionarDispositivos(new Sensores(nome, marca, modelo, numero, 1.1));
                                    System.out.println("Dispositivo adicionado com sucesso...");
                                    logger.addLog("Adicionou um sensor ao cómodo" + novaCasa.getComodos().get(i).getNome());
                                    break;

                                case "5":
                                    System.out.println("Insira o nome do dispositivo: ");
                                    nome = reader.readLine();

                                    System.out.println("Insira a Marca: ");
                                    marca = reader.readLine();
                                    System.out.println("Insira o Modelo: ");
                                    modelo = reader.readLine();
                                    System.out.println("Insira o número de série: ");
                                    numeroSerie = reader.readLine();
                                    numero = Integer.parseInt(numeroSerie);
                                    novaCasa.getComodos().get(i).adicionarDispositivos(new Camera(nome, marca, modelo, numero));
                                    System.out.println("Dispositivo adicionado com sucesso...");
                                    logger.addLog("Adicionou uma camera de vigilância ao cómodo" + novaCasa.getComodos().get(i).getNome());

                                    break;
                            }

                        }
                    }

                    menu = true;
                    break;

                case "7":
                    System.out.println("Insira o nome do cómodo que quer ver os dispositivos-> ");
                    opcao = reader.readLine();
                    for (int i = 0; i < novaCasa.getComodos().size(); i++) {
                        if (opcao.equals(novaCasa.getComodos().get(i).getNome())) {

                            novaCasa.getComodos().get(i).imprimirDispositivos();
                            logger.addLog("Viu todos os dispositivos do cómodo" + novaCasa.getComodos().get(i).getNome());
                        }
                    }

                    menu = true;
                    break;

                case "8":
                    String nomeTomada = " ";
                    String nomeDispositivo = " ";
                    System.out.println("Insira o nome do cómodo->  ");
                    opcao = reader.readLine();

                    for (int i = 0; i < novaCasa.getComodos().size(); i++) {
                        if (opcao.equals(novaCasa.getComodos().get(i).getNome())) {
                            System.out.println("Insira o nome do dispositivo que quer ligar-> ");
                            nomeDispositivo = reader.readLine();
                            for (int j = 0; j < novaCasa.getComodos().size(); j++) {
                                if (nomeDispositivo.equals(novaCasa.getComodos().get(i).getDispositivos().get(j).getNome())) {
                                    tomada.ligarDispositivoTomada(novaCasa.getComodos().get(i).getDispositivos().get(j));
                                    novaCasa.getComodos().get(i).getDispositivos().get(i).ligarDispositivo(novaCasa.getComodos().get(i).getDispositivos().get(j));
                                    System.out.println("Dispositivo: " + novaCasa.getComodos().get(i).getDispositivos().get(j).getNome() + " ligado com sucesso à tomada");
                                    logger.addLog("Ligou o dispositivo: " + novaCasa.getComodos().get(i).getDispositivos() + " do cómodo " + novaCasa.getComodos().get(i).getNome());

                                }

                            }

                        }

                    }
                    menu = true;
                    break;

                case "9":
                    System.out.println("Insira o nome do cómodo->  ");
                    opcao = reader.readLine();

                    for (int i = 0; i < novaCasa.getComodos().size(); i++) {
                        if (opcao.equals(novaCasa.getComodos().get(i).getNome())) {
                            System.out.println("Insira o nome do dispositivo que quer Desligar-> ");
                            opcao = reader.readLine();

                            for (int j = 0; j < novaCasa.getComodos().size(); j++) {
                                if (opcao.equals(novaCasa.getComodos().get(i).getDispositivos().get(j).getNome())) {
                                    tomada.desligarDispositivoTomada(novaCasa.getComodos().get(i).getDispositivos().get(j));
                                    novaCasa.getComodos().get(i).getDispositivos().get(i).desligarDispositivo(novaCasa.getComodos().get(i).getDispositivos().get(j));
                                    System.out.println("Dispositivo Desligado com sucesso!");
                                    logger.addLog("Desligou o dispositivo: " + novaCasa.getComodos().get(i).getDispositivos() + " da tomada " + novaCasa.getComodos().get(i).getTomadas());
                                }

                            }
                        }
                    }
                    menu = true;
                    break;

                case "10":
                    System.out.println("Insira o nome do cómodo: ");
                    opcao = reader.readLine();

                    for (int i = 0; i < novaCasa.getComodos().size(); i++) {
                        if (opcao.equals(novaCasa.getComodos().get(i).getNome())) {
                            System.out.println("Insira o nome do dispositivo que quer ver o estado: ");
                            opcao = reader.readLine();

                            for (int j = 0; j < novaCasa.getComodos().size(); j++) {
                                if (opcao.equals(novaCasa.getComodos().get(i).getDispositivos().get(j).getNome())) {

                                    novaCasa.getComodos().get(i).getDispositivos().get(i).estadoDispositivos();
                                    logger.addLog("Viu o estado do dispositivo " + novaCasa.getComodos().get(i).getDispositivos() + " do cómodo " + novaCasa.getComodos().get(i).getNome());

                                }

                            }
                        }
                    }

                    menu = true;
                    break;

                case "11":
                    System.out.println("Insira o nome do cómodo: ");
                    opcao = reader.readLine();

                    for (int i = 0; i < novaCasa.getComodos().size(); i++) {
                        if (opcao.equals(novaCasa.getComodos().get(i).getNome())) {
                            System.out.println("Insira o nome do dispositivo que quer remover: ");
                            opcao = reader.readLine();

                            for (int j = 0; j < novaCasa.getComodos().size(); j++) {
                                if (opcao.equals(novaCasa.getComodos().get(i).getDispositivos().get(j).getNome())) {
                                    novaCasa.getComodos().get(i).getDispositivos().remove(novaCasa.getComodos().get(i).getDispositivos().get(j));
                                    logger.addLog("Removeu o dispositivo " + novaCasa.getComodos().get(i).getDispositivos() + " do cómodo " + novaCasa.getComodos().get(i).getNome());

                                    System.out.println("Dispositivo removido com sucesso!!");

                                }

                            }
                        }
                    }

                    menu = true;
                    break;

                case "12":
                    Color corLuz = Color.WHITE;
                    String cor1 = " ";
                    int intensidadeLuz = 0;
                    String intensidade1 = "";
                    System.out.println("Insira o nome do cómodo onde está a lâmpada: ");
                    opcao = reader.readLine();

                    for (int i = 0; i < novaCasa.getComodos().size(); i++) {
                        if (opcao.equals(novaCasa.getComodos().get(i).getNome())) {
                            System.out.println("Insira o nome da lâmpada: ");
                            opcao = reader.readLine();

                            for (int j = 0; j < novaCasa.getComodos().size(); j++) {
                                if (opcao.equals(novaCasa.getComodos().get(i).getDispositivos().get(j).getNome())) {
                                    System.out.println("Insira a cor da luz-> ");
                                    cor1 = reader.readLine();
                                    if (cor1 == "branco") {
                                        iluminacao.setCorLuz(Color.WHITE);
                                    } else if (cor1 == "azul") {
                                        iluminacao.setCorLuz(Color.BLUE);
                                    } else if (cor1 == "vermelho") {
                                        iluminacao.setCorLuz(Color.RED);
                                    }
                                    logger.addLog("Alterou a intensidade e a cor de uma lâmpada");

                                    System.out.println("Insira a itensidade da luz-> ");
                                    intensidade1 = reader.readLine();
                                    intensidadeLuz = Integer.parseInt(intensidade1);
                                    iluminacao.setIntensidadeLuz(intensidadeLuz);
                                    System.out.println("Lâmpada Alterada com Sucesso!");
                                }

                            }
                        }
                    }
                    menu = true;
                    break;

                case "13":
                    System.out.println("Insira o nome do cómodo onde está a lâmpada: ");
                    opcao = reader.readLine();

                    for (int i = 0; i < novaCasa.getComodos().size(); i++) {
                        if (opcao.equals(novaCasa.getComodos().get(i).getNome())) {
                            System.out.println("Insira o nome da lâmpada: ");
                            opcao = reader.readLine();

                            for (int j = 0; j < novaCasa.getComodos().size(); j++) {
                                if (opcao.equals(novaCasa.getComodos().get(i).getDispositivos().get(j).getNome())) {

                                    iluminacao.imprimirLuz();
                                    logger.addLog("Imprimiu a informação das lâmpadas");

                                }
                            }
                        }
                    }

                    menu = true;
                    break;

                case "14":
                    String temperatura = "0";
                    int temperaturaNova = 0;
                    System.out.println("Insira o nome do cómodo onde está o ar condicionado pretendido: ");
                    opcao = reader.readLine();

                    for (int i = 0; i < novaCasa.getComodos().size(); i++) {
                        if (opcao.equals(novaCasa.getComodos().get(i).getNome())) {
                            System.out.println("Insira o nome do ar condicionado: ");
                            opcao = reader.readLine();

                            for (int j = 0; j < novaCasa.getComodos().size(); j++) {
                                if (opcao.equals(novaCasa.getComodos().get(i).getDispositivos().get(j).getNome())) {

                                    System.out.println("Insira a nova temperatura desejada: ");
                                    temperatura = reader.readLine();
                                    temperaturaNova = Integer.parseInt(temperatura);
                                    arcondicionado.ajustarTemperatura(temperaturaNova);
                                    System.out.println("Nova Temperatura: " + arcondicionado.getTemperatura() + "graus");
                                    logger.addLog("Alterou a temperatura da casa ");

                                }

                            }
                        }
                    }
                    menu = true;
                    break;

                case "15":

                    System.out.println("Insira o nome do cómodo onde está o ar condicionado pretendido: ");
                    opcao = reader.readLine();

                    for (int i = 0; i < novaCasa.getComodos().size(); i++) {
                        if (opcao.equals(novaCasa.getComodos().get(i).getNome())) {
                            System.out.println("Insira o nome do ar condicionado: ");
                            opcao = reader.readLine();
                            for (int j = 0; j < novaCasa.getComodos().size(); j++) {
                                if (opcao.equals(novaCasa.getComodos().get(i).getDispositivos().get(j).getNome())) {
                                    System.out.println("A temperatura atual da casa é" + arcondicionado.getTemperatura());
                                    logger.addLog("Consultou a temperatura atual da casa ");

                                }
                            }
                        }
                    }

                    menu = true;
                    break;

                case "16":
                    int contadorFotos = 0;
                    System.out.println("Insira o nome do cómodo onde está a camera de vigilância: ");
                    opcao = reader.readLine();

                    for (int i = 0; i < novaCasa.getComodos().size(); i++) {
                        if (opcao.equals(novaCasa.getComodos().get(i).getNome())) {
                            System.out.println("Insira o nome da camera que quer ligar: ");
                            opcao = reader.readLine();
                            for (int j = 0; j < novaCasa.getComodos().size(); j++) {
                                if (opcao.equals(novaCasa.getComodos().get(i).getDispositivos().get(j).getNome())) {
                                    System.out.println("(1). Tirar Foto");
                                    System.out.println("(2). Começar a Filmar");
                                    System.out.println("(3). Parar a Filmar");
                                    opcao = reader.readLine();

                                    switch (opcao) {
                                        case "1":
                                            contadorFotos += 1;
                                            camera.tirarFoto();
                                            logger.addLog("Tirou uma foto");
                                            camera.setContadorFotos(contadorFotos);
                                            System.out.println("Tirou uma foto...");
                                            break;

                                        case "2":
                                            boolean aFilmar = true;
                                            camera.ligarCamara();
                                            camera.setFilmar(aFilmar);
                                            logger.addLog("Começou a filmar");
                                            break;

                                        case "3":
                                            aFilmar = false;
                                            camera.ligarCamara();
                                            camera.setFilmar(aFilmar);
                                            logger.addLog("Camera Parou de filmar");
                                            System.out.println("Parou de Filmar...");
                                            break;
                                    }

                                }
                            }
                        }
                    }

                    menu = true;
                    break;

                case "17":
                    System.out.println("Insira o nome do cómodo onde está a camera de vigilância: ");
                    opcao = reader.readLine();

                    for (int i = 0; i < novaCasa.getComodos().size(); i++) {
                        if (opcao.equals(novaCasa.getComodos().get(i).getNome())) {
                            System.out.println("Insira o nome da camera: ");
                            opcao = reader.readLine();
                            for (int j = 0; j < novaCasa.getComodos().size(); j++) {
                                if (opcao.equals(novaCasa.getComodos().get(i).getDispositivos().get(j).getNome())) {
                                    camera.consultarCamera();
                                    logger.addLog("Consultou o estado da câmera ");
                                }
                            }
                        }
                    }
                    menu = true;
                    break;

                case "18":
                    System.out.println("Insira o nome do cómodo que deseja remover: ");
                    opcao = reader.readLine();

                    for (int i = 0; i < novaCasa.getComodos().size(); i++) {
                        if (opcao.equals(novaCasa.getComodos().get(i).getNome())) {
                            novaCasa.removerComodo(novaCasa.getComodos().get(i));
                            logger.addLog("Removeu o cómodo" + novaCasa.getComodos().get(i).getNome());
                        }
                    }
                    menu = true;
                    break;

                case "19":
                    seguranca.acederResidencia(codigoResidencia);
                    System.out.println("Nome Atual da casa-> " + novaCasa.getNome());
                    System.out.println("Insira o novo nome da casa-> ");
                    opcao = reader.readLine();
                    novaCasa.setNome(opcao);
                    System.out.println("Nome da Casa alterado com sucesso!!");
                    menu = true;
                    break;
                case "0":
                    logger.flush();
                    System.exit(0);
                    break;

            }

        } while (menu);

        return true;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws IOException {

        Aplicacao a = new Aplicacao();
        logger = new Logger("logs.txt");
        a.start();
    }

}
