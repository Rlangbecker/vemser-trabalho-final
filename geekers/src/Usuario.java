import java.time.LocalDate;

public class Usuario {

    private String nome;
    private int id;
    private String email;
    private String senha;
    private String numero;
    private LocalDate dataNascimento;
    private String genero;
    private String sexo;
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
