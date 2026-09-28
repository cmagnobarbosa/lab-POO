package Refatoracao;

/** Mantém os dados e o estado acadêmico de um aluno. */
public class Aluno {
    private final String nome;
    private final int idade;
    private final String matricula;
    private final String curso;
    private boolean ativo;
    private final Mensalidade mensalidade;

    public Aluno(String nome, int idade, String matricula, String curso,
                 double valorMensalidade) {
        this.nome = validarTexto(nome, "Nome");
        if (idade <= 0) {
            throw new IllegalArgumentException("A idade deve ser positiva.");
        }
        this.idade = idade;
        this.matricula = validarTexto(matricula, "Matrícula");
        this.curso = validarTexto(curso, "Curso");
        this.ativo = true;
        this.mensalidade = new Mensalidade(valorMensalidade);
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void desativar() {
        ativo = false;
    }

    public double getValorMensalidade() {
        return mensalidade.getValor();
    }

    public void aplicarReajusteMensalidade(double percentual) {
        mensalidade.aplicarReajustePercentual(percentual);
    }

    /** Eleva a mensalidade ao valor mínimo e informa se houve alteração. */
    public boolean ajustarMensalidadeParaMinimo(double valorMinimo) {
        return mensalidade.ajustarParaMinimo(valorMinimo);
    }

    private static String validarTexto(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(campo + " não pode ser vazio.");
        }
        return valor.trim();
    }

    @Override
    public String toString() {
        return "Aluno: " + nome
                + ", matrícula: " + matricula
                + ", curso: " + curso
                + ", ativo: " + (ativo ? "Sim" : "Não")
                + ", mensalidade: R$ " + String.format("%.2f", getValorMensalidade());
    }
}
