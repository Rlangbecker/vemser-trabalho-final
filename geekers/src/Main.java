import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsuarioManipulacao usuarioManipulacao = new UsuarioManipulacao();
        Scanner input = new Scanner(System.in);

        Usuario usuario = new Usuario("nome", 0, "email", "telefone", "senha", "genero", "m");
        Usuario usuario1 = new Usuario("nome1", 0, "email1", "telefone1", "senha1", "genero1", "f");
        Usuario usuario2 = new Usuario("nome2", 0, "email2", "telefone2", "senha2", "genero2", "f");
        Usuario usuario3 = new Usuario("nome3", 0, "email3", "telefone3", "senha3", "genero3", "m");

        usuarioManipulacao.adicionarUsuario(usuario);
        usuarioManipulacao.adicionarUsuario(usuario1);
        usuarioManipulacao.adicionarUsuario(usuario2);
        usuarioManipulacao.adicionarUsuario(usuario3);


//        usuarioManipulacao.cadastrarUsuario();
//        usuarioManipulacao.listarUsuarios();
//
//        usuarioManipulacao.cadastrarUsuario();
//        usuarioManipulacao.listarUsuarios();
//
//        usuarioManipulacao.cadastrarUsuario();
//        usuarioManipulacao.listarUsuarios();


        Integer escolha = 100;
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
                        break;
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
