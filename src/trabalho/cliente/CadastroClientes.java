package trabalho.cliente;

import java.util.LinkedList;

public class CadastroClientes {
    LinkedList<Cliente> listaDeClientes;

    public CadastroClientes() {
        listaDeClientes = new LinkedList<>();
    }

    public void adicionaCliente(Cliente c){
        listaDeClientes.add(c);
    }

    public Iterable<Cliente> clientes(){
        return listaDeClientes;
    }

    public int nClientes(){
        return listaDeClientes.size();
    }
}
