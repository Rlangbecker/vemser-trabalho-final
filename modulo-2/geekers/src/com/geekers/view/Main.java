package com.geekers.view;

import com.geekers.model.Usuario;
import com.geekers.service.UsuarioService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Usuario usuario = new Usuario();
        UsuarioService usuarioService = new UsuarioService();

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

    }
}