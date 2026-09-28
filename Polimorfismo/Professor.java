package Polimorfismo;

public class Professor  extends Funcionario {
    private String disciplina;

    public Professor(String nome, int idade, String disciplina) {
        super(nome, idade);
        this.disciplina = disciplina;
        setProfissao("Professor");
    }
    
    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String realizarAtividade() {
        return "Ministra aulas de " + disciplina + ".";
    }

    @Override 
    public String toString() {
        return super.toString() + ", Disciplina: " + disciplina;
    }
}
