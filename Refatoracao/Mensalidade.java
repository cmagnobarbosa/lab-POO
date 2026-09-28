package Refatoracao;

/** Guarda o valor da mensalidade e aplica as regras de reajuste. */
public class Mensalidade {
    private double valor;

    public Mensalidade(double valor) {
        validarValor(valor, "A mensalidade");
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void aplicarReajustePercentual(double percentual) {
        if (Double.isNaN(percentual) || Double.isInfinite(percentual) || percentual < 0) {
            throw new IllegalArgumentException("O percentual não pode ser negativo ou inválido.");
        }
        valor += valor * percentual / 100;
    }

    /** Define um piso; valores já acima dele não são alterados. */
    public boolean ajustarParaMinimo(double valorMinimo) {
        validarValor(valorMinimo, "O valor mínimo");
        if (valor < valorMinimo) {
            valor = valorMinimo;
            return true;
        }
        return false;
    }

    private static void validarValor(double valor, String campo) {
        if (Double.isNaN(valor) || Double.isInfinite(valor) || valor < 0) {
            throw new IllegalArgumentException(campo + " deve ser um número válido e não negativo.");
        }
    }
}
