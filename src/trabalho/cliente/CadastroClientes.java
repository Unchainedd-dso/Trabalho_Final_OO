package trabalho.cliente;

import java.util.HashSet;

public class CadastroClientes {
    HashSet<Cliente> listaDeClientes;

    public CadastroClientes() {
        listaDeClientes = new HashSet<>();
    }

    public Cliente buscaClientePorTelefone(String telefone) {
        for (Cliente cliente : listaDeClientes) {
            if (cliente.getTelefone().equals(telefone)) {
                return cliente;
            }
        }
        return null; // Retorna null se não encontrar o cliente
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
