import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsuarioManipulacao usuarioManipulacao = new UsuarioManipulacao();
        Scanner input = new Scanner(System.in);




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
