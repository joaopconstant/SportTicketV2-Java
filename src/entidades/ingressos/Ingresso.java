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

    public Partida getPartida() {
        return this.partida;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Partida").append(this.partida.getNome());
        sb.append("\nAssento: ").append(this.assento);
        sb.append("\nTipo: ").append(this.tipo);
        sb.append("\nValor (R$): ").append(this.getPreco());
        
        return sb.toString();
    }
}
