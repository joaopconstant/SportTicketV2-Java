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
        StringBuilder sb = new StringBuilder();
        sb.append("Partida").append(this.partida.getNome())
        .append("\nAssento").append(this.assento)
        .append("\nTipo: ").append(this.tipo)
        .append("\nValor (R$): ").append(this.getPreco());
        
        return sb.toString();
    }
}
