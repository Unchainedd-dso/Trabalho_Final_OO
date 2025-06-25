package trabalho.veiculos;

public class Bicicleta extends Veiculo {

    public Bicicleta(String nome, int limiteKG, int limiteVolume) {
        super(nome, limiteKG, limiteVolume);
    }

    @Override
    public double tarifaAjuste() {
        return 0.90; // Bicicleta tem um ajuste de tarifa de 0.90 (pagam 10% a menos)
    }
}