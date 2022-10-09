import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class UsuarioManipulacao {

    Scanner input = new Scanner(System.in);
    private Usuario usuario;
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Usuario> matchs = new ArrayList<>();
    private List<Usuario> usuariosMatchs = new ArrayList<>();
    private HobbiesManipulacao<Hobbies> hobbiesManipulacao = new HobbiesManipulacao<>();
    private List<Hobbies> listarHobbies = hobbiesManipulacao.listarHobbies();
    private DesafiosManipulacao<Desafios> desafiosManipulacao = new DesafiosManipulacao<>();
    private List<Desafios> listarDesafio = desafiosManipulacao.listarDesafios();
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

    public void comentarPerfil(int id){
        ComentarioManipulacao<Comentario> comentarioManipulacao = new ComentarioManipulacao<>();
        List<Comentario> listaComentario = comentarioManipulacao.listarComentario();
        Comentario comentario = new Comentario();
        System.out.println("Informe o usuario que que deseja comentar: ");
        int escolha = input.nextInt();
        input.nextLine();
        usuarios.get(escolha).imprimir();
        System.out.println("Informe o comentario: ");
        String coment = input.nextLine();
        comentario.setComentario(coment);
        comentarioManipulacao.adicionarComentario(comentario);
        System.out.println(listaComentario);
        usuarios.get(escolha).setComentarios(listaComentario);
        usuarios.get(escolha).imprimir();
    }

    public void resolverDesafio(int idParaMatch, Usuario usuarioLogado){
            Usuario usuarioMatch = usuarios.get(idParaMatch);

            if(usuarioMatch == usuarios.get(idParaMatch)) {
                usuarios.get(idParaMatch).imprimir();
                System.out.println("Resolva o desafio: ");
                usuarios.get(idParaMatch).getDesafios();
                System.out.println("1- Verdadeiro 2- Falso");
                int escolha = input.nextInt();
                input.nextLine();
                if(escolha == 1){
                    boolean retorno = usuarioMatch.desafios.get(0).verificarResposta(Resposta.VERDADEIRO);
                    if(retorno){
                        usuariosMatchs.add(usuarioMatch);
                        usuarioLogado.setMatchs(usuariosMatchs);
                        System.out.println("Usuario adicionado na lista de matchs");
                    }
                }
                else if (escolha == 2){
                    if(usuarioMatch.desafios.get(0).verificarResposta(Resposta.FALSO)){
                        usuariosMatchs.add(usuarioMatch);
                        usuarioLogado.setMatchs(usuariosMatchs);
                        System.out.println("Usuario adicionado na lista de matchs");
                    }
                }
                else {
                    System.out.println("Informe somente 1 ou 2");
                }
            }
            else {
                System.out.println("Usuario nao existe");
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
            System.out.println("Escolha seu hobbie: " +
                    "\n1- Jogos" +
                    "\n2 - Series" +
                    "\n3 - Livros" +
                    "\n4 - Filmes" +
                    "\n5 - Bebidas"+
                    "\n6- Outros");
            escolha = input.nextInt();
            input.nextLine();
            switch (escolha){
                case 1 -> {
                    System.out.println("Informe a descricao: ");
                    String descricao = input.nextLine();
                    hobbiesManipulacao.adicionarHobbies(new Hobbies(TipoHobbies.JOGOS, descricao));
                }
                case 2 -> {
                    System.out.println("Informe a descricao: ");
                    String descricao = input.nextLine();
                    hobbiesManipulacao.adicionarHobbies(new Hobbies(TipoHobbies.SERIES, descricao));
                }
                case 3 -> {
                    System.out.println("Informe a descricao: ");
                    String descricao = input.nextLine();
                    hobbiesManipulacao.adicionarHobbies(new Hobbies(TipoHobbies.LIVROS, descricao));
                }case 4 -> {
                    System.out.println("Informe a descricao: ");
                    String descricao = input.nextLine();
                    hobbiesManipulacao.adicionarHobbies(new Hobbies(TipoHobbies.FILMES, descricao));
                }
                case 5 -> {
                    System.out.println("Informe a descricao: ");
                    String descricao = input.nextLine();
                    hobbiesManipulacao.adicionarHobbies(new Hobbies(TipoHobbies.BEBIDAS, descricao));
                }
                case 6 -> {
                    System.out.println("Informe a descricao: ");
                    String descricao = input.nextLine();
                    hobbiesManipulacao.adicionarHobbies(new Hobbies(TipoHobbies.OUTROS, descricao));
                }
                default -> {
                    System.out.println("Opção invalida!");
                }
            }
            usuario.setHobbies(listarHobbies);
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

    @Override
    public String toString() {
        return "UsuarioManipulacao{" +
                "input=" + input +
                ", usuario=" + usuario +
                ", usuarios=" + usuarios +
                ", matchs=" + matchs +
                ", hobbiesManipulacao=" + hobbiesManipulacao +
                ", listarHobbies=" + listarHobbies +
                ", desafiosManipulacao=" + desafiosManipulacao +
                ", listarDesafio=" + listarDesafio +
                ", desafio=" + desafio +
                '}';
    }
}
