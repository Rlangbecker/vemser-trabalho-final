import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsuarioManipulacaoTest {

    private UsuarioManipulacao usuarioManipulacao = new UsuarioManipulacao();

    @BeforeEach
    public void init() {
        usuarioManipulacao = new UsuarioManipulacao();
    }

    @Test
    public void testAdicionarUsuario() {
        Usuario user = new Usuario();


        usuarioManipulacao.adicionarUsuario(new Usuario("Felipe", 0));


        assertEquals(usuarioManipulacao.getUsuarios().size(), 1);
    }

    public void testAtualizarUsuario() {
        Usuario usuario = new Usuario("Felipe", 0);
        Usuario user = new Usuario();


        usuarioManipulacao.atualizarUsuario(user.getId(), usuario);


        assertEquals(usuarioManipulacao.getUsuarios().size(), 0);
    }
}

