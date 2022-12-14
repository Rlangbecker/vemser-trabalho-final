package com.geekers.repository;

import com.geekers.exceptions.BancoDeDadosException;
import com.geekers.model.Desafio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repository <CHAVE, OBJETO>{

    Integer getProximoId(Connection connection) throws SQLException;
    OBJETO adicionar(OBJETO object) throws BancoDeDadosException;

    boolean remover(CHAVE id) throws BancoDeDadosException;

    boolean editar(CHAVE id, OBJETO objeto) throws BancoDeDadosException;

    List<OBJETO> listar() throws BancoDeDadosException;
}
