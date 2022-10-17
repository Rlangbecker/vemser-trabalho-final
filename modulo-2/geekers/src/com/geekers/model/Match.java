package com.geekers.model;

public class Match {

    private Integer idMatch;
    private Usuario usuario;
    private Usuario usuarioMain;

    public Integer getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(Integer idMatch) {
        this.idMatch = idMatch;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioMain() {
        return usuarioMain;
    }

    public void setUsuarioMain(Usuario usuarioMain) {
        this.usuarioMain = usuarioMain;
    }

    @Override
    public String toString() {
        return "Match{" +
                "idMatch=" + idMatch +
                ", usuario=" + usuario +
                ", usuarioMain=" + usuarioMain +
                '}';
    }
}
