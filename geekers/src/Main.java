import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        UsuarioManipulacao usuarioManipulacao = new UsuarioManipulacao();
        Scanner input = new Scanner(System.in);
        DesafiosManipulacao<Desafios> desafiosManipulacao = new DesafiosManipulacao<>();
        List<Desafios> listarDesafio = desafiosManipulacao.listarDesafios();
        Desafios desafios = new Desafios();
        ComentarioManipulacao<Comentario> comentarioManipulacao = new ComentarioManipulacao<>();
        List<Comentario> listaComentario = comentarioManipulacao.listarComentario();
        Comentario comentario = new Comentario();
        desafios.setPergunta("Flamengo é o maior do rio?");
        desafios.setResposta(Resposta.VERDADEIRO);
        desafiosManipulacao.adicionarDesafio(desafios);
        comentario.setComentario("Belo perfil!");
        comentarioManipulacao.adicionarComentario(comentario);
        Hobbies hobbies = new Hobbies();
        HobbiesManipulacao hobbiesManipulacao = new HobbiesManipulacao();
        List<Hobbies> hobbiesList = hobbiesManipulacao.listarHobbies();
        hobbies.setHobbies(TipoHobbies.JOGOS);
        hobbies.setDescricao("FIFA 22");
        hobbiesManipulacao.adicionarHobbies(hobbies);


        Usuario usuario1 = new Usuario("nome", 0, "email", "telefone", "senha",
                null, "genero", "m", false, listarDesafio, listaComentario, null, hobbiesList);
        Usuario usuarioLogado = new Usuario("Kaio", 1, "kaio@teste.com", "8979541131",
                "senha", "140302", "m", "m",
                true, listarDesafio, listaComentario, null, hobbiesList);

        usuarioManipulacao.adicionarUsuario(usuario1);
        usuarioManipulacao.adicionarUsuario(usuarioLogado);

        int escolha = -1;
        while (escolha != 0) {
            try {
                System.out.println("+---------------------------------+\n"+
                                   "+             Geeker              +\n"+
                                   "+---------------------------------+");
                System.out.println(
                        "|         [1] Cadastrar           |" +
                        "\n|         [2] Listar Contatos     |" +
                        "\n|         [3] Alterar Contato     |" +
                        "\n|         [4] Excluir contato     |" +
                        "\n|         [5] Dar match           |" +
                        "\n|         [6] Comentar            |" +
                        "\n|         [0] Sair                |\n"+
                        "+---------------------------------+\n"
                );

                escolha = input.nextInt();
                input.nextLine();
                switch (escolha){
                    case 1 -> {
                        usuarioManipulacao.cadastrarUsuario();
                    }
                    case 2 -> {
                        usuarioManipulacao.listarUsuarios();
                    }
                    case 3 -> {
                        usuarioManipulacao.editarUsuario();
                    }
                    case 4 -> {
                        usuarioManipulacao.excluirUsuario();
                    }
                    case 5 -> {
                        usuarioManipulacao.listarUsuarios();
                        escolha = input.nextInt();
                        usuarioManipulacao.resolverDesafio(escolha, usuarioLogado);
                    }
                    case 6 -> {
                        usuarioManipulacao.comentarPerfil(escolha);

                    }
                    case 0 -> {
                        System.out.println("Programa encerrado." +
                                "\nAté logo.");
                    }
                    default -> {
                        System.out.println("Ops!" +
                                "\nOpção inválida, tente novamente");
                    }
                }
            } catch (InputMismatchException ex) {
//                ex.printStackTrace();
                System.err.println("Opção inválido, tente novamente.");
            }

        }



        input.close();

    }

}
