import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UsuarioManipulacao {

    Scanner input = new Scanner(System.in);


    private List<Usuario> usuarios = new ArrayList<>();
    private List<Desafios> desafios = new ArrayList<>();
    private List<Usuario> matchs = new ArrayList<>();

    public void adicionarUsuario(Usuario usuario) {
        if (usuarios == null) {
            usuarios = new ArrayList<>();
        }
        usuarios.add(usuario);
    }

    public void listarUsuarios() {
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println("ID - " + i + " | " + usuarios.get(i).getNome());
        }
    }

    public void atualizarUsuario(int id, Usuario usuario) {
        Usuario editarUsuario = usuarios.get(id);
        editarUsuario.setNome(usuario.getNome());
        editarUsuario.setTelefone(usuario.getTelefone());
    }

    public void deletarUsuario(int id) {
        this.usuarios.remove(id);
    }

    public void cadastrarUsuario() {
        try {
            Usuario usuario = new Usuario();
            System.out.println("CADASTRO DE USUÁRIO" +
                    "\nPREENCHA OS CAMPOS..." +
                    "\nNome: ");
            usuario.setNome(input.nextLine());
            System.out.println("E-mail: ");
            usuario.setEmail(input.nextLine());
            System.out.println("Telefone: ");
            usuario.setTelefone(input.nextLine());
            System.out.println("Senha: ");
            usuario.setSenha(input.nextLine());
            System.out.println("Data de narcimento [dd/MM/yyyy]: ");
            String nascimento = input.nextLine();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            usuario.setDataNascimento(LocalDate.parse(nascimento, dtf));
            System.out.println("Genero: ");
            usuario.setGenero(input.nextLine());
            System.out.println("Sexo: ");
            usuario.setSexo(input.nextLine());

            usuario.setId(usuarios.size()+1);
            adicionarUsuario(usuario);
        } catch (DateTimeException ex) {
            System.out.println("Formato de data inválida, tente novamente.");
        }

    }

    public void editarUsuario() {
        try {
            System.out.println("Digite o ID do usuário para realizar alterações: ");
            listarUsuarios();
            int id = input.nextInt();
            input.nextLine();
            Usuario usuarioAtualizado = new Usuario();
            System.out.println("Digite o novo nome do usuario: ");
            usuarioAtualizado.setNome(input.nextLine());
            System.out.println("Digite o novo telefone do usuário: ");
            usuarioAtualizado.setId(input.nextInt());
            input.nextLine();

            atualizarUsuario(id, usuarioAtualizado);
        } catch (InputMismatchException ex) {
            ex.printStackTrace();
            System.err.println("Caracter inválido, tente novamente para editar o usuário.");


        }

    }

    public void excluirUsuario() {
        try {
            System.out.println("Qual pessoa você deseja excluir?");
            listarUsuarios();
            int id = input.nextInt();
            input.nextLine();
            System.out.print("Usuário removido: ");
            System.out.println(usuarios.get(id).getNome());
            deletarUsuario(id);
        } catch (InputMismatchException ex) {
            System.out.println("Caracter inválido, tente novamente para remover um usuário.");
        }
    }
}
