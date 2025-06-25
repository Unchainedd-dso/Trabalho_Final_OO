package trabalho.veiculos;

import java.util.LinkedList;

public class CadastroVeiculos {
    LinkedList<Veiculo> listaDeVeiculos;

    public CadastroVeiculos() {
        listaDeVeiculos = new LinkedList<>();        
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
