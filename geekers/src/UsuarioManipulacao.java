import java.util.ArrayList;
import java.util.List;

public class UsuarioManipulacao {

    public List<Usuario> usuarios = new ArrayList<>();

    public void adicionarUsuario(Usuario usuario){
        if(usuarios==null){
            usuarios=new ArrayList<>();
        }
        usuarios.add(usuario);
    }
    public void listarUsuarios(){
        for (int i = 0; i <usuarios.size() ; i++) {
            System.out.println("ID -" + i + " | " + usuarios.get(i));
        }
    }

    public void atualizarUsuario(int id,Usuario usuario){
        Usuario editarUsuario = usuarios.get(id);
        editarUsuario.setNome(usuario.getNome());
        editarUsuario.setNumero(usuario.getNumero());
    }

    public void deletarUsuario(int id){
        this.usuarios.remove(id);
    }

}
