import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Desafios implements VerificacaoResposta{

    String[] perguntas = new String[5];
    int[] respostas = new int[5];

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

}

