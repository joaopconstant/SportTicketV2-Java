package entidades.ingressos;

import entidades.Assento;
import entidades.Partida;

public abstract class Ingresso {
    protected Partida partida;
    protected TipoIngresso tipo;
    protected Assento assento;
    protected double preco;

    public Ingresso(Partida partida, TipoIngresso tipo, Assento assento) {
        this.partida = partida;
        this.tipo = tipo;
        this.assento = assento;
    }

    public double getPreco() {
        return this.preco;
    }

    @Override
    public String toString() {
        return "Partida: " + this.partida.getNome()
            + "\nAssento: " + this.assento
            + "\nTipo: " + this.tipo
            + "\nValor (R$): " + this.getPreco();
    }
}