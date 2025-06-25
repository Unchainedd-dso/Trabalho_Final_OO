package trabalho.viagem;

import java.util.LinkedList;

public class CadastroViagens {
    private LinkedList<Viagem> viagens;

    public CadastroViagens() {
        this.viagens = new LinkedList<>();
    }

    public void adicionarViagem(Viagem viagem) {
        this.viagens.add(viagem);
    }

    public Iterable<Viagem> getViagens() {
        return viagens;
    }

    public int nViagens(){
        return viagens.size();
    }
}
