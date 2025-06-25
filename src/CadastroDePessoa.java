import java.util.LinkedList;

public class CadastroDePessoa {

    LinkedList<Pessoa> listaDePessoas;

    public CadastroDePessoa() {
        listaDePessoas = new LinkedList<>();        
    }

    public void adicionaPessoa(Pessoa p){
        listaDePessoas.add(p);
    }

    public Iterable<Pessoa> pessoal(){
        return listaDePessoas;
    }

    public int nPessoas(){
        return listaDePessoas.size();
    }
    
}
