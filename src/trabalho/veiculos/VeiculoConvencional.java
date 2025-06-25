package trabalho.veiculos;

public class VeiculoConvencional extends Veiculo {
    private String placa;

    public VeiculoConvencional(int limiteKG, int limiteVolume, String placa) {
        super(limiteKG, limiteVolume);
        this.placa = placa;
    }

    @Override
    public double tarifaAjuste() {
        return 1.0; // Veículo convencional não tem ajuste de tarifa
    }

    public String getPlaca() {
        return placa;
    }
}
