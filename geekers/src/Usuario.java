import java.time.LocalDate;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class Usuario {

    public String nome;
    public int id;
    public String email;
    public String numero;
    public String senha;
    public int idade;
    public String genero;
    public String sexo;
    public boolean logado;

    public List<Desafios> desafios = new ArrayList<>();

    public List<Usuario> matchs = new ArrayList<>();


    public List<Desafios> getDesafios() {
        return desafios;
    }

    public void setDesafios(List<Desafios> desafios) {
        this.desafios = desafios;
    }




    public void setMatchs(List<Usuario> matchs) {
        this.matchs = matchs;
    }

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, String numero, int idade, String genero, String sexo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.numero = numero;
        this.idade = idade;
        this.genero = genero;
        this.sexo = sexo;

    }

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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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




    public boolean deslogar() {
        logado = false;
        return logado;
    }

    public boolean darMatch(Usuario usuario, String frase) {
        return false;
    }

    public void imprimirUsuario() {
        System.out.println();
    }

    @Override
    public String toString() {
        return "Nome='" + nome +
                ", id=" + id +
                ", email='" + email +
                ", idade=" + idade +
                ", genero='" + genero +
                ", sexo='" + sexo;
    }
}
