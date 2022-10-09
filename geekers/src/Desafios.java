import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Desafios implements VerificacaoResposta, Impressao{

    private String pergunta;
    private Resposta resposta;

    public Desafios(){

    }

    public Desafios(String pergunta, Resposta resposta) {
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }

    public boolean verificarResposta(Resposta opcao) {
        if (opcao == getResposta()){
            System.out.println("Resposta Correta!");
            return true;
        }
        else {
            System.out.println("Resposta Errada!");
            return false;
        }
    }

    @Override
    public String toString() {
        return "pergunta='" + pergunta + '\'';
    }

    public void imprimir(){
        System.out.println("Pergunta: " + pergunta +
                "\nResposta: " + resposta);
    }
}

