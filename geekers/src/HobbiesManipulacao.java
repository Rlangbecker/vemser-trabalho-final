import java.util.ArrayList;
import java.util.List;

public class HobbiesManipulacao {
    public Hobbies hobbies;
    public List<Hobbies> listaHobbies=new ArrayList<>();

    public void adicionarHobbies(Hobbies hobbie){
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
}
