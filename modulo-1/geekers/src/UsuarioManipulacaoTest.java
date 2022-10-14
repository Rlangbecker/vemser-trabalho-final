import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testarClasseUsuario() {
        Usuario usuario = new Usuario("Felipe", 0);

        Assertions.assertAll("usuario",
                () -> assertEquals("Felipe", usuario.getNome()),
                () -> assertEquals(0, usuario.getId())
        );
    }

}