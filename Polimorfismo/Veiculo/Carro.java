package Polimorfismo.Veiculo;

public class Carro extends Veiculo{

    public Carro(String modelo, String placa){
        super(modelo, placa);
    }

    @Override
    public double calcularCusto(double distancia) {
        return distancia * 0.30;
    }

    
    
}
