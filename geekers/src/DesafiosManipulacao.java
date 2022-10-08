import java.util.ArrayList;
import java.util.List;

public class DesafiosManipulacao<T> {
    private List<T> desafios = new ArrayList<>();
    Desafios desafio = new Desafios();

    public boolean adicionarDesafio(T desafio) {
        if (desafios == null) {
            desafios = new ArrayList<>();
            return false;
        }
        else {
            desafios.add(desafio);
            return true;
        }

    }

    public void atualizarDesafio(Desafios desafio, String novaPergunta, Resposta novaResposta) {
        Desafios desafioAtualizar = (Desafios) desafios.get(0);
        desafioAtualizar.setPergunta(novaPergunta);
        desafioAtualizar.setResposta(novaResposta);
    }

    public List<T> listarDesafios() {
        return desafios;
    }

    public void deletarDesafio() {
        this.desafios.remove(0);
    }

    @Override
    public String toString() {
        return "DesafiosManipulacao{" +
                "desafio=" + desafios +
                '}';
    }
}
