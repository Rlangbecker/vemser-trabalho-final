import java.util.ArrayList;
import java.util.List;

public class HobbiesManipulacao<T> {
    private Hobbies hobbies;
    private List<T> listaHobbies = new ArrayList<>();

    public HobbiesManipulacao() {
    }

    public HobbiesManipulacao(Hobbies hobbies) {
        this.hobbies = hobbies;
    }

    public boolean adicionarHobbies(T hobbie) {
        if (listaHobbies == null) {
            listaHobbies = new ArrayList<>();
            listaHobbies.add(hobbie);
        }
        listaHobbies.add(hobbie);
        return true;
    }

    public List<T> listarHobbies() {
        return listaHobbies;
    }

    public boolean atualizarHobbie(T hobbies, TipoHobbies tipoHobbies, String descricaoHobbie) {

        Hobbies hobbiesAtualizar = (Hobbies) listaHobbies.get(0);

        hobbiesAtualizar.setHobbies(tipoHobbies);
        hobbiesAtualizar.setDescricao(descricaoHobbie);
        return true;
    }

    public boolean deletarHobbie(int id) {

        this.listaHobbies.remove(id);
        return true;
    }

    @Override
    public String toString() {
        return "Hobbies :" + hobbies +
                ", listaHobbies=" + listaHobbies +
                '}';
    }

    public Hobbies getHobbies() {
        return hobbies;
    }

    public void setHobbies(Hobbies hobbies) {
        this.hobbies = hobbies;
    }

    public List<T> getListaHobbies() {
        return listaHobbies;
    }

    public void setListaHobbies(List<T> listaHobbies) {
        this.listaHobbies = listaHobbies;
    }

}
