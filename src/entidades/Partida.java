package entidades;

import java.time.LocalDate;

import entidades.ingressos.TipoIngresso;

public class Partida {
    private String nome;
    private LocalDate data;
    private String local;
    private int ingressosInteira;
    private int ingressosMeia;
    private double valorIngresso;


    public Partida(String nome, LocalDate data, String local, int ingressosInteira, int ingressosMeia, double valorIngresso) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.ingressosInteira = ingressosInteira;
        this.ingressosMeia = ingressosMeia;
        this.valorIngresso = valorIngresso;
    }

    public double getValorIngresso() {
        return this.valorIngresso;
    }

    public String getNome() {
        return this.nome;
    }

    public LocalDate getData() {
        return this.data;
    }

    public String getLocal() {
        return this.local;
    }

    public int getIngressos() {
        return this.ingressosInteira + this.ingressosMeia;
    }

    public void atualizaInfo(LocalDate data, String local, double valor) {
        this.data = data;
        this.local = local;
        this.valorIngresso = valor;
    }

    public boolean isIngressoDisponivel(TipoIngresso tipo, int quantidade) {
        if (tipo == TipoIngresso.INTEIRA) {
            return quantidade <= this.ingressosInteira;
        }

        return quantidade <= this.ingressosMeia;
    }

    public void venderIngresso(TipoIngresso tipo) {
        if (this.isIngressoDisponivel(tipo, 1)) {
            if (tipo == TipoIngresso.INTEIRA) {
                this.ingressosInteira--;
            } else {
                this.ingressosMeia--;
            }
            System.out.println("Ingresso vendido!");
        } else {
            System.out.println("Não há ingressos disponíveis!");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Partida: ").append(this.getNome())
        .append("\nData: ").append(this.getData())
        .append("\nLocal: ").append(this.getLocal())
        .append("\nValor do ingresso: ") .append(this.getValorIngresso())
        .append("\nIngressos disponíveis: ").append(this.getIngressos());

        return sb.toString();
    }
}
