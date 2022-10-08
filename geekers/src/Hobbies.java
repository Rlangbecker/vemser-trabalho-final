public class Hobbies {
    public TipoHobbies hobbies;
    public String descricao;


    public Hobbies() {
    }


    public Hobbies(TipoHobbies hobbies, String descricao) {
        this.hobbies = hobbies;
        this.descricao = descricao;
    }

    public TipoHobbies getHobbies() {
        return hobbies;
    }

    public void setHobbies(TipoHobbies hobbies) {
        this.hobbies = hobbies;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Hobbies: " + hobbies +
                ", Descricao: " + descricao;
    }
}
