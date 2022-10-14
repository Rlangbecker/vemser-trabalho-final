import java.util.ArrayList;
import java.util.List;

public class Usuario implements Impressao {
    private String nome;
    private int id;
    private String email;
    private String telefone;
    private String senha;
    private String dataNascimento;
    private String genero;
    private String sexo;
    private boolean logado;

    public List<Desafios> desafios = new ArrayList<>();
    private List<Comentario> comentarios = new ArrayList<>();

    private List<Hobbies> hobbies = new ArrayList<>();

    private List<Usuario> matchs = new ArrayList<>();
    public Usuario() {
    }

    public Usuario(String nome, int id){
        this.nome = nome;
        this.id = id;
    }

    public Usuario(String nome, int id, String email, String telefone, String senha, String dataNascimento, String genero, String sexo, boolean logado, List<Desafios> desafios, List<Comentario> comentarios, List<Usuario> matchs, List<Hobbies> hobbies) {
        this.nome = nome;
        this.id = id;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.sexo = sexo;
        this.logado = logado;
        this.desafios = desafios;
        this.comentarios = comentarios;
        this.matchs = matchs;
        this.hobbies = hobbies;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public String getNome() {
        return nome;
    }

    public List<Hobbies> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobbies> hobbies) {
        this.hobbies = hobbies;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
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

    public List<Usuario> getMatchs() {
        return matchs;
    }

    public void setMatchs(List<Usuario> matchs) {
        this.matchs = matchs;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public boolean logar() {
        logado = true;
        return logado;
    }



    @Override
    public void imprimir() {
        System.out.println("\n+---------------------------------+\n"+"| Usuário: " + this.nome +
                           "\n| ID: " + this.id +
                           "\n| E-mail: " + this.email +
                "\n| Numero: " + this.telefone + "." +
                "\n| Data de nascimento: " + this.dataNascimento + "." +
                "\n| Genero: " + this.genero + "." +
                "\n| Sexo: " + this.sexo +
                "\n| Desafio: " + this.desafios +
                "\n| Comentario: " + this.comentarios +
                "\n| Matchs: " + this.matchs +
                "\n| Hobbies: " + this.hobbies +
                "\n+---------------------------------+ \n");

    }

    public void setDesafios(List<Desafios> desafios) {
        this.desafios = desafios;
    }


    public boolean deslogar() {
        logado = false;
        return logado;
    }

    @Override
    public String toString() {
        return "Usuario: " + nome + "\n" +
                "Telefone:" + telefone + "\n" +
                "Sexo='" + sexo + "\n" +
                "Hobbies=" + hobbies +"\n" ;
    }

}
