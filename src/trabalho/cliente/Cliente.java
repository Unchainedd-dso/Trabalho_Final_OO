package trabalho.cliente;

public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;

    // Construtor completo
    // Implementar "contrutor" minimo na hora de receber os dados
    public Cliente(String nome, String telefone, String cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) obj;
        return telefone.equals(cliente.telefone);
    }

    @Override
    public int hashCode() {
        return telefone.hashCode();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }
}
