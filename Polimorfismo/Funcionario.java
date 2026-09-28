package Polimorfismo;
// SuperClasse ou classe Pai
// Classe base para todos os tipos de funcionários, contendo atributos comuns como nome, idade e profissão.
// Contém as características e comportamentos comuns a todos os funcionários.

public abstract class Funcionario{
    private String nome;
    private int idade;
    private String profissao;

    public Funcionario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.profissao = "Funcionario";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getProfissao() {
        return profissao;
    }

    /** Descreve a atividade realizada por cada tipo de funcionário. */
    public abstract String realizarAtividade();

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    @Override
    public String toString(){
        // Retorna uma representação em String do objeto Funcionario
        return "Nome: " + nome + ", Idade: " + idade + ", Profissao: " + profissao;
    }
}
