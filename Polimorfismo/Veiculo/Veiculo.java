package Polimorfismo.Veiculo;

public abstract class Veiculo {
    private String modelo;
    private String placa;

    public Veiculo(String modelo, String placa){
        this.modelo = modelo;
        this.placa = placa;
    }

    // Comportamento que deverá ser especializado;
    public abstract double calcularCusto(double distancia);

    public String toString(){
        return "O modelo é: " + this.modelo + ", Placa: " + this.placa;
    }
}
