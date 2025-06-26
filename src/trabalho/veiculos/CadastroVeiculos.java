package trabalho.veiculos;

import java.util.HashSet;

public class CadastroVeiculos {
    HashSet<Veiculo> listaDeVeiculos;

    public CadastroVeiculos() {
        listaDeVeiculos = new HashSet<>();
    }

    public Veiculo buscaVeiculoPorNome(String nome) {
        for (Veiculo veiculo : listaDeVeiculos) {
            if (veiculo.getNome().equals(nome)) {
                return veiculo;
            }
        }
        return null; // Retorna null se não encontrar o veículo
    }

    public void adicionaVeiculo(Veiculo v){
        listaDeVeiculos.add(v);
    }

    public Iterable<Veiculo> veiculos(){
        return listaDeVeiculos;
    }

    public int nVeiculos(){
        return listaDeVeiculos.size();
    }
}
