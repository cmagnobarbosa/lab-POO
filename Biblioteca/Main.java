
import java.util.ArrayList;
import java.util.List;
import biblioteca.Livro;

class Main {

    public static void main(String[] args) {
        Livro livro1 = new Livro("978-85-359-0277-3", 
        "Dom Casmurro", 
        "Machado de Assis", 1899);
        livro1.emprestar();
        Livro livro2 = new Livro("978-85-359-0278-0", 
        "O Alquimista", 
        "Paulo Coelho", 1988);

        List<Livro> livros = new ArrayList<>();
        livros.add(livro1);
        livros.add(livro2);

        System.out.println("Sistema de gerenciamento de biblioteca");
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }
}