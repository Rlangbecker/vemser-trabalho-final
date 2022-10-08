import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Testes para o desafio
        DesafiosManipulacao<Desafios> desafiosManipulacao = new DesafiosManipulacao<>();
        List<Desafios> listarDesafio = desafiosManipulacao.listarDesafios();
        Desafios desafios = new Desafios();
        Usuario usuario = new Usuario();


        desafios.setPergunta("Goku é mais forte que naruto?");
        desafios.setResposta(Resposta.VERDADEIRO);
        desafiosManipulacao.adicionarDesafio(desafios);

        usuario.setDesafios(listarDesafio);
        System.out.println(usuario.getDesafios());

        desafios.verificarResposta(Resposta.VERDADEIRO);
    }
}
