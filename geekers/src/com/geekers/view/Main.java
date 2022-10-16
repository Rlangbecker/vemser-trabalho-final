package com.geekers.view;

import com.geekers.model.Hobbie;
import com.geekers.model.Match;
import com.geekers.model.Usuario;
import com.geekers.repository.MatchRepository;
import com.geekers.service.HobbieService;
import com.geekers.service.MatchService;
import com.geekers.service.UsuarioService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Usuario usuario = new Usuario();
        UsuarioService usuarioService = new UsuarioService();
        Match match = new Match();
        MatchRepository matchRepository = new MatchRepository();
        MatchService matchService = new MatchService();

        usuario.setNome("Legado");
        usuario.setEmail("Kaio@bol.com");
        usuario.setDataNascimento(LocalDate.parse("14/03/2002", formatter));
        usuario.setSenha("1234");
        usuario.setTelefone("9991283113");
        usuario.setSexo("M");


        Hobbie hobbie = new Hobbie();
        hobbie.setUsuario(usuario);
        hobbie.setTipoHobbie("1");
        hobbie.setDescricao("ADORO VOAR");

        HobbieService hobbieService = new HobbieService();


        int opcao =-1;
        while(opcao!=0){
            menu.menuPrincipal();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1 -> {
                   Usuario user = fazerLogin(usuarioService,scanner);
                        opcao = -1;
                        if(user == null){
                            System.out.println("Email ou senha não conferem!\n Tente novamente");
                        } else {
                            while (user.isLogado()) {
                                menu.menuUsuarioLogado();
                                opcao = scanner.nextInt();
                                switch (opcao) {
                                    case 1 -> { //dar match
                                        usuarioService.listarUsuarios();
                                    }
                                    case 2 -> { //listar matchs
                                    matchService.listarMatchPorUsuario(user.getIdUsuario());
                                    }
                                    case 3 -> {//editar perfil
                                        menu.menuEditarPerfil();
                                    }
                                    case 0 -> { //deslogar
                                        user.setLogado(false);
                                        break;
                                    }
                                    default -> {
                                        System.out.println("Opção inválida, tente novamente");
                                    }
                                }

                            }
                        }
                    }
                case 2 -> {

                }
                case 0 -> {

                }
                default -> {
                    return;
                }
            }
        }


    }

    public static Usuario fazerLogin(UsuarioService usuarioService, Scanner entrada){

        Usuario usuario = new Usuario();
        Usuario resultadoUser = null;

        try{
            while (true) {
                System.out.println("Digite o email ");
                usuario.setEmail(entrada.nextLine());
                System.out.println("Digite a senha:");
                usuario.setSenha(entrada.nextLine());
                Usuario usuarioEncontrado = usuarioService.verificarUsuario(usuario);
                if (usuarioEncontrado.getEmail().equals(usuario.getEmail()) && usuarioEncontrado.getSenha().equals(usuario.getSenha())) {
                    System.out.println("\n"+usuario.getEmail() + " Logado com sucesso!");
                    resultadoUser = usuarioEncontrado;
                    resultadoUser.setLogado(true);
                    break;
                }
            }
        }catch (Exception ex){
//            System.out.println(ex.getMessage());
        }
        return resultadoUser;
    }
}