package com.geekers.repository;

import com.geekers.exceptions.BancoDeDadosException;
import com.geekers.model.Desafio;
import com.geekers.model.Match;
import com.geekers.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatchRepository implements Repository<Integer, Match> {

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT SEQ_MATCH.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");
        }

        return null;
    }

    @Override
    public Match adicionar(Match match) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            match.setIdMatch(proximoId);

            String sql = "INSERT INTO MATCH \n" +
                    "(id_match, id_usuario, id_usuario_main)\n" +
                    "VALUES(?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, match.getIdMatch());
            stmt.setInt(2, match.getUsuario().getIdUsuario());
            stmt.setInt(3, match.getUsuarioMain().getIdUsuario());

            int res = stmt.executeUpdate();
            System.out.println("adicionarMatch.res=" + res);
            return match;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM MATCH WHERE ID_DESAFIO = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerMatchPorId.res=" + res);

            return res > 0;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean editar(Integer id,Match match) throws BancoDeDadosException {
        return false;
    }

    @Override
    public List<Match> listar() throws BancoDeDadosException {
        List<Match> matches = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT M.*, " +
                    "            U.NOME AS NOME_PESSOA " +
                    "       FROM MATCH M " +
                    "  LEFT JOIN USUARIO U ON (M.ID_USUARIO = U.ID_USUARIO) ";

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Match match = getMatchFromResultSet(res);
                matches.add(match);
            }
            return matches;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public List<Match> listarPorUsuario(Integer idUsuario) throws BancoDeDadosException {
        List<Match> matches = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();


            String sql = "SELECT M.*, " +
                    "            U.NOME AS NOME_USUARIO " +
                    "       FROM MATCH M " +
                    " INNER JOIN USUARIO U ON (D.ID_USUARIO = U.ID_USUARIO) " +
                    "      WHERE M.ID_USUARIO = ? ";

            // Executa-se a consulta
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idUsuario);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Match match = getMatchFromResultSet(res);
                matches.add(match);
            }
            return matches;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private Match getMatchFromResultSet(ResultSet res) throws SQLException {
        Match match = new Match();
        match.setIdMatch(res.getInt("id_match"));
        Usuario usuario = new Usuario();
        match.setUsuario(usuario);
        usuario.setIdUsuario(res.getInt("id_usuario"));
        usuario.setIdUsuario(res.getInt("id_usuario_main"));
        return match;
    }

}
