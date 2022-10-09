public class Comentario {

    private String comentario;
    private Usuario usuario;

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "comentario='" + comentario + "}'";
    }

    public void imprimir(){
        System.out.println("Comentario: " + comentario);
    }
}
