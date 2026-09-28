# Refatoração: separando aluno e mensalidade

Este exemplo mostra como reorganizar uma classe que acumulava dados acadêmicos e regras financeiras. A pasta contém a versão refatorada: `Aluno.java`, `Mensalidade.java` e `Main.java`.

## O que é refatoração?

Refatorar é melhorar a estrutura interna do código preservando o comportamento que os usuários esperam. A mudança deste exemplo separa responsabilidades: `Aluno` representa o estudante; `Mensalidade` mantém o valor e aplica suas regras.

## O problema da versão inicial

A classe `Aluno` guardava nome, idade e matrícula, mas também guardava e alterava o valor da mensalidade. Isso dava à classe motivos diferentes para mudar: alterações no cadastro do estudante e alterações nas regras financeiras.

A mensalidade também podia ficar sem valor inicial. Como era um `Double`, o cálculo percentual podia falhar ao tentar usar um valor `null`. A classe ainda usava `Boolean`, que também poderia representar um estado indefinido, e tinha métodos de atualização com nomes pouco claros.

## Como ficou a divisão

### `Aluno`

A classe guarda dados acadêmicos, seu estado ativo e uma instância de `Mensalidade`. Ela delega as operações financeiras à mensalidade:

```java
public void aplicarReajusteMensalidade(double percentual) {
    mensalidade.aplicarReajustePercentual(percentual);
}
```

O método deixa claro que o aluno oferece a operação no contexto do cadastro, mas a regra de cálculo pertence a `Mensalidade`.

### `Mensalidade`

A classe inicializa e valida o valor, aplica reajustes percentuais e pode elevar a cobrança até um valor mínimo:

```java
public void aplicarReajustePercentual(double percentual) {
    if (percentual < 0) {
        throw new IllegalArgumentException("O percentual não pode ser negativo.");
    }
    valor += valor * percentual / 100;
}
```

O exemplo também rejeita valores negativos, infinitos ou inválidos. Um reajuste de `0` é permitido e mantém o valor igual.

O método `ajustarParaMinimo` só altera a mensalidade quando ela está abaixo do piso e retorna `true` se houve alteração. O retorno deixa o resultado da operação explícito para quem chama.

## Uso no programa

`Main.java` cria um aluno, aplica um reajuste e ajusta o valor mínimo:

```java
Aluno aluno = new Aluno(
        "Marina Costa", 20, "2026A-014", "Sistemas de Informação", 800.00);

aluno.aplicarReajusteMensalidade(10);
boolean alterou = aluno.ajustarMensalidadeParaMinimo(900.00);
```

Depois do reajuste, o valor é R$ 880,00. Como isso é menor que o mínimo de R$ 900,00, o ajuste eleva a mensalidade para R$ 900,00 e retorna `true`.

## Benefícios da refatoração

- Cada classe tem uma responsabilidade mais clara.
- A mensalidade sempre começa com um valor validado.
- As regras financeiras podem mudar sem misturar a implementação com os dados acadêmicos.
- `double` e `boolean` evitam estados nulos que não são necessários neste exemplo.
- Os métodos têm nomes que descrevem a operação e retornam informações úteis quando há uma decisão.

## Compilar e executar

A declaração `package exemplo_refatoracao` define o nome do pacote. A partir da raiz do repositório, compile os arquivos para uma pasta de saída:

```bash
javac -d out Refatoracao/*.java
java -cp out exemplo_refatoracao.Main
```

A saída inclui o cadastro, a mensalidade após o reajuste e o resultado do ajuste para o mínimo.

## Exercícios

1. Crie outro aluno e aplique um reajuste de 5%.
2. Tente criar uma mensalidade negativa e observe a exceção.
3. Tente aplicar um percentual negativo.
4. Ajuste uma mensalidade que já esteja acima do mínimo e observe que ela não muda.
5. Adicione um método para desativar o aluno. A mensalidade deve continuar sendo responsabilidade de `Mensalidade`?
6. Discuta por que aplicações financeiras reais normalmente usam `BigDecimal` em vez de `double` para valores monetários.

## Observação sobre valores monetários

Este exemplo mantém `double` para reduzir a quantidade de conceitos introduzidos na atividade. Números de ponto flutuante podem produzir pequenas diferenças de arredondamento; em um sistema financeiro real, prefira `BigDecimal` e defina explicitamente a regra de arredondamento.

## Perguntas para discussão

- Quais mudanças podem levar `Aluno` a ser alterada? E quais podem levar `Mensalidade` a ser alterada?
- Por que o construtor de `Aluno` cria uma `Mensalidade`?
- Qual é a vantagem de `Aluno` delegar o cálculo para `Mensalidade`?
- Em quais situações poderia fazer sentido usar uma interface ou uma estratégia para diferentes regras de cobrança?

## Resumo

A refatoração separou o cadastro acadêmico das regras de cobrança. `Aluno` compõe uma `Mensalidade` e delega a ela as operações financeiras. Essa divisão torna mais fácil localizar, explicar e alterar cada regra.
