package trabalho.veiculos;

public abstract class Veiculo {
    protected String nome;
    protected int limiteKG;     // Em Kilogramas
    protected int limiteVolume; // Em centímetros cúbicos

    public Veiculo(String nome, int limiteKG, int limiteVolume){
        this.nome = nome;
        this.limiteKG = limiteKG;
        this.limiteVolume = limiteVolume;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Veiculo veiculo = (Veiculo) obj;
        return nome.equals(veiculo.nome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }

    public String getNome() {
        return nome;
    }

    public int getLimiteKG() {
        return limiteKG;
    }

    public int getLimiteVolume() {
        return limiteVolume;
    }

    // Cada veículo aplicará um ajuste diferente
    public abstract double tarifaAjuste();
}
