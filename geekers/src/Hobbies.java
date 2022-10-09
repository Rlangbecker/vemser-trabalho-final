public class Hobbies {
    public TipoHobbies hobbies;
    public String descricao;

    public TipoHobbies getHobbies() {
        return hobbies;
    }

    public Hobbies(){

    }

    public Hobbies(TipoHobbies hobbies, String descricao) {
        this.hobbies = hobbies;
        this.descricao = descricao;
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
        return
                "hobbies=" + hobbies +
                ", descricao='" + descricao + '\'';
    }
}
