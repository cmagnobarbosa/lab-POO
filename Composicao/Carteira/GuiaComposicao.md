# Guia de Composição de Carteira

Este guia explica como utilizar a composição de objetos para representar uma carteira de investimentos. A composição permite que uma classe contenha objetos de outras classes, promovendo um design mais modular e reutilizável.

## Exemplo de Implementação

Suponha que temos uma classe `Investimento` e uma classe `Carteira`. A classe `Carteira` contém uma lista de objetos `Investimento`, demonstrando a composição.

```java
import java.util.ArrayList;
import java.util.List;

class Investimento {
    private String nome;
    private double valor;

    public Investimento(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }
}

class Carteira {
    private List<Investimento> investimentos;

    public Carteira() {
        this.investimentos = new ArrayList<>();
    }

    public void adicionarInvestimento(Investimento investimento) {
        investimentos.add(investimento);
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Investimento investimento : investimentos) {
            total += investimento.getValor();
        }
        return total;
    }
}
```