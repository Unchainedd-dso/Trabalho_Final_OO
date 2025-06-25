public class Professor extends Pessoa{
    private Double salario;

    public Professor(String matricula, String nome, Integer idade, Double peso, Boolean ativo, Double salario) {
        super(matricula, nome, idade, peso, ativo);
        this.salario=salario;
    }

    public Double getSalario() {
        return salario;
    }   
    
}