package trabalho.viagem;

import trabalho.cliente.Cliente;
import trabalho.veiculos.Veiculo;

public class Viagem {
    private double peso;
    private double volume;
    private double valorAproximadoCarga;
    private double distancia;
    private boolean urgencia;
    private boolean sensivelAoFrio;
    private Cliente cliente;
    private Veiculo veiculo;
    private Double preco;

    public Viagem(double peso, double volume, double valorAproximadoCarga, double distancia, boolean urgencia, boolean sensivelAoFrio, Cliente cliente, Veiculo veiculo, double preco) {
        this.peso = peso;
        this.volume = volume;
        this.valorAproximadoCarga = valorAproximadoCarga;
        this.distancia = distancia;
        this.urgencia = urgencia;
        this.sensivelAoFrio = sensivelAoFrio;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.preco = preco;
    }

    public static double valorViagem(double distancia, double peso, boolean urgencia, boolean sensivelAoFrio, Veiculo veiculo) {
        int taxaUrgencia = urgencia ? 10 : 0;
        int taxaSensivelAoFrio = sensivelAoFrio ? 10 : 0;
        double valorBase = distancia * 2 + Math.ceil(peso) + taxaUrgencia + taxaSensivelAoFrio;

        double tarifaAjuste = veiculo.tarifaAjuste();
        double valorTotal = valorBase * tarifaAjuste;

        return valorTotal;
    }

    public double getPeso() {
        return peso;
    }
    public double getVolume() {
        return volume;
    }
    public double getValorAproximadoCarga() {
        return valorAproximadoCarga;
    }
    public double getDistancia() {
        return distancia;
    }
    public boolean isUrgencia() {
        return urgencia;
    }
    public boolean isSensivelAoFrio() {
        return sensivelAoFrio;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Double getPreco() {
        return preco;
    }
}
