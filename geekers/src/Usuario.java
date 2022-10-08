import java.time.LocalDate;

public class Usuario implements Impressao {

    private String nome;
    private int id;
    private String email;
    private String telefone;
    private String senha;
    private LocalDate dataNascimento;
    private String genero;
    private String sexo;
    private boolean logado;



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

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public boolean logar(String email, String senha) {
        logado = true;
        return logado;
    }

    public boolean deslogar() {
        logado = false;
        return logado;
    }

    public boolean darMatch(Usuario usuario, String frase) {
        return false;
    }

    @Override
    public void imprimir() {
        System.out.println("Usuário: " + this.nome +
                "\nID: " + this.id +
                "\nE-mail: " + this.email + "." +
                "\nNumero: " + this.telefone + "." +
                "\nData de nascimento: " + this.dataNascimento + "." +
                "\nGenero: " + this.genero + "." +
                "\nSexo: " + this.sexo + ".\n"
        );
    }
}
