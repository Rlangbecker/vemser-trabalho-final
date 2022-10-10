import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Usuario userParaLogar;

        Usuario usuario = new Usuario();
        UsuarioManipulacao usuarioManipulacao = new UsuarioManipulacao();

        Comentario comentario = new Comentario();
        comentario.setComentario("Belo perfil!");
        ComentarioManipulacao<Comentario> comentarioManipulacao = new ComentarioManipulacao<>();
        comentarioManipulacao.adicionarComentario(comentario);

        List<Comentario> listaComentario = comentarioManipulacao.listarComentario();

        Desafios desafios = new Desafios();
        desafios.setPergunta("Flamengo é o maior do rio?");
        desafios.setResposta(Resposta.VERDADEIRO);

        DesafiosManipulacao<Desafios> desafiosManipulacao = new DesafiosManipulacao<>();
        List<Desafios> listarDesafio = desafiosManipulacao.listarDesafios();
        desafiosManipulacao.adicionarDesafio(desafios);

        Hobbies hobbies = new Hobbies();
        hobbies.setHobbies(TipoHobbies.JOGOS);
        hobbies.setDescricao("FIFA 22");
        HobbiesManipulacao hobbiesManipulacao = new HobbiesManipulacao();
        hobbiesManipulacao.adicionarHobbies(hobbies);
        List<Hobbies> hobbiesList = hobbiesManipulacao.listarHobbies();



        Usuario julia = new Usuario("Julia", 0, "julia@gmail.com", "993764282", "123456",
                "06082001", "Bi", "Feminino", false, listarDesafio, listaComentario, null, hobbiesList);
        Usuario usuarioLogado = new Usuario("Kaio", 1, "kaio@dbc.com", "8979541131",
                "dbcmelhorempresa", "140302", "Hetero", "Masculino",
                true, listarDesafio, listaComentario, null, hobbiesList);

        usuarioManipulacao.adicionarUsuario(julia);
        usuarioManipulacao.adicionarUsuario(usuarioLogado);


        int escolha = -1;
        while (escolha != 0) {
            try {
                System.out.println("+---------------------------------+\n" +
                        "|             Geeker              |\n" +
                        "+---------------------------------+\n" +
                        "|          [1] Login              |" +
                        "\n|          [2] Cadastrar          |" +
                        "\n|          [0] Sair               |\n" +
                        "+---------------------------------+\n");
                escolha = input.nextInt();
                input.nextLine();
                switch (escolha) {
                    case 1 -> {
                        System.out.println("+---------------------------------+\n" +
                                "|             LOGIN               |\n" +
                                "+---------------------------------+");
                        System.out.println("Email:");
                        String email = input.nextLine();
                        System.out.println("Senha:");
                        String senha = input.nextLine();
                        System.out.println(" \n Carregando ...");
                        if (usuarioManipulacao.logar(email, senha)) {
                            userParaLogar = usuarioManipulacao.receberUsuario(email, senha);
                            while (userParaLogar.isLogado()) {
                                mostrarMenuLogado();

                                int opcao = input.nextInt();
                                input.nextLine();
                                switch (opcao) {
                                    case 1 -> {
                                        System.out.println("Matchs:");
                                        System.out.println(userParaLogar.getMatchs());
                                    }
                                    case 2 -> {
                                        usuarioManipulacao.editarUsuario();
                                    }
                                    case 3 -> {
                                        usuarioManipulacao.excluirUsuario();
                                    }
                                    case 4 -> {
                                        usuarioManipulacao.listarUsuarios();
                                        escolha = input.nextInt();
                                        usuarioManipulacao.resolverDesafio(escolha, userParaLogar);
                                    }
                                    case 5 -> {
                                        usuarioManipulacao.comentarPerfil(escolha);
                                    }
                                    case 0 -> {
                                        usuarioManipulacao.deslogar(userParaLogar);
                                    }
                                    default -> {
                                        System.out.println("Ops!" +
                                                "\nOpção inválida, tente novamente");
                                    }
                                }
                            }
                        }
                    }
                    case 2 -> {
                        usuarioManipulacao.cadastrarUsuario();
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

    public static void mostrarMenuLogado() {
        System.out.println("+---------------------------------+\n" +
                "|             Geeker              |\n" +
                "+---------------------------------+" +
                "\n|         [1] Listar Matchs       |" +
                "\n|         [2] Editar Perfil       |" +
                "\n|         [3] Excluir contato     |" +
                "\n|         [4] Dar match           |" +
                "\n|         [5] Comentar            |" +
                "\n|         [0] Deslogar            |\n" +
                "+---------------------------------+\n");
    }


}