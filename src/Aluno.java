public class Aluno extends Pessoa{
    private String curso;

    public Aluno(String matricula, String nome, Integer idade, Double peso, Boolean ativo, String curso) {
        super(matricula, nome, idade, peso, ativo);
        this.curso=curso;
    }

    public String getCurso() {
        return curso;
    }
    
}