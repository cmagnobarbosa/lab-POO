package Polimorfismo;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        
        // A lista usa o tipo comum, mas guarda objetos de classes diferentes.
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Professor("João", 40, "Matemática"));
        funcionarios.add(new FuncionarioAdministrativo("Ana", 25, "Financeiro"));

        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
            // Java escolhe a implementação de acordo com a classe real do objeto.
            System.out.println("Atividade: " + funcionario.realizarAtividade());
            System.out.println();
        }
    }
}
