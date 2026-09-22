package Composicao.Carteira;

// Composição de uma carteira de investimentos com posições em diferentes ativos.
// Demonstra a criação de uma carteira, adição de posições e cálculo do valor total.
public class Main {
    public static void main(String[] args) {
        Ativo acao = new Ativo("PETR4", "Petrobras PN", 32.50);
        Ativo fundo = new Ativo("HGLG11", "CSHG Logistica", 158.40);

        Carteira carteira = new Carteira("Carlos");
        carteira.adicionarPosicao(acao, 10);
        carteira.adicionarPosicao(fundo, 5);

        System.out.println("Carteira de " + carteira.getTitular());

        for (Posicao posicao : carteira.getPosicoes()) {
            System.out.printf(
                    "%s - %d unidades - R$ %.2f%n",
                    posicao.getAtivo().getCodigo(),
                    posicao.getQuantidade(),
                    posicao.calcularValor());
        }

        System.out.printf("Valor total: R$ %.2f%n", carteira.calcularValorTotal());
    }
}
