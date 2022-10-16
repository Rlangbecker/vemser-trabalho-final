package com.geekers.service;

import com.geekers.exceptions.BancoDeDadosException;
import com.geekers.model.Comentario;
import com.geekers.model.Desafio;
import com.geekers.model.Usuario;
import com.geekers.repository.ComentarioRepository;

import java.util.List;

public class ComentarioService {

    private ComentarioRepository comentarioRepository;

    public ComentarioService(){
        comentarioRepository = new ComentarioRepository();
    }

    public void adicionarComentario (Comentario comentario) {
        try {

            Comentario comentarioAdd = comentarioRepository.adicionar(comentario);
            System.out.println("Comentario adicinado com sucesso! " + comentarioAdd);
        } catch (BancoDeDadosException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Erro: " + ex.getMessage());
        }
    }

    public void removerComentario(Integer id) {
        try {
            boolean conseguiuRemover = comentarioRepository.remover(id);
            System.out.println("Comentario removido?" + conseguiuRemover + " | com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void editarComentario(Integer id, Comentario comentario) {
        try {
            boolean conseguiuEditar = comentarioRepository.editar(id, comentario);
            System.out.println("Comentario editado? " + conseguiuEditar + " | com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void listar(){
        try {
            List<Comentario> listar = comentarioRepository.listar();
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void listarComentarioPorUsuario(Integer idUsuario) {
        try {
            List<Comentario> listar = comentarioRepository.listarPorUsuario(idUsuario);
            for(Comentario comentario : listar){
                System.out.println(comentario);
            };
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
}
