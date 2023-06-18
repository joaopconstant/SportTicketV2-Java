package dao;

import java.util.ArrayList;

import entidades.Assento;
import entidades.Partida;
import entidades.ingressos.Ingresso;
import entidades.ingressos.IngressoInteira;
import entidades.ingressos.IngressoMeia;
import entidades.ingressos.TipoIngresso;
import util.LeitoraDados;

public class IngressoDAO {
    private String nomeBusca, opcaoIngresso;
    private int numeroAssento;
    private char letraAssento;
    private Ingresso ingresso = null;
    private TipoIngresso tipo;
    private LeitoraDados leitora;
    private PartidaDAO partidaDAO;
    private ArrayList<Partida> partidas = PartidaDAO.partidas;
    private static ArrayList<Ingresso> ingressos = new ArrayList<Ingresso>();
    private Partida partidaVenda;
    private Assento assento;

    public IngressoDAO() {
        this.leitora = new LeitoraDados();
        this.partidaDAO = new PartidaDAO(leitora);
    }

    public void vender() {
        if (partidas.size() > 0) {
            System.out.println("Vendendo um ingresso!");
            System.out.println("Informe o nome da partida que deseja comprar ingresso: ");
            nomeBusca = leitora.lerTexto();
            
            partidaVenda = partidaDAO.procuraPartida(partidas, nomeBusca);
            if (partidaVenda != null) {
                ingresso = executarVenda(partidaVenda);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Erro! Partida com nome ");
                sb.append(nomeBusca);
                sb.append(" não encontrada!");
                System.out.println(sb);
            }
        } else {
            System.out.println("Você precisa primeiro acadastrar uma partida!");
        }
    }

    public Ingresso executarVenda(Partida partidaVenda) {
        System.out.println("Letra do assento: ");
        letraAssento = leitora.lerChar();

        System.out.println("Número do assento: ");
        numeroAssento = leitora.lerInt();

        assento = new Assento(numeroAssento, letraAssento);

        System.out.println("O seu ingresso é meia (s/n)");
        opcaoIngresso = leitora.lerTexto();

        if (opcaoIngresso.equals("s") || opcaoIngresso.equals("S")) {
            tipo = TipoIngresso.MEIA;

            ingresso = new IngressoMeia(partidaVenda, assento);
        } else {
            tipo = TipoIngresso.INTEIRA;

            ingresso = new IngressoInteira(partidaVenda, assento);
        }
        partidaVenda.venderIngresso(tipo);
        ingressos.add(ingresso);
        return ingresso;
    }

    public void retornarIngressosVendidos() {
        if (partidas.size() > 0) {
            System.out.println("Informe o nome da partida: ");
            nomeBusca = leitora.lerTexto();

            partidaVenda = partidaDAO.procuraPartida(partidas, nomeBusca);
            if (partidaVenda != null) {
                boolean possuiIngressosVendidos = false;
                for (Ingresso ingresso : ingressos) {
                    if (ingresso.getPartida().equals(partidaVenda)) {
                        System.out.println("\nIngressos vendidos: ");
                        System.out.println(ingresso);
                        System.out.println("");
                        possuiIngressosVendidos = true;
                    }
                }
                if (!possuiIngressosVendidos) {
                    System.out.println("Você precisa primeiro vender um ingresso!");
                }
            } else {
                System.out.println("Partida não encontrada!");
            }
        } else {
            System.out.println("Você precisa primeiro cadastrar uma partida!");
            }
    }

    public void retornarIngressoPartida() {
        if (partidas.size() > 0) {
            boolean partidaEncontrada = false;
            System.out.println("informe o nome da partida: ");
            nomeBusca = leitora.lerTexto();

            for (Partida partida : partidas) {
                if (partida.getNome().equals(nomeBusca)){
                    StringBuilder sb = new StringBuilder();
                    sb.append("Ingressos disponíveis: ");
                    sb.append(partida.getIngressos());
                    System.out.println(sb);

                    partidaEncontrada = true;
                    break;
                }
            }
            if (!partidaEncontrada) {
                System.out.println("Partida não encontrada!");
            }
        } else {
            System.out.println("Você precisa primeiro cadastrar uma partida!");
        }
    }

    public void retornarIngressos() {
        if (partidas.size() > 0) {
            System.out.println("Ingressos disponíveis: ");
            for (Partida partida : partidas) {
                StringBuilder sb = new StringBuilder();
                sb.append(partida.getNome());
                sb.append(": ");
                sb.append(partida.getIngressos());
                System.out.println(sb);
            }
        } else {
            System.out.println("Você precisa primeiro cadastrar uma partida!");
        }
    }

    public void retornarUltimaVenda() {
        if (ingresso != null) {
            System.out.println("Informações sobre o último ingresso vendido: ");
            System.out.println(ingresso);
        } else {
            System.out.println("Você precisa primeiro vender um ingresso!");
        }
    }
}

