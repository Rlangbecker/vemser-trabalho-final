package com.geekers.service;

import com.geekers.exceptions.BancoDeDadosException;
import com.geekers.model.Usuario;
import com.geekers.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(){
        usuarioRepository = new UsuarioRepository();

    }

    public void adicionarUsuario (Usuario usuario) {
        try {

            Usuario usuarioAdicionado = usuarioRepository.adicionar(usuario);
            System.out.println("Usuario adicinada com sucesso! " + usuarioAdicionado);
        } catch (BancoDeDadosException ex) {

        } catch (Exception ex) {
            System.err.println("Erro: " + ex.getMessage());
        }
    }

    public void removerUsuario(Integer id) {
        try {
            boolean conseguiuRemover = usuarioRepository.remover(id);
            System.out.println("Usuário removido? " + conseguiuRemover + " | com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void editarUsuario(Integer id, Usuario usuario) {
        try {
            boolean conseguiuEditar = usuarioRepository.editar(id, usuario);
            System.out.println("usuário editado? " + conseguiuEditar + " | com id= " + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void listarPorUsuarios(Integer id_usuario) {
        try {
            List<Usuario> listar = usuarioRepository.listarPorUsuario(id_usuario);
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    
    public void listarUsuariosPorUsuario(Integer quantidadeUsuarios) {
        try {
            List<Usuario> listar = usuarioRepository.listarPorUsuario(quantidadeUsuarios);
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public Usuario listarUsuarioPorId(Integer idUsuario){
        try {
            List<Usuario> listar = usuarioRepository.listarUsuarioPorID(idUsuario);
            return listar.get(0);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Usuario verificarUsuario (Usuario usuario) {
        try {
            return usuarioRepository.receberUsuario(usuario);
        } catch (BancoDeDadosException e) {
            System.err.println("ERRO: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}

}

