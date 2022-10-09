import java.util.ArrayList;
import java.util.List;

public class ComentarioManipulacao<T>{
    private List<T> comentarios = new ArrayList<>();

    public boolean adicionarComentario(T comentario){
        if(comentarios==null){
            comentarios = new ArrayList<>();
            return false;
        }
        else{
            comentarios.add(comentario);
            return true;
        }
    }

    public List<T> listarComentario(){
        return comentarios;
    }

    public void atualizarComentario(Comentario comentario, String novoComentario){
        Comentario editarComentario = (Comentario) comentarios.get(0);
        editarComentario.setComentario(novoComentario);
    }
    public boolean deletarComentario(){
        if(comentarios==null){
            comentarios = new ArrayList<>();
            return false;
        }
        else {
            comentarios.remove(0);
            return true;
        }
    }


}
