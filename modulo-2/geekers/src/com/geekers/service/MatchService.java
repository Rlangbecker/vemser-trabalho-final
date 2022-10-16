package com.geekers.service;

import com.geekers.exceptions.BancoDeDadosException;
import com.geekers.model.Desafio;
import com.geekers.model.Match;
import com.geekers.model.Usuario;
import com.geekers.repository.DesafioRepository;
import com.geekers.repository.MatchRepository;
import com.geekers.repository.UsuarioRepository;

import java.util.List;

public class MatchService {
    private MatchRepository matchRepository;

    public MatchService(){
        matchRepository = new MatchRepository();

    }

    public void adicionarMatch (Match match) {
        try {

            Match matchAdd = matchRepository.adicionar(match);
            System.out.println("Match adicinado com sucesso! " + matchAdd);
        } catch (BancoDeDadosException ex) {

        } catch (Exception ex) {
            System.err.println("Erro: " + ex.getMessage());
        }
    }

    public void removerMatch(Integer id) {
        try {
            boolean conseguiuRemover = matchRepository.remover(id);
            System.out.println("Match removido?" + conseguiuRemover + " | com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void listarMatchPorUsuario(Integer idUsuario) {
        try {
            List<Match> listar = matchRepository.listarPorUsuario(idUsuario);
            for(Match match : listar){
                System.out.println(match);
            };
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

}
