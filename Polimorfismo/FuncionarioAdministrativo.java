package Polimorfismo;
// Classe que representa um funcionário administrativo, herdando da classe Funcionario.
// Contém atributos e comportamentos específicos para funcionários administrativos.

public class FuncionarioAdministrativo extends Funcionario {
    private String setor;

    public FuncionarioAdministrativo(String nome, int idade, String setor) {
        super(nome, idade); // Chama o construtor da superclasse Funcionario para inicializar nome e idade
        this.setor = setor;
        setProfissao("Funcionario Administrativo"); // Define a profissão específica para funcionários administrativos
    }
    
    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public String realizarAtividade() {
        return "Organiza as rotinas do setor " + setor + ".";
    }

    @Override
    public String toString() {
        return super.toString() + ", Setor: " + setor;
    }
}
