import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UsuarioManipulacao {

    Scanner input = new Scanner(System.in);
    private Usuario usuario;
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Usuario> matchs = new ArrayList<>();
    DesafiosManipulacao<Desafios> desafiosManipulacao = new DesafiosManipulacao<>();
    List<Desafios> listarDesafio = desafiosManipulacao.listarDesafios();
    private Desafios desafio;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void adicionarUsuario(Usuario usuario) {
        if (usuarios == null) {
            usuarios = new ArrayList<>();
        }
        usuarios.add(usuario);
    }

    public void listarUsuarios() {
        for (int i = 0; i < usuarios.size(); i++) {
            usuarios.get(i).imprimir();
            System.out.println("\n");
        }
    }

    public void atualizarUsuario(int id, Usuario usuario) {
        Usuario editarUsuario = usuarios.get(id);
        editarUsuario.setNome(usuario.getNome());
        editarUsuario.setTelefone(usuario.getTelefone());
        editarUsuario.setEmail(usuario.getEmail());
        editarUsuario.setSenha(usuario.getSenha());
        editarUsuario.setDataNascimento(usuario.getDataNascimento());
        editarUsuario.setGenero(usuario.getGenero());
        editarUsuario.setSexo(usuario.getSexo());
        editarUsuario.setDesafios(usuario.getDesafios());

    }

    public void deletarUsuario(int id) {
        this.usuarios.remove(id);
    }

    public boolean cadastrarUsuario() {
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
            usuario.setDataNascimento(nascimento);
            System.out.println("Genero: ");
            usuario.setGenero(input.nextLine());
            System.out.println("Sexo: ");
            usuario.setSexo(input.nextLine());
            System.out.println("Desafio");
            System.out.println("Faça sua pergunta: ");
            String pergunta = input.nextLine();
            System.out.println("Escolha sua resposta: 1- Verdadeiro 2- Falso");
            int escolha = input.nextInt();
            if (escolha == 1){
               desafiosManipulacao.adicionarDesafio(new Desafios(pergunta, Resposta.VERDADEIRO));
            }
            else if (escolha == 2){
                desafiosManipulacao.adicionarDesafio(new Desafios(pergunta, Resposta.FALSO));
            }
            usuario.setDesafios(listarDesafio);
            usuario.setComentarios(null);
            usuario.setId(usuarios.size());
            adicionarUsuario(usuario);
            return true;
        } catch (DateTimeException ex) {
            System.out.println("Formato de data inválida, tente novamente.");
            return false;
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
            usuarioAtualizado.setTelefone(input.nextLine());
            System.out.println("E-mail: ");
            usuarioAtualizado.setEmail(input.nextLine());
            System.out.println("Senha: ");
            usuarioAtualizado.setSenha(input.nextLine());
            System.out.println("Data de narcimento [dd/MM/yyyy]: ");
            String nascimento = input.nextLine();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            usuarioAtualizado.setDataNascimento(nascimento);
            System.out.println("Genero: ");
            usuarioAtualizado.setGenero(input.nextLine());
            System.out.println("Sexo: ");
            usuarioAtualizado.setSexo(input.nextLine());
            System.out.println("Desafio");
            System.out.println("Faça sua pergunta: ");
            String pergunta = input.nextLine();
            System.out.println("Escolha sua resposta: 1- Verdadeiro 2- Falso");
            int escolha = input.nextInt();
            if (escolha == 1){
                desafiosManipulacao.adicionarDesafio(new Desafios(pergunta, Resposta.VERDADEIRO));
            }
            else if (escolha == 2){
                desafiosManipulacao.adicionarDesafio(new Desafios(pergunta, Resposta.FALSO));
            }
            usuarioAtualizado.setDesafios(listarDesafio);
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
