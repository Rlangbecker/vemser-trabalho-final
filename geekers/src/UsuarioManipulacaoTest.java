import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class UsuarioManipulacaoTest {

    UsuarioManipulacao usuarioManipulacao = new UsuarioManipulacao();

    @BeforeEach
    public void init() {usuarioManipulacao = new UsuarioManipulacao();}

    @Test
    public void testAdicionarUsuario() {
        Usuario user = new Usuario();


        usuarioManipulacao.adicionarUsuario(new Usuario("Jorge"));


        Assertions.assertEquals(usuarioManipulacao.getUsuarios().size(), 1);
    }

    @Test
    public void testAtualizarUsuario() {
        Usuario usuario = new Usuario("Jorge");
        usuarioManipulacao.adicionarUsuario(usuario);

        boolean retorno = usuarioManipulacao.atualizarUsuario(0, usuario);

        Assertions.assertTrue(retorno);
    }
}

