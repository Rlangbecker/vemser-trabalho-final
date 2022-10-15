package com.geekers.view;

import com.geekers.exceptions.BancoDeDadosException;
import com.geekers.model.Desafio;
import com.geekers.model.Match;
import com.geekers.model.Usuario;
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
        Match match = new Match();
        UsuarioService usuarioService = new UsuarioService();
        DesafioService desafioService = new DesafioService();
        MatchService matchService = new MatchService();

        usuario.setNome("Teste");
        usuario.setEmail("Kaio@bol.com");
        usuario.setDataNascimento(LocalDate.parse("14/03/2002", formatter));
        usuario.setSenha("1234");
        usuario.setTelefone("9991283113");
        usuario.setSexo("M");

        usuario2.setNome("Julia");
        usuario2.setEmail("123@bol.com");
        usuario2.setDataNascimento(LocalDate.parse("14/03/2002", formatter));
        usuario2.setSenha("1234");
        usuario2.setTelefone("9991283113");
        usuario2.setSexo("M");

        desafio.setPergunta("gremio maior do rio?");
        desafio.setResposta("1");
        desafio.setUsuario(usuario);

        desafioEditado.setPergunta("O flamengo é o maior de todos os tempos?");
        desafioEditado.setResposta("1");
        usuarioService.adicionarUsuario(usuario2);
        usuarioService.adicionarUsuario(usuario);
        //desafioService.adicionarDesafio(desafio);
        //desafioService.listarDesafioPorUsuario(9);
        //desafioService.editarDesafio(4, desafioEditado);
        //desafioService.listarDesafioPorUsuario(9);
        //desafioService.removerDesafio(10);
        //desafioService.verificarResposta("1",9);
        //usuarioService.listarUsuarios();

//        match.setUsuario(usuario2);
//        match.setUsuarioMain(usuario);
//        matchService.adicionarMatch(match);
//        matchService.listarMatchPorUsuario(2);
//        matchService.removerMatch(1);

    }
}