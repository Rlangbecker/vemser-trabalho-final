import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UsuarioManipulacao {

    public List<Usuario> usuarios = new ArrayList<>();

    public boolean logar() {
        Scanner r = new Scanner(System.in);
        System.out.println("Email:");
        String email = r.nextLine();

        System.out.println("Senha:");
        String senha = r.nextLine();



//        Optional<Usuario> var2 = usuarios.stream()
//                .filter(usuario -> usuario.getEmail().toLowerCase().contains(email))
//                .findFirst();
//
            for (Usuario user : usuarios) {
                if (user.getEmail().toLowerCase().equalsIgnoreCase(email) && user.getSenha().toLowerCase().equals(senha)) {
                    user.setLogado(true);
                    return true;
                }
            }
            System.out.println("Email ou senha inválido, tente novamente!");
            return false;
        }


    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void adicionarUsuario(Usuario usuario){
        if(usuarios==null){
            usuarios=new ArrayList<>();
        }
        usuarios.add(usuario);
        usuario.setId(usuarios.size());
    }
    public void listarUsuarios(){
        for (int i = 1; i <usuarios.size() ; i++) {
            System.out.println("ID -" + i + " | " + usuarios);
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

    @Override
    public String toString() {
        return "UsuarioManipulacao{" +
                "usuarios=" + usuarios +
                '}';
    }
}

