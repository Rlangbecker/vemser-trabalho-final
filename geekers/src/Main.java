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
        desafios.setResposta(Resposta.FALSO);
        desafiosManipulacao.adicionarDesafio(desafios);
        comentario.setComentario("Belo perfil!");
        comentarioManipulacao.adicionarComentario(comentario);
        Hobbies hobbies = new Hobbies();
        HobbiesManipulacao hobbiesManipulacao = new HobbiesManipulacao();
        List<Hobbies> hobbiesList = hobbiesManipulacao.listarHobbies();
        hobbies.setHobbies(TipoHobbies.JOGOS);
        hobbies.setDescricao("FIFA 22");
        hobbiesManipulacao.adicionarHobbies(hobbies);


        Usuario usuario1 = new Usuario("Leoncio", 0, "Leoneymar@gmail.com", "9987461432", "1234",
                "15022000", "m", "m", false, listarDesafio, listaComentario, null, hobbiesList);
        Usuario usuario2 = new Usuario("Cristiano", 2, "Oloco@hotmail.br", "3246189544", "42134123",
                null, "m", "m", false, listarDesafio, listaComentario, null, hobbiesList);
        Usuario usuarioLogado = new Usuario("Kaio", 1, "kaio@teste.com", "8979541131",
                "senha", "140302", "m", "m",
                true, listarDesafio, listaComentario, null, hobbiesList);

        usuarioManipulacao.adicionarUsuario(usuario1);
        usuarioManipulacao.adicionarUsuario(usuario2);
        usuarioManipulacao.adicionarUsuario(usuarioLogado);

        int escolha = 100;
        while (escolha != 0) {
            try {
                System.out.println("Bem vindo ao Tinder Geeker\n");
                System.out.println("Para cadastrar, digite 1: " +
                        "\nPara listar contato(s), digite 2: " +
                        "\nPara alterar contato, digite 3: " +
                        "\nPara excluir contato, digite 4" +
                        "\nEscolha um usuario para dar match, digite 5" +
                        "\nComente no perfil de um usuario, digite 6" +
                        "\nPara sair, digite 0"
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
                        System.out.println("Escolha um usuario para dar match: ");
                        escolha = input.nextInt();
                        input.nextLine();
                        usuarioManipulacao.resolverDesafio(escolha, usuarioLogado);
                        escolha = 100;
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
