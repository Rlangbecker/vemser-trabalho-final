import java.util.ArrayList;
import java.util.List;

public class HobbiesManipulacao<T> {
    public Hobbies hobbies;
    public List<T> listaHobbies=new ArrayList<>();


    public HobbiesManipulacao() {
    }

    public HobbiesManipulacao(Hobbies hobbies) {
        this.hobbies = hobbies;
    }

    public void adicionarHobbies(T hobbie){
        if(listaHobbies==null){
            listaHobbies = new ArrayList<>();
        }
        listaHobbies.add(hobbie);
    }

    public void listarHobbies(){
        for (int i = 0; i <listaHobbies.size() ; i++) {
            System.out.println("ID -" + i + " | " + listaHobbies.get(i));
        }
    }

    public void atualizarHobbie(Hobbies hobbies, TipoHobbies tipoHobbies, String descricaoHobbie){

        Hobbies hobbiesAtualizar = (Hobbies) listaHobbies.get(0);

        hobbiesAtualizar.setHobbies(tipoHobbies);
        hobbiesAtualizar.setDescricao(descricaoHobbie);
    }
    public void deletarHobbie(int id){
        this.listaHobbies.remove(id);
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
