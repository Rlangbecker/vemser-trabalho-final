import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComentarioTest {
    private Comentario comentario = new Comentario();
    private ComentarioManipulacao<Comentario> comentarioManipulacao = new ComentarioManipulacao<>();
    @Test
    public void deveTestarAdicionarComentarioComSucesso(){
        comentario.setComentario("Gostei do perfil");

        boolean retorno = comentarioManipulacao.adicionarComentario(comentario);

        Assertions.assertTrue(retorno);
    }

    @Test
    public void deveTestarRemoverComentarioSemSucesso(){
        comentario.setComentario(null);

        boolean retorno = comentarioManipulacao.adicionarComentario(comentario);

        Assertions.assertTrue(retorno);
    }


}
