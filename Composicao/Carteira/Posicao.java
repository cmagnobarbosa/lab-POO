package Composicao.Carteira;

public class Posicao {
    private Ativo ativo; // Referência ao ativo associado a esta posição
    private int quantidade; // Quantidade de unidades do ativo nesta posição

    public Posicao(Ativo ativo, int quantidade) {
        this.ativo = ativo;
        this.quantidade = quantidade;
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double calcularValor() {
        return ativo.getPreco() * quantidade;
    }
}
