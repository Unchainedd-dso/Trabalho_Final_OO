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
