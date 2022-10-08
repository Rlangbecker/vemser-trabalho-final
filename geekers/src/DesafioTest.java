import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DesafioTest {

    Desafios desafios = new Desafios();
    DesafiosManipulacao<Desafios> desafiosManipulacao = new DesafiosManipulacao<>();

    @Test
    public void deveTestarAdicionarDesafioComSucesso(){
        desafios.setResposta(Resposta.VERDADEIRO);
        desafios.setPergunta("Pelé é melhor que maradona");


        boolean retorno = desafiosManipulacao.adicionarDesafio(desafios);

        Assertions.assertTrue(retorno);
    }

    @Test
    public void deveTestarVerificarRespostaComSucesso(){
        desafios.setResposta(Resposta.VERDADEIRO);
        desafios.setPergunta("Pelé é melhor que maradona");
        Resposta respostaUsuario = Resposta.VERDADEIRO;

        boolean retorno = desafios.verificarResposta(respostaUsuario);

        Assertions.assertTrue(retorno);
    }

}
