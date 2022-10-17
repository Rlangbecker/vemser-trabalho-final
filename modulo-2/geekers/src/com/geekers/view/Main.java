package com.geekers.view;

import com.geekers.exceptions.BancoDeDadosException;
import com.geekers.model.*;
import com.geekers.service.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import com.geekers.model.Comentario;
import com.geekers.model.Desafio;
import com.geekers.model.Match;
import com.geekers.model.Usuario;
import com.geekers.service.ComentarioService;
import com.geekers.service.DesafioService;
import com.geekers.service.MatchService;
import com.geekers.service.UsuarioService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
                                        System.out.println("Escolha o usuario que você quer dar match pelo id:");
                                        int idUsuario = scanner.nextInt();
                                        scanner.nextLine();
                                        desafioService.resolverDesafio(idUsuario,user);
                                    }
                                    case 2 -> { //matchs
                                        while (opcao != 0) {
                                            menu.menuMatchs();
                                            opcao = scanner.nextInt();
                                            switch (opcao) {
                                                case 1 -> {//listar matchs
                                                      matchService.listarMatchPorUsuario(user.getIdUsuario());
                                                }

                                                case 2 -> {//comentar match
                                                    Comentario comentarioMatch = new Comentario();
                                                    System.out.println("Informe seu comentario: ");
                                                    scanner.nextLine();
                                                    String comentar = scanner.nextLine();
                                                    comentarioMatch.setComentario(comentar);
                                                    System.out.println("Informe o id do usuario para comentar: ");
                                                    Integer idUsuario = scanner.nextInt();
                                                    Usuario usuarioComentario = usuarioService.listarUsuarioPorId(idUsuario);
                                                    comentarioMatch.setUsuario(usuarioComentario);
                                                    comentarioService.adicionarComentario(comentarioMatch);
                                                }
                                                case 3 -> {//excluir match
                                                    System.out.println("Informe o id do match que voce desja remover: ");
                                                        int idMatch = scanner.nextInt();
                                                        matchService.removerMatch(idMatch);
                                                }
                                                case 4 -> {
                                                    System.out.println("Informe o id do usuario para ver o comentario: ");
                                                    int idComentario = scanner.nextInt();
                                                    comentarioService.listarComentarioPorUsuario(idComentario);
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
                                            scanner.nextLine();
                                            switch (opcao) {
                                                case 1 -> {//ver dados perfil
                                                    System.out.println(user.toString());
                                                }
                                                case 2 -> {//editar dados perfil
                                                    Usuario atualizarUsuario = new Usuario();
                                                    System.out.println("Nome: ");
                                                    atualizarUsuario.setNome(scanner.nextLine());

                                                    System.out.println("E-mail: ");
                                                    atualizarUsuario.setEmail(scanner.nextLine());

                                                    System.out.println("Telefone: ");
                                                    atualizarUsuario.setTelefone(scanner.nextLine());

                                                    System.out.println("Senha: ");
                                                    atualizarUsuario.setSenha(scanner.nextLine());

                                                    System.out.println("Data nascimento: ");
                                                    String data = scanner.nextLine();
                                                    atualizarUsuario.setDataNascimento(LocalDate.parse(data, formatter));

                                                    System.out.println("Sexo: ");
                                                    atualizarUsuario.setSexo(scanner.nextLine());

                                                    usuarioService.editarUsuario(user.getIdUsuario(), atualizarUsuario);
                                                }
                                                case 3 -> {//ver desafio
                                                desafioService.listarDesafioPorUsuario(user.getIdUsuario());
                                                }
                                                case 4 -> {//editar desafio
// ---------------------------------------->        desafioService.editarDesafio();
                                                }
                                                case 5 -> {//ver hobbies
                                                    hobbieService.listarPorUsuario(user.getIdUsuario());
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
                        String dataNascimento = scanner.nextLine();
                        usuarioNovo.setDataNascimento(LocalDate.parse(dataNascimento, formatter));

                        System.out.println("Sexo: ");
                        usuarioNovo.setSexo(scanner.nextLine());

                        usuarioService.adicionarUsuario(usuarioNovo);

                        Hobbie hobbie1 = new Hobbie();

                        menu.menuEscolhaHobbies();

                        hobbie1.setTipoHobbie(scanner.nextLine());

                        menu.menuDescreverHobbie();
                        hobbie1.setDescricao(scanner.nextLine());
                        hobbie1.setUsuario(usuarioNovo);

                        hobbieService.adicionarHobbie(hobbie1);

                        Desafio desafio1 = new Desafio();

                        menu.menuCriarDesafio();
                        desafio1.setUsuario(usuarioNovo);
                        desafio1.setPergunta(scanner.nextLine());

                        menu.menuRespostaDesafio();
                        desafio1.setResposta(scanner.nextLine());
                        desafioService.adicionarDesafio(desafio1);

                        opcao = 0;

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