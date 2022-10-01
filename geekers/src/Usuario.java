import java.time.LocalDate;

public class Usuario {

    public String nome;
    public int id;
    public String email;
    public String senha;
    public String numero;
    public LocalDate dataNascimento;
    public String genero;
    public String sexo;
    private boolean isLogado;

    public boolean isLogado() {
        return isLogado;
    }

    public void setLogado(boolean logado) {
        isLogado = logado;
    }

    public boolean deslogar(){
        return isLogado=false;
    }

    public boolean darMatch(Usuario usuario){
        return false;
    }

    public String imprimirUsuario(){
        System.out.println();
        return "";
    };


}
