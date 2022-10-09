import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsuarioManipulacaoTest {

    UsuarioManipulacao usuarioManipulacao = new UsuarioManipulacao();

    @BeforeEach
    public void init() {usuarioManipulacao = new UsuarioManipulacao();}

    @Test
    public void testAdicionarUsuario() {
        Usuario user = new Usuario();


        usuarioManipulacao.adicionarUsuario(new Usuario(0, "email1", "telefone1", "senha1", "genero1", "f"));


        assertEquals(usuarioManipulacao.getUsuarios().size(), 1);
    }

    @Test
//    public void testAtualizarUsuario() {
//        Usuario usuario = new Usuario(0, "email1", "telefone1", "senha1", "genero1", "f");
//        Usuario user = new Usuario();
//
//
//        usuarioManipulacao.atualizarUsuario(user.getId(), usuario);
//
//
//        assertEquals(usuarioManipulacao.getUsuarios().size(), 0);
//    }
}

