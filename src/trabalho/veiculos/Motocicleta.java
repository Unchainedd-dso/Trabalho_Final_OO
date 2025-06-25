package trabalho.veiculos;

public class Motocicleta extends Veiculo {
    private String placa;

    public Motocicleta(String nome, int limiteKG, int limiteVolume, String placa) {
        super(nome, limiteKG, limiteVolume);
        this.placa = placa;
    }

    @Override
    public double tarifaAjuste() {
        return 0.95; // Motocicleta tem um ajuste de tarifa de 0.95 (pagam 5% a menos)
    }
    
    public String getPlaca() {
        return placa;
    }
}
