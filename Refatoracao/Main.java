package Refatoracao;

public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno(
                "Marina Costa",
                20,
                "2026A-014",
                "Sistemas de Informação",
                800.00);

        System.out.println(aluno);

        aluno.aplicarReajusteMensalidade(10);
        System.out.printf("Após reajuste de 10%%: R$ %.2f%n", aluno.getValorMensalidade());

        boolean valorAjustado = aluno.ajustarMensalidadeParaMinimo(900.00);
        System.out.println("A mensalidade foi elevada ao mínimo? " + valorAjustado);
        System.out.printf("Mensalidade atual: R$ %.2f%n", aluno.getValorMensalidade());
    }
}
