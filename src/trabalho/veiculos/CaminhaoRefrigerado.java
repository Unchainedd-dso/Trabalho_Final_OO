package trabalho.veiculos;

public class CaminhaoRefrigerado extends Veiculo {
    private String placa;

    public CaminhaoRefrigerado(String nome, int limiteKG, int limiteVolume, String placa) {
        super(nome, limiteKG, limiteVolume);
        this.placa = placa;
    }

    @Override
    public double tarifaAjuste() {
        return 1.3; // Caminhão refrigerado tem um ajuste de tarifa de 1.3 (pagam 30% a mais)
    }

    public String getPlaca() {
        return placa;
    }
    
}
