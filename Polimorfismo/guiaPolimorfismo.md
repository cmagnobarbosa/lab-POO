# Polimorfismo e classes abstratas em Java

Este guia usa o exemplo da pasta `Polimorfismo`, no qual professores e funcionários administrativos compartilham características, mas realizam atividades diferentes.

## Classe abstrata

Uma classe abstrata representa um conceito geral que não deve ser instanciado diretamente. Ela pode reunir estado e comportamentos comuns, além de declarar operações que suas subclasses precisam implementar.

```java
public abstract class Funcionario {
    private String nome;
    private int idade;

    public Funcionario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public abstract String realizarAtividade();
}
```

A palavra-chave `abstract` impede `new Funcionario(...)`. A classe ainda pode ter construtores, atributos e métodos concretos. O construtor é chamado pelas subclasses por meio de `super(...)`.

Um método abstrato declara uma obrigação sem fornecer implementação. Uma classe concreta que estende `Funcionario` deve implementar `realizarAtividade()`; caso contrário, ela própria precisará ser abstrata.

## Implementações nas subclasses

Cada tipo de funcionário implementa a atividade de acordo com sua responsabilidade:

```java
public class Professor extends Funcionario {
    private String disciplina;

    public Professor(String nome, int idade, String disciplina) {
        super(nome, idade);
        this.disciplina = disciplina;
    }

    @Override
    public String realizarAtividade() {
        return "Ministra aulas de " + disciplina + ".";
    }
}
```

```java
public class FuncionarioAdministrativo extends Funcionario {
    private String setor;

    public FuncionarioAdministrativo(String nome, int idade, String setor) {
        super(nome, idade);
        this.setor = setor;
    }

    @Override
    public String realizarAtividade() {
        return "Organiza as rotinas do setor " + setor + ".";
    }
}
```

`@Override` informa que o método está sobrescrevendo uma declaração herdada. O compilador também verifica se a assinatura está correta.

## Polimorfismo

Polimorfismo permite usar uma referência de tipo comum para objetos de diferentes subclasses. Uma chamada a um método sobrescrito executa a implementação da classe real do objeto:

```java
List<Funcionario> funcionarios = new ArrayList<>();
funcionarios.add(new Professor("João", 40, "Matemática"));
funcionarios.add(new FuncionarioAdministrativo("Ana", 25, "Financeiro"));

for (Funcionario funcionario : funcionarios) {
    System.out.println(funcionario.realizarAtividade());
}
```

Embora a variável `funcionario` tenha tipo declarado `Funcionario`, na primeira volta ela referencia um `Professor`; na segunda, um `FuncionarioAdministrativo`. Portanto, a mesma chamada `realizarAtividade()` produz respostas diferentes.

O benefício prático é escrever o fluxo uma vez e deixar cada classe cuidar de sua própria regra. Esse laço não precisa usar `instanceof`, converter tipos ou manter condições para cada categoria. Para acrescentar, por exemplo, `Pesquisador`, basta criar uma subclasse concreta e implementar `realizarAtividade()`; a lista e o laço podem continuar iguais.

## Classe abstrata e interface

Uma classe abstrata é útil quando os tipos relacionados compartilham uma identidade e implementação, como os dados `nome` e `idade` de um `Funcionario`. Ela também pode manter estado e oferecer métodos concretos.

Uma interface define um contrato que classes possivelmente sem relação de herança podem implementar. Uma classe Java pode estender apenas uma classe, mas pode implementar várias interfaces. Use uma interface quando o foco for uma capacidade ou papel compartilhado, e uma classe abstrata quando houver uma base comum apropriada.

## Quando usar

Use uma classe abstrata quando:

- o conceito geral não fizer sentido como objeto completo;
- várias subclasses compartilharem dados ou comportamento;
- houver operações comuns que cada subtipo deve adaptar;
- for útil expressar essas operações pelo tipo base.

Evite criar uma classe abstrata apenas para economizar algumas linhas. A relação entre os subtipos precisa fazer sentido no domínio, e o tipo base deve descrever corretamente o que todos eles podem fazer.

## Resumo

- `abstract class` define uma base que não pode ser instanciada diretamente.
- Métodos abstratos definem obrigações para subclasses concretas.
- `extends` estabelece a relação de herança.
- `@Override` marca uma implementação ou especialização de método herdado.
- Uma referência do tipo base pode apontar para objetos de subclasses.
- O Java escolhe em tempo de execução a implementação sobrescrita conforme a classe real do objeto.
- No exemplo, `Funcionario` define o contrato `realizarAtividade()`; cada tipo de funcionário realiza a atividade de modo próprio, e o mesmo laço processa todos.
