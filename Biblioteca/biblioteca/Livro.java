package biblioteca; // Pacote da classe Livro
// Pacote é uma forma de organizar as classes em Java, permitindo agrupar classes relacionadas em um mesmo namespace. 
// Isso ajuda a evitar conflitos de nomes e facilita a manutenção do código.

// Livro.java -- Classe que representa um livro em uma biblioteca.
// Classe é um modelo ou uma estrutura que define as propriedades e comportamentos de um objeto.
// Classe é uma abstração que encapsula dados (atributos) e métodos (comportamentos) relacionados a um conceito específico.
// Uma classe somente captura parte do mundo real, representando apenas os aspectos relevantes para o contexto do programa.

public class Livro {

    // Atributos da classe Livro
    // Atributos são variáveis que armazenam 
    // informações sobre o estado de um objeto.
    private String isbn;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private boolean disponivel;
    private int numeroDePaginas; // Atributo adicional para armazenar o número de páginas do livro

    // Construtor da classe Livro
    // Construtor é um método especial que é chamado quando um objeto da classe é criado.
    // Ele é usado para inicializar os atributos do objeto.
    public Livro(String isbn, String titulo, String autor, int anoPublicacao) {
        this.isbn = isbn; // "this" é uma referência ao objeto atual da classe.
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true;
    }
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Livro indisponível para empréstimo.");
        }
    }

    public void devolver() {
        disponivel = true;
        System.out.println("Livro devolvido com sucesso!");
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + ", Título: " + titulo + ", Autor: " + autor + ", Ano de Publicação: " + anoPublicacao + ", Disponível: " + (disponivel ?
    "Sim" : "Não");
    }
}