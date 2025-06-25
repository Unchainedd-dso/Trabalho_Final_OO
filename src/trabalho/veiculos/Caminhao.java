package trabalho.veiculos;

public class Caminhao extends Veiculo {
    private String placa;

    public Caminhao(String nome, int limiteKG, int limiteVolume, String placa) {
        super(nome, limiteKG, limiteVolume);
        this.placa = placa;
    }

    @Override
    public double tarifaAjuste() {
        return 1.1; // Caminhão tem um ajuste de tarifa de 1.1 (pagam 10% a mais)
    }

    public String getPlaca() {
        return placa;
    }
    
}
