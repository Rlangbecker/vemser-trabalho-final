package com.geekers.repository;

import com.geekers.exceptions.BancoDeDadosException;
import com.geekers.model.Desafio;
import com.geekers.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DesafioRepository implements Repository<Integer, Desafio> {

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT SEQ_DESAFIO.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");
        }

        return null;
    }

    @Override
    public Desafio adicionar(Desafio desafio) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            desafio.setIdDesafio(proximoId);

            String sql = "INSERT INTO DESAFIO\n" +
                    "(id_desafio, pergunta, resposta, id_usuario)\n" +
                    "VALUES(?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, desafio.getIdDesafio());
            stmt.setString(2, desafio.getPergunta());
            stmt.setString(3, desafio.getResposta()); // Resposta 0/1
            stmt.setInt(4, desafio.getUsuario().getIdUsuario());

            int res = stmt.executeUpdate();
            System.out.println("adicionarDesafio.res=" + res);
            return desafio;
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

            String sql = "DELETE FROM DESAFIO WHERE ID_DESAFIO = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerDesafioPorId.res=" + res);

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
    public boolean editar(Integer id,Desafio desafio) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE DESAFIO SET \n");
            Usuario usuario = desafio.getUsuario();

            if (desafio.getPergunta() != null) {
                sql.append(" pergunta = ?,");
            }
            if (desafio.getResposta() != null) {
                sql.append(" resposta = ?,");
            }

            sql.deleteCharAt(sql.length() - 1); //remove o ultimo ','
            sql.append(" WHERE id_desafio = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            int index = 1;

            if (desafio.getPergunta() != null) {
                stmt.setString(index++, desafio.getPergunta());
            }
            if (desafio.getResposta() != null) {
                stmt.setString(index++, desafio.getResposta());
            }

            stmt.setInt(index++, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("editarDesafio.res=" + res);

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
    public List<Desafio> listar() throws BancoDeDadosException {
        List<Desafio> desafios = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT C.*, " +
                    "            P.NOME AS NOME_PESSOA " +
                    "       FROM CONTATO C " +
                    "  LEFT JOIN PESSOA P ON (P.ID_PESSOA = C.ID_PESSOA) ";

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Desafio desafio = getDesafioFromResultSet(res);
                desafios.add(desafio);
            }
            return desafios;
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

    public List<Desafio> listarPorUsuario(Integer idUsuario) throws BancoDeDadosException {
        List<Desafio> desafios = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();


            String sql = "SELECT D.*, " +
                    "            U.NOME AS NOME_USUARIO " +
                    "       FROM DESAFIO D " +
                    " INNER JOIN USUARIO U ON (D.ID_USUARIO = U.ID_USUARIO) " +
                    "      WHERE D.ID_USUARIO = ? ";

            // Executa-se a consulta
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idUsuario);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Desafio desafio = getDesafioFromResultSet(res);
                desafios.add(desafio);
            }
            return desafios;
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
    private Desafio getDesafioFromResultSet(ResultSet res) throws SQLException {
        Desafio desafio = new Desafio();
        desafio.setIdDesafio(res.getInt("id_desafio"));
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(res.getInt("id_usuario"));
        desafio.setUsuario(usuario);
        desafio.setPergunta(res.getString("pergunta"));
        desafio.setResposta(res.getString("resposta"));
        return desafio;
    }

    public String getRespostasDesafioPorUsuario(Integer idUsuario) throws BancoDeDadosException {
        List<Desafio> desafios = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "SELECT D.* " +
                    "       FROM DESAFIO D " +
                    " INNER JOIN USUARIO U ON (D.ID_USUARIO = U.ID_USUARIO) " +
                    "      WHERE U.ID_USUARIO = ? ";

            // Executa-se a consulta
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idUsuario);

            ResultSet res = stmt.executeQuery();

            while (res.next()){
                Desafio desafio = getRespostaFromResultSet(res);
                desafios.add(desafio);
                System.out.println(desafios);
            }
            return desafios.get(0).getResposta();
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

    private Desafio getRespostaFromResultSet(ResultSet res) throws SQLException {
        Desafio desafio = new Desafio();
        desafio.setIdDesafio(res.getInt("id_desafio"));
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(res.getInt("id_usuario"));
        desafio.setUsuario(usuario);
        desafio.setPergunta(res.getString("pergunta"));
        desafio.setResposta(res.getString("resposta"));
        return desafio;
    }
}
