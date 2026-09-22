package Heranca;

public class Main {
    public static void main(String[] args) {
        Funcionario funcionarioF = new Funcionario("Carlos", 30);
        
        // Cria um objeto da classe FuncionarioAdministrativo
        FuncionarioAdministrativo funcionarioFA = new FuncionarioAdministrativo("Ana", 25, 
                                                                                "Financeiro");
        
        // Cria um objeto da classe Professor
                                                                                
        Professor funcionarioP = new Professor("João", 40, "Matemática");

        // Imprime as informações de cada funcionário usando o método toString() de cada classe
        // Cada chamada a System.out.println() invoca automaticamente o método toString() do objeto correspondente
        System.out.println(funcionarioF);
        System.out.println(funcionarioFA);
        System.out.println(funcionarioP);
    }
}
