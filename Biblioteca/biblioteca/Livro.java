package biblioteca;

/** Representa um livro e controla sua disponibilidade para empréstimo. */
public class Livro {
    private String isbn;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private boolean disponivel;

    public Livro(String isbn, String titulo, String autor, int anoPublicacao) {
        setIsbn(isbn);
        setTitulo(titulo);
        setAutor(autor);
        setAnoPublicacao(anoPublicacao);
        this.disponivel = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = validarTexto(isbn, "ISBN");
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = validarTexto(titulo, "Título");
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = validarTexto(autor, "Autor");
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        if (anoPublicacao <= 0) {
            throw new IllegalArgumentException("O ano de publicação deve ser positivo.");
        }
        this.anoPublicacao = anoPublicacao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    /** Empresta o livro se ele estiver disponível. */
    public boolean emprestar() {
        if (!disponivel) {
            System.out.println("Livro indisponível para empréstimo: " + titulo);
            return false;
        }

        disponivel = false;
        System.out.println("Livro emprestado com sucesso: " + titulo);
        return true;
    }

    /** Devolve o livro se ele estiver emprestado. */
    public boolean devolver() {
        if (disponivel) {
            System.out.println("O livro já está disponível: " + titulo);
            return false;
        }

        disponivel = true;
        System.out.println("Livro devolvido com sucesso: " + titulo);
        return true;
    }

    private String validarTexto(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(campo + " não pode ser vazio.");
        }
        return valor.trim();
    }

    @Override
    public String toString() {
        String status = disponivel ? "Sim" : "Não";
        return "ISBN: " + isbn
                + ", Título: " + titulo
                + ", Autor: " + autor
                + ", Ano de Publicação: " + anoPublicacao
                + ", Disponível: " + status;
    }
}
