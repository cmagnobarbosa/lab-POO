package Composicao.Carteira;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carteira {
    private String titular;
    private final List<Posicao> posicoes;

    public Carteira(String titular) {
        this.titular = titular;
        this.posicoes = new ArrayList<>();
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public List<Posicao> getPosicoes() {
        return Collections.unmodifiableList(posicoes);
    }

    public void adicionarPosicao(Ativo ativo, int quantidade) {
        posicoes.add(new Posicao(ativo, quantidade));
    }

    public double calcularValorTotal() {
        double total = 0;

        for (Posicao posicao : posicoes) {
            total += posicao.calcularValor();
        }

        return total;
    }
}
