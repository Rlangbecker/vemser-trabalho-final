package com.geekers.view;

import com.geekers.model.Hobbie;
import com.geekers.model.Usuario;
import com.geekers.service.HobbieService;
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

        usuario.setNome("Legado");
        usuario.setEmail("Kaio@bol.com");
        usuario.setDataNascimento(LocalDate.parse("14/03/2002", formatter));
        usuario.setSenha("1234");
        usuario.setTelefone("9991283113");
        usuario.setSexo("M");
//        usuarioService.adicionarUsuario(usuario);

//        usuarioService.removerUsuario(4);
//
//        usuarioService.listarUsuarios();
//
//        usuarioService.editarUsuario();

        Hobbie hobbie = new Hobbie();
        hobbie.setUsuario(usuario);
        hobbie.setTipoHobbie("1");
        hobbie.setDescricao("ADORO VOAR");

        HobbieService hobbieService = new HobbieService();

        hobbieService.listar();

//        hobbieService.remover();

//        int opcao =-1;
//        while(opcao!=0){
//            menu.menuPrincipal();
//            opcao = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (opcao){
//                case 1 -> {
//                    System.out.println("Email:");
//                    String email = scanner.nextLine();
//                    System.out.println("Senha:");
//                    String senha = scanner.nextLine();
//                    if(usuarioService.logar(email,senha)){
//                        opcao = -1;
//                        while(opcao!=0){
//                            menu.menuUsuarioLogado();
//                        }
//                    } else {
//                        System.out.println("Tente novamente!\nSenha ou email inválidos");
//                    }
//
//                }
//                case 2 -> {
//
//                }
//                case 0 -> {
//
//                }
//                default -> {
//                    return;
//                }
//            }
//        }


    }
}