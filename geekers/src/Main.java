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

        desafiosManipulacao.atualizarDesafio(desafios, "Onepiece é melhor que digimon? ", Resposta.FALSO);
        System.out.println(usuario.getDesafios());

        desafiosManipulacao.deletarDesafio();
        System.out.println(usuario.getDesafios());

        desafios.verificarResposta(Resposta.VERDADEIRO);

        //Testes para comentario
        ComentarioManipulacao<Comentario> comentarioManipulacao = new ComentarioManipulacao<>();
        List<Comentario> listaComentario = comentarioManipulacao.listarComentario();
        Comentario comentario = new Comentario();

        comentario.setComentario("Muito bom perfil!");
        comentario.setUsuario(usuario);
        comentarioManipulacao.adicionarComentario(comentario);

        usuario.setComentarios(listaComentario);
        System.out.println(usuario.getComentarios());

        comentarioManipulacao.atualizarComentario(comentario,"Gostei do hobbie");
        System.out.println(usuario.getComentarios());

        comentarioManipulacao.deletarComentario();
        System.out.println(usuario.getComentarios());

    }
}
