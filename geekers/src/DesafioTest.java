import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DesafioTest {
    private Desafios desafios = new Desafios();
    private DesafiosManipulacao<Desafios> desafiosManipulacao = new DesafiosManipulacao<>();

    @BeforeEach
    public void init() {
        desafios = new Desafios();
    }
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
