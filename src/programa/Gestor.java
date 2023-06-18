package programa;


import java.io.IOException;

import dao.IngressoDAO;
import dao.PartidaDAO;
import entidades.*;
import entidades.ingressos.Ingresso;
import entidades.ingressos.IngressoInteira;
import entidades.ingressos.IngressoMeia;
import entidades.ingressos.TipoIngresso;

import util.LeitoraDados;

public class Gestor {
    LeitoraDados leitora;
    PartidaDAO partidaDAO;
    IngressoDAO ingressoDAO;

    public Gestor(String caminho) throws IOException {
        this.leitora = new LeitoraDados();
        this.partidaDAO = new PartidaDAO(caminho);
        this.ingressoDAO = new IngressoDAO();
    }

    public String exibeOpcoes() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nSistema de compra de ingressos!\n");
        sb.append("------\n");
        sb.append("Insira a opção desejada conforme o menu abaixo, ou digite outra mensagem para sair do programa:\n");
        sb.append("1 - Cadastrar uma nova partida;\n");
        sb.append("2 - Realizar a venda de um ingresso;\n");
        sb.append("3 - Exibir informações de todas as partidas;\n");
        sb.append("4 - Exibir informação de uma única partida;\n");
        sb.append("5 - Exibir o número de ingressos restantes de todas as partidas;\n");
        sb.append("6 - Exibir o n\u00FAmero de ingressos restantes de uma única partida;\n");
        sb.append("7 - Exibir ingressos vendidos em uma partida;\n");
        sb.append("8 - Exibir informações sobre o último ingresso vendido'\n");
        sb.append("9 - Excluir uma partida;\n");
        sb.append("10 - Editar informações de uma partida;\n");
        
        return sb.toString();
    }

    public String run() throws IOException {
        String opcao = leitora.lerTexto();

        switch (opcao) {
            case "1":
                partidaDAO.adicionar();
                break;
            case "2":
                ingressoDAO.vender();;
                break;
            case "3":
                partidaDAO.retornarPartidas();
                break;
            case "4":
                partidaDAO.retornarPartida();
                break;
            case "5":
                ingressoDAO.retornarIngressos();
                break;
            case "6":
                ingressoDAO.retornarIngressoPartida();
                break;
            case "7":
                ingressoDAO.retornarIngressosVendidos();
                break;
            case "8":
                ingressoDAO.retornarUltimaVenda();
                break;
            case "9":
                partidaDAO.excluir();
                break;
            case "10":
                partidaDAO.editar();
                break;
            default:
                partidaDAO.exportar();
                System.out.println("Saindo do programa...");
                opcao = "";
            }
            
        return opcao;
    }


    public static Ingresso venderIngresso(LeitoraDados leitora, Partida partidaVenda) {
        String opcaoIngresso;
        char letraAssento;
        TipoIngresso tipo;
        Ingresso ingresso;
        int numeroAssento;
        Assento assento;

        System.out.print("Letra do assento: ");
        letraAssento = leitora.lerChar();
        System.out.print("Número do assento: ");
        numeroAssento = leitora.lerInt();
        leitora.lerTexto();
        assento = new Assento(numeroAssento, letraAssento);

        System.out.print("O seu ingresso é meia (s/n)? ");
        opcaoIngresso = leitora.lerTexto();

        if (opcaoIngresso.equals("s")) {
            tipo = TipoIngresso.MEIA;

            ingresso = new IngressoMeia(partidaVenda, assento);
        } else {
            tipo = TipoIngresso.INTEIRA;

            ingresso = new IngressoInteira(partidaVenda, assento);
        }
        partidaVenda.venderIngresso(tipo);
        return ingresso;
    }
}
