package trabalho.veiculos;

public abstract class Veiculo {
    protected int limiteKG;     // Em Kilogramas
    protected int limiteVolume; // Em centímetros cúbicos

    public Veiculo(int limiteKG, int limiteVolume){
        this.limiteKG = limiteKG;
        this.limiteVolume = limiteVolume;
    }

    // Cada veículo aplicará um ajuste diferente
    public abstract double tarifaAjuste();
}
