package com.geekers.view;

import com.geekers.model.Hobbies;
import com.geekers.model.Usuario;
import com.geekers.service.HobbieService;
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

        Hobbies hobbie = new Hobbies();
        hobbie.setUsuario(usuario);
        hobbie.setTipoHobbie("1");
        hobbie.setDescricao("ADORO VOAR");

        HobbieService hobbieService = new HobbieService();

        hobbieService.listar();

//        hobbieService.remover();

    }
}