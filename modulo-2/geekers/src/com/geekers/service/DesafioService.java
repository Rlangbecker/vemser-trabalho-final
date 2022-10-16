package com.geekers.service;

import com.geekers.exceptions.BancoDeDadosException;
import com.geekers.model.Desafio;
import com.geekers.model.Match;
import com.geekers.model.Usuario;
import com.geekers.repository.DesafioRepository;
import com.geekers.repository.UsuarioRepository;

import java.util.List;
import java.util.Scanner;

public class DesafioService {
    private DesafioRepository desafioRepository;

    public DesafioService(){
        desafioRepository = new DesafioRepository();

    }

    public void adicionarDesafio (Desafio desafio) {
        try {

            Desafio desafioAdd = desafioRepository.adicionar(desafio);
            System.out.println("Desafio adicinado com sucesso! " + desafioAdd);
        } catch (BancoDeDadosException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Erro: " + ex.getMessage());
        }
    }

    public void removerDesafio(Integer id) {
        try {
            boolean conseguiuRemover = desafioRepository.remover(id);
            System.out.println("Desafio removido?" + conseguiuRemover + " | com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void editarDesafio(Integer id, Desafio desafio) {
        try {
            boolean conseguiuEditar = desafioRepository.editar(id, desafio);
            System.out.println("desafio editado? " + conseguiuEditar + " | com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void listarDesafioPorUsuario(Usuario idUsuario) {
        try {
            List<Desafio> listar = desafioRepository.listarPorUsuario(idUsuario.getIdUsuario());
            for(Desafio desafio : listar){
                System.out.println(desafio);
            };
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public boolean verificarResposta(String opcao, Integer idUsuario) throws BancoDeDadosException {
        String resposta = desafioRepository.getRespostasDesafioPorUsuario(idUsuario);
        if (opcao.equals(resposta)){
            System.out.println("Resposta Correta!");
            return true;
        }
        else {
            System.out.println("Resposta Errada!");
            return false;
        }
    }

    public boolean resolverDesafio(Usuario idUsuario, Usuario idUsuarioLogado) throws BancoDeDadosException {
        Scanner sc = new Scanner(System.in);
        MatchService matchService = new MatchService();
        Match match = new Match();

        String escolha;
        System.out.println("Resolva o desafio desse Usuario: ");
        listarDesafioPorUsuario(idUsuario);
        System.out.println("Responda a pergunta: 0- Verdadeiro | 1- Falso");
        escolha = sc.nextLine();
        boolean retorno = verificarResposta(escolha, idUsuario.getIdUsuario());
        if (retorno){
            System.out.println("Usuario dado match com sucesso!");
            match.setUsuario(idUsuario);
            match.setUsuarioMain(idUsuarioLogado);
            matchService.adicionarMatch(match);
            return true;
        }
        else {
            System.out.println("Match não dado!");
            return false;
        }
    }

}
