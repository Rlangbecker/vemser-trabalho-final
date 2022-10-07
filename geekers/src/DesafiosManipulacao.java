import java.util.ArrayList;
import java.util.List;

public class DesafiosManipulacao {
    private List<Desafios> desafios = new ArrayList<>();

    public void adicionarDesafio(Desafios desafio) {
        if (desafios == null) {
            desafios = new ArrayList<>();
        }
        desafios.add(desafio);
    }

    //    VERIFICAR METODO ATUALIZAR CONTATO
    public void atualizarDesafio(int id, Desafios desafio) {
        Desafios desafioAtualizar = desafios.get(id);
        desafioAtualizar.setPerguntas(desafioAtualizar.getPerguntas());
        desafioAtualizar.setRespostas(desafioAtualizar.getRespostas());
    }

    public void listarDesafios() {
        for (int i = 0; i < desafios.size(); i++) {
            System.out.println("ID -" + i + " | " + desafios.get(i));
        }
    }

    public void deletarDesafio(int id) {
        this.desafios.remove(id);
    }
}
