import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Usuario userParaLogar = new Usuario();

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
                            Usuario usuarioTemp = usuarioManipulacao.receberUsuario(email, senha);
                            UsuarioManipulacao usuarioManipulacaoTemp = new UsuarioManipulacao();
                            while (usuarioTemp.isLogado()) {
                                mostrarMenuLogado();

                                int opcao = input.nextInt();
                                input.nextLine();
                                switch (opcao) {
                                    case 1 -> {
                                        usuarioManipulacaoTemp.listarUsuarios();
                                    }
                                    case 2 -> {
                                        usuarioManipulacaoTemp.editarUsuario();
                                    }
                                    case 3 -> {
                                        usuarioManipulacaoTemp.excluirUsuario();
                                    }
                                    case 4 -> {
                                        usuarioManipulacaoTemp.listarUsuarios();
                                        escolha = input.nextInt();
                                        usuarioManipulacaoTemp.resolverDesafio(escolha, usuarioLogado);
                                    }
                                    case 5 -> {
                                        usuarioManipulacaoTemp.comentarPerfil(escolha);
                                    }
                                    case 0 -> {

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
                "\n|         [1] Listar Contatos     |" +
                "\n|         [2] Alterar Contato     |" +
                "\n|         [3] Excluir contato     |" +
                "\n|         [4] Dar match           |" +
                "\n|         [5] Comentar            |" +
                "\n|         [0] Sair                |\n" +
                "+---------------------------------+\n");
    }


}
