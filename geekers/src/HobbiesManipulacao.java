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

    public void atualizarHobbie(int id,Hobbies hobbies){
        Hobbies editarHobbie = listaHobbies.get(id);
        editarHobbie.setHobbies(hobbies.getHobbies());
        editarHobbie.setDescricao(hobbies.getDescricao());
    }
    public void deletarHobbie(int id){
        this.listaHobbies.remove(id);
    }

}
