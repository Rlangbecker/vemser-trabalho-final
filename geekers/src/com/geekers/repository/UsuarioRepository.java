package com.geekers.repository;

import com.geekers.exceptions.BancoDeDadosException;
import com.geekers.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository implements Repository<Integer, Usuario> {

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT SEQ_USUARIO.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");
        }

        return null;
    }

    @Override
    public Usuario adicionar(Usuario usuario) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            usuario.setIdUsuario(proximoId);

            String sql = "INSERT INTO USUARIO\n" +
                    "(id_usuario, nome, email, telefone, senha, data_nascimento, sexo)\n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?)\n";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, usuario.getIdUsuario());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getTelefone());
            stmt.setString(5, usuario.getSenha());
            stmt.setDate(6, Date.valueOf(usuario.getDataNascimento()));
            stmt.setString(7, usuario.getSexo());
            int res = stmt.executeUpdate();
            System.out.println("adicionarUsuario.res=" + res);
            return usuario;
        } catch (SQLException e) {
            e.printStackTrace();
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

            String sql = "DELETE FROM USUARIO WHERE id_usuario = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            int res = stmt.executeUpdate();
            System.out.println("removerUsuarioPorId.res = " + res);

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
    public boolean editar(Integer id, Usuario usuario) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE USUARIO SET ");
            sql.append(" nome  = ? ");
            sql.append(" email = ? ");
            sql.append(" telefone = ? ");
            sql.append(" senha = ? ");
            sql.append(" data_nascimento = ?");
            sql.append(" sexo = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getTelefone());
            stmt.setString(4, usuario.getSenha());
            stmt.setDate(5, Date.valueOf(usuario.getDataNascimento()));
            stmt.setString(6, usuario.getSexo());

            int res = stmt.executeUpdate();
            System.out.println("editarUsuario.res = " + res);

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
    public List<Usuario> listar() throws BancoDeDadosException {
        List<Usuario> usuarios = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM USUARIO";

            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(res.getInt(" id_usuario "));
                usuario.setNome(res.getString(" nome "));
                usuario.setEmail(res.getString(" email "));
                usuario.setTelefone(res.getString(" telefone "));
                usuario.setSenha(res.getString(" senha "));
                usuario.setDataNascimento(res.getDate(" data_nascimento ").toLocalDate());
                usuario.setSexo(res.getString(" sexo "));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
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
        return usuarios;
    }


    public boolean logar(Usuario usuario) {
        usuario.setLogado(true);
        return true;
    }

    public Usuario receberUsuario(Usuario usuarioLogin)throws BancoDeDadosException {
        Connection con = null;
        Usuario usuario = new Usuario();

        try {
            con = ConexaoBancoDeDados.getConnection();
            String sql = "SELECT * FROM USUARIO " +
                    " WHERE EMAIL = ? AND SENHA = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuarioLogin.getEmail());
            stmt.setString(2, usuarioLogin.getSenha());

            ResultSet res = stmt.executeQuery();

            res.next();
            usuario.setIdUsuario(res.getInt("id_usuario"));
            usuario.setNome(res.getString("nome"));
            usuario.setEmail(res.getString("email"));
            usuario.setSenha(res.getString("senha"));

        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            try{
                if (con != null){
                    con.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return usuario;
    }


}
