public class Pessoa {

    private String matrícula, nome;
    private Integer idade;
    private Double peso;
    private Boolean ativo;

    public Pessoa(String matricula, String nome, Integer idade, Double peso, Boolean ativo) {
        this.matrícula=matricula;
        this.nome=nome;
        this.idade=idade;
        this.peso=peso;
        this.ativo=ativo;
    }

    
    public String getMatricula() {
        return matrícula;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public Double getPeso() {
        return peso;
    }

    public Boolean getAtivo() {
        return ativo;
    }    
    
}
