package dao;

import java.io.IOException;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import entidades.Partida;
import util.Arquivo;
import util.LeitoraDados;

public class PartidaDAO {

    private String caminho;
    private String nome, local;
    private int ano, mes, dia;
    private LocalDate data;
    private int ingressosInt, ingressosMeia;
    double valor;
    private LeitoraDados leitora = new LeitoraDados();
    static ArrayList<Partida> partidas = new ArrayList<Partida>();
    private Partida partidaProcurada;
    
    public PartidaDAO(LeitoraDados leitora) {
        this.leitora = leitora;
    }

    public PartidaDAO(String caminho) throws IOException {
        this.caminho = caminho;
        this.leitora = new LeitoraDados();
    }

    public void adicionar() {
        System.out.println("Insira as informações da partida:");

        System.out.print("Nome da partida: ");
        nome = leitora.lerTexto();

        if (procuraPartida(partidas, nome) != null) {
            System.out.println("Erro! Partida já foi criada!");
        } else {
            System.out.print("Dia da data da partida: ");
            dia = leitora.lerInt();
            
            System.out.print("Mês da data da partida: ");
            mes = leitora.lerInt();
            
            System.out.print("Ano da data da partida: ");
            ano = leitora.lerInt();
            
            data = LocalDate.of(ano, mes, dia);
            
            System.out.print("Local da partida: ");
            local = leitora.lerTexto();
            
            System.out.print("Número de ingressos tipo inteira: ");
            ingressosInt = leitora.lerInt();
            
            System.out.print("Número de ingressos tipo meia: ");
            ingressosMeia = leitora.lerInt();
            
            System.out.print("Valor do ingresso: ");
            valor = leitora.lerDouble();
            
            partidas.add(new Partida(nome, data, local, ingressosInt, ingressosMeia, valor));
            System.out.println("Partida criada!");
        } 
    }

    public void editar() {
        if (partidas.size() > 0) {
            System.out.println("Informe o nome da partida a ser editada: ");
            nome = leitora.lerTexto();
            partidaProcurada = procuraPartida(partidas, nome);
            if (partidaProcurada != null) {
                System.out.println("Dia da data da partida: ");
                dia = leitora.lerInt();

                System.out.println("Mês da data da partida: ");
                mes = leitora.lerInt();

                System.out.println("Ano da data da partida: ");
                ano = leitora.lerInt();

                data = LocalDate.of(ano, mes, dia);

                System.out.println("Local da partida: ");
                local = leitora.lerTexto();

                System.out.println("Valor do ingresso: ");
                valor = leitora.lerDouble();

                partidaProcurada.atualizaInfo(data, local, valor);
            } else {
                System.out.println("Partida não localizada!");
            }
        } else {
            System.out.println("Você precisa primeiro cadastrar uma partida!");
        }
    }

    public void excluir() {
        if (partidas.size() > 0) {
            System.out.println("Informe o nome da partida a ser excluída: ");
            nome = leitora.lerTexto();
            partidaProcurada = procuraPartida(partidas, nome);
            if (partidaProcurada != null) {
                partidas.remove(partidaProcurada);
                System.out.println("Partida removida!");
            } else {
                System.out.println("Partida não localizada!");
            }
        } else {
            System.out.println("Você precisa primeiro cadastrar uma partida!");
        }
    }

    public void retornarPartidas() {
        if (partidas.size() > 0) {
            System.out.println("Informações de todas as partidas: ");
            for (Partida partida : partidas) {
                System.out.println(partida);
                System.out.println("");
            }
        } else {
            System.out.println("Você precisa primeiro cadastrar uma partida!");
        }
    }

    public void retornarPartida() {
        if (partidas.size() > 0) {
            System.out.println("Informe o nome da partida: ");
            nome = leitora.lerTexto();
            partidaProcurada = procuraPartida(partidas, nome);
            if (partidaProcurada != null) {
                System.out.println(partidaProcurada);
            } else {
                System.out.println("Partida não localizada!");
            }
        } else {
            System.out.println("Você precisa primeiro cadastrar uma partida!");
        }
    }

    public Partida procuraPartida(ArrayList<Partida> partidas, String nomeProcurado) {
        for (Partida partida : partidas) {
            if (nomeProcurado.equals(partida.getNome())) {
                return partida;
            }
        }

        return null;
    }

    public void exportar() throws IOException {
        List<String> linhas = new ArrayList<>();

        for (Partida partida : PartidaDAO.partidas) {
            linhas.add(partida.toString());
        }

        Arquivo.escrever((this.caminho), linhas);
    }
}
