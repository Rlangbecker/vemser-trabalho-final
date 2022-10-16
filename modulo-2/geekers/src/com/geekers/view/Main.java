package com.geekers.view;

import com.geekers.exceptions.BancoDeDadosException;
import com.geekers.model.*;
import com.geekers.service.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws BancoDeDadosException {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Usuario usuario = new Usuario();
        Usuario usuario2 = new Usuario();
        Desafio desafio = new Desafio();
        Desafio desafioEditado = new Desafio();
        Comentario comentario = new Comentario();
        Comentario comentario1 = new Comentario();
        Match match = new Match();
        UsuarioService usuarioService = new UsuarioService();
        DesafioService desafioService = new DesafioService();
        MatchService matchService = new MatchService();
        ComentarioService comentarioService = new ComentarioService();

        // ------ Insert Usuário ------
//        usuario.setNome("Legado");
//        usuario.setEmail("Kaio@bol.com");
//        usuario.setDataNascimento(LocalDate.parse("14/03/2002", formatter));
//        usuario.setSenha("1234");
//        usuario.setTelefone("9991283113");
//        usuario.setSexo("M");
//        usuarioService.adicionarUsuario(usuario);


        // ------ Insert Usuário ------
//        usuarioService.removerUsuario(4);
//
//        usuarioService.listarUsuarios();



        // ------ Update Usuário ------
//        Usuario usuarioUpdate = new Usuario();
//        usuarioUpdate.setNome("Noguez");
//        usuarioUpdate.setEmail("noguez@mail.com");
//        usuarioUpdate.setTelefone("+555198745612");
//        usuarioUpdate.setSenha("kkkkkkkkkKKKhhHHH");
//        String data = "25/02/1983";
//        usuarioUpdate.setDataNascimento(LocalDate.parse(data, formatter));
//        usuarioUpdate.setSexo("M");
//        usuarioService.editarUsuario(1, usuarioUpdate);
//
//        usuarioService.listarUsuarios();
//
//        usuario.setNome("Teste");
//        usuario.setEmail("Kaio@bol.com");
//        usuario.setDataNascimento(LocalDate.parse("14/03/2002", formatter));
//        usuario.setSenha("1234");
//        usuario.setTelefone("9991283113");
//        usuario.setSexo("M");
//
//        usuario2.setNome("Julia");
//        usuario2.setEmail("123@bol.com");
//        usuario2.setDataNascimento(LocalDate.parse("14/03/2002", formatter));
//        usuario2.setSenha("1234");
//        usuario2.setTelefone("9991283113");
//        usuario2.setSexo("M");
////
//        desafio.setPergunta("gremio maior do rio?");
//        desafio.setResposta("1");
//        desafio.setUsuario(usuario);
//
//        desafioEditado.setPergunta("O flamengo é o maior de todos os tempos?");
//        desafioEditado.setResposta("1");
//        usuarioService.adicionarUsuario(usuario2);
//        usuarioService.adicionarUsuario(usuario);
//        desafioService.adicionarDesafio(desafio);
//        desafioService.editarDesafio(4, desafioEditado);
//        desafioService.removerDesafio(10);
//        desafioService.verificarResposta("1",9);
//        usuarioService.listarUsuarios();

//        match.setUsuario(usuario2);
//        match.setUsuarioMain(usuario);
//        matchService.adicionarMatch(match);
//        matchService.listarMatchPorUsuario(2);
//        matchService.removerMatch(1);

//        comentario.setComentario("Muito bom perfil!");
//        comentario.setUsuario(usuario);
//        comentarioService.adicionarComentario(comentario);
//        comentarioService.listarComentarioPorUsuario(usuario.getIdUsuario());
//        comentario1.setComentario("Parabens");
//        comentarioService.editarComentario(25, comentario1);
//        comentarioService.listar();
//        desafioService.listarDesafioPorUsuario(usuario);
//        desafioService.resolverDesafio(usuario,usuario2);



        // MENUS RICARDO

        Menu menu = new Menu();
        Hobbie hobbie = new Hobbie();
        hobbie.setUsuario(usuario);
        hobbie.setTipoHobbie("1");
        hobbie.setDescricao("ADORO VOAR");

        HobbieService hobbieService = new HobbieService();


        int opcao = -1;
        while (opcao != -3) {
            try {
                menu.menuPrincipal();
                opcao = scanner.nextInt();
                scanner.nextLine();
                if (opcao == 0) {
                    opcao = -3;
                }
            } catch (InputMismatchException e) {
                System.out.println("Opcao inválida, tente novamente!");
                break;
            }
            while (opcao != 0) {
                switch (opcao) {
                    case 1 -> {
                        Usuario userTemp = fazerLogin(usuarioService, scanner);
                        Usuario user = userTemp;
                        opcao = -1;
                        if (user == null) {
                            System.out.println("Email ou senha não conferem!\n Tente novamente");
                            opcao = 0;
                        } else {
                            while (user.isLogado()) {
                                try {
                                    menu.menuUsuarioLogado();
                                    opcao = scanner.nextInt();
                                } catch(InputMismatchException e){
                                    System.out.println("Opcao inválida, tente novamente!");
                                    break;
                                }
                                switch (opcao) {
                                    case 1 -> { //dar match
                                        System.out.println("Insira a quantidade de usuarios que gostaria de listar:");
                                        int quantidade = scanner.nextInt();
                                        usuarioService.listarUsuariosPorUsuario(quantidade);
                                    }
                                    case 2 -> { //matchs
                                        while (opcao != 0) {
                                            menu.menuMatchs();
                                            opcao = scanner.nextInt();
                                            switch (opcao) {
                                                case 1 -> {//listar matchs
// ---------------------------------------->        matchService.listarMatchPorUsuario();
                                                }
                                                case 2 -> {//comentar match
// ---------------------------------------->
                                                }
                                                case 3 -> {//excluir match
// ---------------------------------------->        matchService.removerMatch();
                                                }
                                                case 0 -> {//voltar menu principal
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    case 3 -> {//editar perfil
                                        opcao = -1;
                                        while (opcao != 0) {
                                            menu.menuEditarPerfil();
                                            opcao = scanner.nextInt();
                                            switch (opcao) {
                                                case 1 -> {//ver dados perfil
                                                    usuarioService.verificarUsuario(user);
                                                }
                                                case 2 -> {//editar dados perfil
                                                    usuarioService.editarUsuario(user.getIdUsuario(), user);
                                                }
                                                case 3 -> {//ver desafio
                                                desafioService.listarDesafioPorUsuario(user);
                                                }
                                                case 4 -> {//editar desafio
// ---------------------------------------->        desafioService.editarDesafio();
                                                }
                                                case 5 -> {//ver hobbies
                                                    hobbieService.listar();
                                                }
                                                case 6 -> {//editar hobbies
                                                    System.out.println("Insira o ID do hobbie a ser editado: ");
                                                    int idHobbie = scanner.nextInt();
                                                    scanner.nextLine();

                                                    Hobbie hobbieEditado = new Hobbie();
                                                    System.out.println("Qual o seu hobbie ?");
                                                    hobbieEditado.setTipoHobbie(scanner.nextLine());
                                                    System.out.println("Insira a descrição: ");
                                                    hobbieEditado.setDescricao(scanner.nextLine());

                                                    hobbieService.editar(idHobbie, hobbieEditado);
                                                }
                                                case 0 -> {//voltar ao menu principal
                                                    break;
                                                }
                                            }
                                        }

                                    }
                                    case 0 -> { //deslogar
                                        user.setLogado(false);
                                    }
                                    default -> {
                                        System.out.println("Opção inválida, tente novamente");
                                    }
                                }
                            }
                        }
                    } case 2 -> { // cadastrar usuario
                        Usuario usuarioNovo = new Usuario();
                        System.out.println("Insira seus dados\n");

                        System.out.println("Nome:");
                        usuarioNovo.setNome(scanner.nextLine());

                        System.out.println("Email:");
                        usuarioNovo.setEmail(scanner.nextLine());

                        System.out.println("Senha:");
                        usuarioNovo.setSenha(scanner.nextLine());

                        System.out.println("Telefone: ");
                        usuarioNovo.setTelefone(scanner.nextLine());

                        System.out.println("Data de nascimento: ");
                        String dataNascimento =  scanner.nextLine();
                        usuarioNovo.setDataNascimento(LocalDate.parse(dataNascimento, formatter));

                        System.out.println("Sexo: ");
                        usuarioNovo.setSexo(scanner.nextLine());

                        usuarioService.adicionarUsuario(usuarioNovo);
                    }
                    case 0 -> {
                        System.out.println("Deslogando");
                    }
                    default -> {
                        return;
                    }
                }
            }
        }


    }
    public static Usuario fazerLogin(UsuarioService usuarioService, Scanner entrada) {

        Usuario usuario = new Usuario();
        Usuario resultadoUser = null;

        try {
            while (true) {
                System.out.println("Digite o email ");
                usuario.setEmail(entrada.nextLine());
                System.out.println("Digite a senha:");
                usuario.setSenha(entrada.nextLine());
                Usuario usuarioEncontrado = usuarioService.verificarUsuario(usuario);
                if (usuarioEncontrado.getEmail().equals(usuario.getEmail()) && usuarioEncontrado.getSenha().equals(usuario.getSenha())) {
                    System.out.println("\n" + usuario.getEmail() + " Logado com sucesso!");
                    resultadoUser = usuarioEncontrado;
                    resultadoUser.setLogado(true);
                    break;
                }
            }
        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
        }
        return resultadoUser;
    }
}