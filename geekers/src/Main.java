import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Usuario ricardo = new Usuario("Ricardo", "rlangbecker@gmail.com", "senha", "999780280", 28, "masculino", "masculino");
        UsuarioManipulacao manipulacaoRicardo = new UsuarioManipulacao();
        Hobbies hobbiesRicardo = new Hobbies(TipoHobbies.BEBIDAS,"Whisky");
        HobbiesManipulacao hobbiesManipRicardo = new HobbiesManipulacao();

        hobbiesManipRicardo.adicionarHobbies(hobbiesRicardo);
        hobbiesManipRicardo.atualizarHobbie(hobbiesRicardo,TipoHobbies.FILMES,"Senhor dos aneis TRILOGIA");

        //
//        manipulacaoRicardo.listarUsuarios();
//        System.out.println("----------------");


        selecionarOpcao();


    }

    public static void mostrarMenu() {

        System.out.printf("*-------------------------*%n");
        System.out.printf("**->      Geekers      <-**%n");
        System.out.printf("*-------------------------*%n");
        System.out.printf("*        [1]Login         *%n");
        System.out.printf("*        [2]Registrar     *%n");
        System.out.printf("*        [0]Sair          *%n");
        System.out.printf("*-------------------------*%n");

    }

    public static void selecionarOpcao() {
        Scanner r = new Scanner(System.in);
        mostrarMenu();
        int opcao = r.nextInt();
        r.nextLine();

        switch (opcao) {
            case 1 -> { }
            case 2 -> registrar();
            case 0 -> {
                return;
            }
            default -> {
                System.out.println(" +++ Opcao inválida +++ \n");
                mostrarMenu();
            }
        }
    }

    public static void registrar() {
        Scanner r = new Scanner(System.in);
        UsuarioManipulacao usuarioManipulacao = new UsuarioManipulacao();
        Usuario usuario;

        System.out.println("+-- CADASTRO DE USUARIO --+\n"+"Insira os dados requisitados:");
        System.out.println("Nome:");
        String nome = r.nextLine();

        System.out.println("Email:");
        String email = r.nextLine();

        System.out.println("Senha:");
        String senha = r.nextLine();

        System.out.println("Numero:");
        String numero = r.nextLine();

        System.out.println("Idade:");
        int idade = r.nextInt();
        r.nextLine();

        System.out.println("Genero:");
        String genero = r.nextLine();

        System.out.println("Sexo:");
        String sexo = r.nextLine();

        usuario = new Usuario(nome, email, senha, numero, idade, genero, sexo);

        usuarioManipulacao.adicionarUsuario(usuario);

        r.close();
    }
}
