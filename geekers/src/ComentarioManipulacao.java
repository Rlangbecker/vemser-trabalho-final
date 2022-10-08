import java.util.ArrayList;
import java.util.List;

public class ComentarioManipulacao{

    public List<Comentario> comentarios = new ArrayList<>();

    public void adicionarComentario(Comentario comentario){
        if(comentarios==null){
            comentarios = new ArrayList<>();
        }
        comentarios.add(comentario);
    }

    public void listarComentario(){
        for (int i = 0; i <comentarios.size() ; i++) {
            System.out.println("ID -" + i + " | " + comentarios.get(i));
        }
    }

    public void atualizarComentario(int id, Comentario comentario){
        Comentario editarComentario = comentarios.get(id);
        editarComentario.setComentario(comentario.getComentario());
    }
    public void deletarHobbie(int id){
        this.comentarios.remove(id);
    }


}
