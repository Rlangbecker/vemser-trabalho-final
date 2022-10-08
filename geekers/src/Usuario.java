import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

    public String nome;
    public int id;
    public String email;
    public String numero;
    public String senha;
    public LocalDate dataNascimento;
    public String genero;
    public String sexo;
    public boolean logado;

    public List<Desafios> desafios = new ArrayList<>();
    public List<Usuario>usuarios=new ArrayList<>();

    public List<Usuario> matchs = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isLogado() {
        return logado;
    }

    public List<Desafios> getDesafios() {
        return desafios;
    }

    public void setDesafios(List<Desafios> desafios) {
        this.desafios = desafios;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Usuario> getMatchs() {
        return matchs;
    }

    public void setMatchs(List<Usuario> matchs) {
        this.matchs = matchs;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public boolean logar(String email,String senha){
        logado = true;
        return logado;
    }

    public boolean deslogar(){
    logado = false;
        return logado;
    }

    public boolean darMatch(Usuario usuario,String frase){
        return false;
    }
    public void imprimirUsuario(){
        System.out.println();
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", numero='" + numero + '\'' +
                ", senha='" + senha + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", genero='" + genero + '\'' +
                ", sexo='" + sexo + '\'' +
                ", logado=" + logado +
                ", desafios=" + desafios +
                ", usuarios=" + usuarios +
                ", matchs=" + matchs +
                '}';
    }
}
