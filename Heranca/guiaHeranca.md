# Herança e Composição em Java

## Introdução

Herança e composição são formas de relacionar classes na Programação Orientada a Objetos. Embora as duas permitam reutilizar código e organizar responsabilidades, elas representam relações diferentes.

- **Herança** representa uma relação do tipo **“é um”**.
- **Composição** representa uma relação do tipo **“tem um”** ou **“é formado por”**.

A escolha deve ser feita com base no significado da relação entre os objetos, e não apenas para evitar repetição de código.

## Herança

Na herança, uma classe mais específica, chamada **subclasse**, recebe atributos e métodos de uma classe mais geral, chamada **superclasse**.

Em Java, a herança é declarada com a palavra-chave `extends`:

```java
public class Professor extends Funcionario {
    private String disciplina;
}
```

Nesse exemplo, `Professor` herda os atributos e métodos acessíveis de `Funcionario`. Portanto, um professor pode utilizar comportamentos como `setNome()` e `setIdade()` sem declará-los novamente.

### Exemplo do projeto

A estrutura da pasta `Heranca` pode ser representada assim:

```text
              Funcionario
             /           \
    Professor       FuncionarioAdministrativo
    disciplina              setor
```

`Funcionario` reúne características comuns:

```java
public class Funcionario {
    private String nome;
    private int idade;

    // getters e setters
}
```

As subclasses acrescentam características específicas:

```java
public class FuncionarioAdministrativo extends Funcionario {
    private String setor;
}
```

Essa modelagem é coerente porque:

- Professor **é um** funcionário.
- Funcionário administrativo **é um** funcionário.

### Polimorfismo

A herança também permite tratar objetos diferentes por meio de um tipo comum:

```java
Funcionario funcionario1 = new Professor();
Funcionario funcionario2 = new FuncionarioAdministrativo();
```

Isso é útil quando várias subclasses devem participar de uma mesma operação. Por exemplo, uma lista de funcionários pode armazenar professores e funcionários administrativos:

```java
List<Funcionario> funcionarios = new ArrayList<>();
funcionarios.add(new Professor());
funcionarios.add(new FuncionarioAdministrativo());
```

### Vantagens da herança

- Reutiliza características realmente comuns.
- Representa especializações de um conceito geral.
- Permite polimorfismo.
- Centraliza comportamentos compartilhados na superclasse.

### Cuidados com a herança

- A subclasse fica fortemente ligada à superclasse.
- Alterações na superclasse podem afetar todas as subclasses.
- Hierarquias extensas ficam difíceis de entender e manter.
- A herança não deve ser usada apenas para reutilizar alguns métodos.
- Uma subclasse deve continuar fazendo sentido em qualquer lugar onde a superclasse seja esperada.

## Composição

Na composição, uma classe é construída utilizando objetos de outras classes. Em vez de herdar o comportamento, ela delega parte do trabalho aos objetos que possui.

No exemplo do projeto, uma `Carteira` contém posições:

```java
public class Carteira {
    private final List<Posicao> posicoes;

    public Carteira(String titular) {
        this.posicoes = new ArrayList<>();
    }
}
```

A carteira cria e administra suas posições:

```java
public void adicionarPosicao(Ativo ativo, int quantidade) {
    posicoes.add(new Posicao(ativo, quantidade));
}
```

A estrutura pode ser representada assim:

```text
Carteira
└── possui Posicoes
    └── cada Posicao referencia um Ativo
```

A relação entre `Carteira` e `Posicao` é o principal exemplo de composição: a posição faz parte da carteira e é criada por ela.

Já a relação entre `Posicao` e `Ativo` é mais precisamente uma **associação**. O ativo é criado fora da posição e pode existir independentemente dela, além de poder ser referenciado por várias posições.

### Cálculo delegado

Cada classe cuida da responsabilidade relacionada aos seus próprios dados. A posição calcula seu valor:

```java
public double calcularValor() {
    return ativo.getPreco() * quantidade;
}
```

A carteira calcula o total usando suas posições:

```java
public double calcularValorTotal() {
    double total = 0;

    for (Posicao posicao : posicoes) {
        total += posicao.calcularValor();
    }

    return total;
}
```

### Vantagens da composição

- Produz classes menos dependentes umas das outras.
- Permite trocar componentes com mais facilidade.
- Favorece classes pequenas e com responsabilidades específicas.
- Evita hierarquias de herança desnecessárias.
- Permite combinar comportamentos diferentes.

### Cuidados com a composição

- É necessário definir claramente quem cria e administra cada objeto.
- O estado interno não deve ser exposto de forma que qualquer classe possa alterá-lo livremente.
- Cada classe deve ter uma responsabilidade clara.
- A composição pode exigir métodos de delegação adicionais.

## Herança ou composição?

Antes de escolher, verifique qual frase representa melhor a relação:

| Pergunta | Relação indicada |
| --- | --- |
| Um objeto **é um tipo de** outro objeto? | Herança |
| Um objeto **possui** ou **utiliza** outro objeto? | Composição ou associação |
| O objeto interno depende do objeto principal para existir? | Composição |
| Os dois objetos podem existir de forma independente? | Associação |

Exemplos:

| Relação | Modelagem recomendada |
| --- | --- |
| Professor é um funcionário | Herança |
| Carteira possui posições | Composição |
| Posição referencia um ativo | Associação |
| Carro possui um motor | Composição, dependendo do domínio |
| Pedido possui itens | Composição |
| Funcionário pertence a um departamento | Associação |

## Recomendações práticas

1. **Prefira composição quando não existir uma relação clara de especialização.** Ela normalmente oferece mais flexibilidade e reduz o acoplamento.

2. **Use herança quando a relação “é um” for verdadeira no domínio.** A subclasse deve preservar as expectativas estabelecidas pela superclasse.

3. **Evite criar subclasses somente para reutilizar código.** Nesse caso, extraia o comportamento para outra classe e utilize composição.

4. **Mantenha as hierarquias pequenas.** Muitos níveis de herança tornam o comportamento difícil de localizar.

5. **Proteja o estado interno dos objetos.** A `Carteira`, por exemplo, retorna uma visualização não modificável de suas posições:

   ```java
   public List<Posicao> getPosicoes() {
       return Collections.unmodifiableList(posicoes);
   }
   ```

6. **Valide os dados recebidos.** Quantidade, idade e preço, por exemplo, não deveriam aceitar valores negativos.

7. **Evite setters sem necessidade.** Se um atributo não deve mudar depois da criação, declare-o como `final` e inicialize-o no construtor.

8. **Use nomes que expressem a relação do domínio.** Métodos como `adicionarPosicao()` comunicam melhor a intenção do que um setter genérico para a lista inteira.

9. **Coloque o comportamento próximo dos dados que ele utiliza.** `Posicao` deve calcular seu valor, enquanto `Carteira` deve somar suas posições.

10. **Use polimorfismo quando as subclasses tiverem comportamentos diferentes.** Se professores e funcionários administrativos calcularem salário de maneiras distintas, um método sobrescrito pode representar essa diferença.

## Possíveis melhorias nos exemplos

O exemplo de herança pode ser ampliado com:

- construtores para inicializar os atributos obrigatórios;
- sobrescrita de `toString()`;
- uma lista de `Funcionario` para demonstrar polimorfismo;
- métodos específicos sobrescritos, como `calcularSalario()`;
- validação da idade.

O exemplo de composição pode ser ampliado com:

- validação para impedir preços e quantidades negativos;
- operações para aumentar, reduzir ou remover uma posição;
- busca de posição pelo código do ativo;
- uso de `BigDecimal` no lugar de `double` para valores monetários;
- testes automatizados para os cálculos.

## Conclusão

Herança e composição não são soluções concorrentes para todos os casos. Cada uma representa uma relação diferente:

- Use **herança** para especialização: `Professor` **é um** `Funcionario`.
- Use **composição** para formação: `Carteira` **possui** objetos `Posicao`.
- Use **associação** quando os objetos colaboram, mas possuem ciclos de vida independentes: `Posicao` referencia um `Ativo`.

Em caso de dúvida, a composição costuma ser o ponto de partida mais flexível. A herança deve ser adotada quando a relação de especialização estiver clara e fizer sentido para o domínio modelado.