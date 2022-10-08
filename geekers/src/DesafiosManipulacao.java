import java.util.ArrayList;
import java.util.List;

public class DesafiosManipulacao<T> {
    private List<T> desafios = new ArrayList<>();
    Desafios desafio = new Desafios();

    public void adicionarDesafio(T desafio) {
        if (desafios == null) {
            desafios = new ArrayList<>();
        }
        desafios.add(desafio);
    }

    //    VERIFICAR METODO ATUALIZAR CONTATO
//    public void atualizarDesafio(int id, Desafios desafio) {
//        Desafios desafioAtualizar = desafios.get(id);
//        desafioAtualizar.setPergunta(desafioAtualizar.getPergunta());
//        desafioAtualizar.setResposta(desafioAtualizar.getResposta());
//    }

    public List<T> listarDesafios() {
        return desafios;
    }

    public void deletarDesafio(int id) {
        this.desafios.remove(id);
    }

    @Override
    public String toString() {
        return "DesafiosManipulacao{" +
                "desafio=" + desafios +
                '}';
    }
}
