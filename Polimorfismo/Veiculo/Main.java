package Polimorfismo.Veiculo;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        List<Veiculo> veiculos = new ArrayList<>();

        Veiculo carro = new Carro("Onix", "BTX-980");
        Veiculo moto = new Moto("Titan", "MNZ-870");

        veiculos.add(carro);
        veiculos.add(moto);

        for(Veiculo veiculo: veiculos){
            System.out.println(veiculo);
            System.out.println("O custo da corrida é:" + veiculo.calcularCusto(60));
        }
    }
    
}
