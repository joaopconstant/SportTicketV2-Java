package entidades.ingressos;

import entidades.Assento;
import entidades.Partida;

public class IngressoInteira extends Ingresso {
    public IngressoInteira(Partida partida, Assento assento) {
        super(partida, TipoIngresso.INTEIRA, assento);
        this.preco = this.partida.getValorIngresso();
    }
}