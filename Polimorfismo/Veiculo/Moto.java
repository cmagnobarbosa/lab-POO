package Polimorfismo.Veiculo;

public class Moto extends Veiculo{
    
    Moto(String modelo,String placa){
        super(modelo, placa);
    }

    @Override
    public double calcularCusto(double distancia) {
        return distancia * 0.10;
    }
}
