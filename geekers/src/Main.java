import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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

        Usuario usuario1 = new Usuario("nome", 0, "email", "telefone", "senha",
                null, "genero", "m", false, listarDesafio, listaComentario, null);

        usuarioManipulacao.adicionarUsuario(usuario1);

        int escolha = -1;
        while (escolha != 0) {
            try {
                System.out.println("Para cadastrar, digite 1: " +
                        "\nPara listar contato(s), digite 2: " +
                        "\nPara alterar contato, digite 3: " +
                        "\nPara excluir contato, digite 4" +
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
