import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Desafios implements VerificacaoResposta{

    String[] perguntas = new String[5];
    int[] respostas = new int[5];

    List<Desafios> desafios = new ArrayList<>();


    public String[] getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(String[] perguntas) {
        this.perguntas = perguntas;
    }

    public int[] getRespostas() {
        return respostas;
    }

    public void setRespostas(int[] respostas) {
        this.respostas = respostas;
    }


    public boolean verificarResposta(int opcao) {
        return true;
    }


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

