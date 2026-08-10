# Guia Inicial de Java e Primeiro Projeto: Biblioteca

## Publico-alvo

Este guia foi pensado para estudantes em contato inicial com Java e Programacao Orientada a Objetos. A proposta e construir uma base pratica antes de entrar nos conceitos mais formais: primeiro entender como um programa Java nasce, compila e executa; depois aplicar essa base no primeiro projeto da disciplina.

O primeiro projeto sera um sistema simples de gerenciamento de livros de uma biblioteca.

## O que vamos construir

O projeto representa uma biblioteca de forma simplificada. Na primeira versao, ele permite:

- Criar livros com ISBN, titulo, autor e ano de publicacao.
- Guardar varios livros em uma lista.
- Mostrar os livros cadastrados na tela.
- Controlar se um livro esta disponivel ou emprestado.

Ele sera pequeno de proposito. A ideia e que cada parte do codigo ajude a entender um conceito importante de Java.

## Antes do Projeto: Primeiro Contato com Java

Java e uma linguagem de programacao orientada a objetos. Isso significa que muitos programas em Java sao organizados em torno de classes, que representam ideias do problema que queremos resolver.

Neste projeto, a ideia central e simples:

- No mundo real, uma biblioteca possui livros.
- No programa, criaremos uma classe chamada `Livro`.
- Cada livro cadastrado sera um objeto criado a partir dessa classe.

Antes de escrever a classe `Livro`, e importante reconhecer alguns elementos basicos de Java.

### 1. Arquivos Java

Arquivos Java usam a extensao `.java`.

Exemplos:

```text
Main.java
Livro.java
```

Em geral, cada classe publica fica em um arquivo com o mesmo nome da classe. Por isso, a classe `Livro` deve ficar no arquivo `Livro.java`.

### 2. Classe Principal

Todo programa Java precisa ter um ponto de entrada. Esse ponto normalmente fica no metodo `main`.

Exemplo:

```java
public static void main(String[] args) {
    System.out.println("Meu primeiro programa em Java");
}
```

Para este primeiro contato, nao e necessario memorizar todos os detalhes de `public static void main(String[] args)`. Pense nele como o lugar onde o programa comeca a executar.

### 3. Exibindo Mensagens

Para mostrar uma mensagem no terminal, usamos:

```java
System.out.println("Sistema de biblioteca");
```

O texto entre aspas aparece na tela quando o programa e executado.

### 4. Compilar e Executar

Java normalmente passa por duas etapas:

1. Compilar o codigo `.java` usando `javac`.
2. Executar o programa compilado usando `java`.

Dentro da pasta `Biblioteca`, os comandos serao:

```bash
javac Main.java biblioteca/Livro.java
java Main
```

Se o comando `javac` nao funcionar, provavelmente o JDK ainda nao esta instalado ou nao esta configurado no terminal.

## Estrutura do Primeiro Projeto

A estrutura esperada dentro da pasta `Biblioteca` e:

```text
Biblioteca/
  Main.java
  README.md
  GUIA_IMPLEMENTACAO.md
  biblioteca/
    Livro.java
```

O projeto possui:

- Uma classe `Livro`, responsavel por representar os dados e comportamentos de um livro.
- Uma classe `Main`, responsavel por criar objetos, armazenar livros em uma lista e exibir informacoes na tela.
- Um pacote chamado `biblioteca`, usado para organizar a classe `Livro`.

## Objetivos de Aprendizagem

Ao implementar este primeiro projeto, o estudante deve ser capaz de:

- Entender a diferenca entre arquivo, classe e objeto.
- Identificar o metodo `main` como ponto inicial do programa.
- Declarar atributos e metodos em uma classe.
- Criar objetos usando `new`.
- Usar construtores para inicializar objetos.
- Aplicar encapsulamento com atributos `private` e metodos de acesso.
- Organizar classes em pacotes.
- Criar e percorrer listas usando `ArrayList` e `List`.
- Sobrescrever o metodo `toString()`.
- Compilar e executar um programa Java com mais de uma classe.

## Conceitos Necessarios

### 1. Classe

Uma classe e um modelo usado para criar objetos. No projeto, a classe `Livro` define quais informacoes um livro deve ter e quais acoes ele pode realizar.

Exemplo de atributos definidos em `Livro`:

```java
private String isbn;
private String titulo;
private String autor;
private int anoPublicacao;
private boolean disponivel;
```

Esses atributos representam o estado de um livro.

### 2. Objeto

Um objeto e uma instancia concreta de uma classe. Em `Main.java`, os livros sao criados assim:

```java
Livro livro1 = new Livro("978-85-359-0277-3", "Dom Casmurro", "Machado de Assis", 1899);
```

Nesse caso, `livro1` e um objeto da classe `Livro`.

### 3. Atributos

Atributos sao variaveis pertencentes a uma classe. Eles guardam os dados de cada objeto.

No projeto, cada livro possui:

- `isbn`: codigo identificador do livro.
- `titulo`: nome da obra.
- `autor`: nome do autor.
- `anoPublicacao`: ano em que a obra foi publicada.
- `disponivel`: indica se o livro pode ser emprestado.

### 4. Metodos

Metodos representam comportamentos. Na classe `Livro`, existem metodos para consultar dados, emprestar, devolver e formatar a exibicao do livro.

Exemplo:

```java
public void emprestar() {
    if (disponivel) {
        disponivel = false;
        System.out.println("Livro emprestado com sucesso!");
    } else {
        System.out.println("Livro indisponivel para emprestimo.");
    }
}
```

Esse metodo altera o estado do objeto, mudando `disponivel` de `true` para `false` quando o livro e emprestado.

### 5. Construtor

O construtor e chamado quando um objeto e criado com `new`. Ele inicializa os atributos do objeto.

Na classe `Livro`:

```java
public Livro(String isbn, String titulo, String autor, int anoPublicacao) {
    this.isbn = isbn;
    this.titulo = titulo;
    this.autor = autor;
    this.anoPublicacao = anoPublicacao;
    this.disponivel = true;
}
```

O uso de `this` indica que o atributo pertence ao objeto atual.

### 6. Encapsulamento

Encapsulamento e o principio de proteger os dados internos de uma classe. No codigo, os atributos sao `private`, ou seja, nao podem ser acessados diretamente de fora da classe.

Para consultar os dados, sao usados metodos `get`:

```java
public String getTitulo() {
    return titulo;
}
```

Esse padrao evita alteracoes indevidas e deixa a classe mais controlada.

### 7. Booleanos e Controle de Estado

O atributo `disponivel` e do tipo `boolean`, que aceita apenas `true` ou `false`.

No contexto do sistema:

- `true`: o livro esta disponivel.
- `false`: o livro esta emprestado.

Os metodos `emprestar()` e `devolver()` alteram esse estado.

### 8. Estruturas Condicionais

O metodo `emprestar()` usa `if` e `else` para decidir o que fazer:

```java
if (disponivel) {
    disponivel = false;
} else {
    System.out.println("Livro indisponivel para emprestimo.");
}
```

Essa estrutura permite executar comportamentos diferentes dependendo da situacao do livro.

### 9. Pacotes

Pacotes organizam classes em grupos. A classe `Livro` esta no pacote `biblioteca`:

```java
package biblioteca;
```

Por isso, em `Main.java`, e necessario importar a classe:

```java
import biblioteca.Livro;
```

O nome do pacote deve corresponder a estrutura de diretorios. Como a classe esta no pacote `biblioteca`, o arquivo deve estar em:

```text
biblioteca/Livro.java
```

### 10. Listas com `List` e `ArrayList`

O projeto usa uma lista para armazenar varios livros:

```java
List<Livro> livros = new ArrayList<>();
```

Aqui existem dois conceitos importantes:

- `List<Livro>` define uma colecao de objetos do tipo `Livro`.
- `ArrayList<>` e uma implementacao concreta dessa lista.

Depois, os objetos sao adicionados:

```java
livros.add(livro1);
livros.add(livro2);
```

### 11. Laco `for-each`

Para percorrer a lista, o codigo usa:

```java
for (Livro livro : livros) {
    System.out.println(livro);
}
```

Esse laco significa: para cada objeto `Livro` dentro da lista `livros`, execute o bloco de codigo.

### 12. Metodo `toString()`

O metodo `toString()` define como o objeto sera representado em texto.

Quando o programa executa:

```java
System.out.println(livro);
```

Java chama automaticamente:

```java
livro.toString()
```

No projeto, isso permite mostrar ISBN, titulo, autor, ano de publicacao e disponibilidade.

## Roteiro Sugerido de Implementacao

Siga esta ordem para construir o primeiro projeto com calma:

1. Criar a pasta `Biblioteca`.
2. Dentro dela, criar o arquivo `Main.java`.
3. Escrever um `main` simples com `System.out.println`.
4. Compilar e executar para confirmar que o ambiente Java esta funcionando.
5. Criar a pasta `biblioteca`.
6. Criar o arquivo `Livro.java` dentro da pasta `biblioteca`.
7. Declarar o pacote `biblioteca`.
8. Criar a classe publica `Livro`.
9. Declarar os atributos privados.
10. Criar o construtor da classe.
11. Criar os metodos `get`.
12. Criar os metodos `emprestar()` e `devolver()`.
13. Sobrescrever o metodo `toString()`.
14. Voltar ao `Main.java`.
15. Importar `biblioteca.Livro`.
16. Criar objetos do tipo `Livro`.
17. Criar uma lista de livros.
18. Adicionar livros na lista.
19. Percorrer a lista e imprimir os dados.

## Como Compilar e Executar

Entre na pasta do projeto:

```bash
cd Biblioteca
```

Compile os arquivos:

```bash
javac Main.java biblioteca/Livro.java
```

Depois, execute:

```bash
java Main
```

A saida esperada sera semelhante a:

```text
Sistema de gerenciamento de biblioteca
ISBN: 978-85-359-0277-3, Título: Dom Casmurro, Autor: Machado de Assis, Ano de Publicação: 1899, Disponível: Sim
ISBN: 978-85-359-0278-0, Título: O Alquimista, Autor: Paulo Coelho, Ano de Publicação: 1988, Disponível: Sim
```

## Exercicios Propostos

1. No `Main.java`, chame o metodo `emprestar()` em um dos livros antes de imprimir a lista.
2. Teste chamar `emprestar()` duas vezes no mesmo livro e observe o resultado.
3. Chame `devolver()` em um livro emprestado e imprima novamente a lista.
4. Adicione mais tres livros a lista.
5. Crie um metodo `setTitulo(String titulo)` e discuta se permitir alterar o titulo de um livro e uma boa decisao.
6. Crie uma classe `Biblioteca` para armazenar a lista de livros e mover para ela as operacoes de adicionar e listar.
7. Implemente uma busca por ISBN.
8. Implemente uma busca por autor.
9. Crie uma validacao para impedir ano de publicacao negativo.
10. Altere o metodo `devolver()` para avisar quando o livro ja estiver disponivel.

## Pontos de Discussao em Sala

- Qual a diferenca entre escrever codigo e executar um programa?
- O que acontece na etapa de compilacao?
- Por que a classe `Livro` representa uma ideia do mundo real?
- Por que os atributos da classe `Livro` sao privados?
- Qual a diferenca entre classe e objeto?
- Por que usamos `List<Livro>` em vez de declarar varios livros separadamente?
- O metodo `emprestar()` deveria apenas alterar o estado ou tambem imprimir mensagens?
- Em quais situacoes faria sentido criar uma classe `Biblioteca`?
- O que aconteceria se o arquivo `Livro.java` estivesse fora da pasta `biblioteca`?

## Possiveis Evolucoes do Projeto

Depois que a turma dominar a versao inicial, o projeto pode ser expandido com:

- Classe `Biblioteca`.
- Classe `Usuario`.
- Classe `Emprestimo`.
- Menu interativo com `Scanner`.
- Persistencia em arquivo texto.
- Tratamento de excecoes.
