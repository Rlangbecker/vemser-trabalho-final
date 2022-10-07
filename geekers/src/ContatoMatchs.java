import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContatoMatchs {

   private List<Usuario> contatos = new ArrayList<>();

    public void setContatos(List<Usuario> contatos) {
        this.contatos = contatos;
    }

    public List<Usuario> getContatos() {
        return contatos;
    }
    public void adicionarContato(Usuario usuario){
        if(contatos==null){
            contatos = new ArrayList<>();
        }
        contatos.add(usuario);
    }

//    VERIFICAR METODO ATUALIZAR CONTATO
    public void atualizarContato(int id,Usuario usuario){
        Usuario contatoAtualizar= contatos.get(id);
        contatoAtualizar.setNome(usuario.getNome());
        contatoAtualizar.setNumero(usuario.getNumero());
    }
    public void listarContatos(){
        for (int i = 0; i <contatos.size() ; i++) {
            System.out.println("ID -" + i + " | " + contatos.get(i));
        }
    }

    //VERIFICAR METODO LISTAR POR NOME
    public void listarContatoPorNome(String nome){
        Optional<Usuario> seTiverNome = contatos.stream()
                .filter(contatos-> contatos.getNome().toLowerCase().contains(nome))
                .findFirst();
        if (seTiverNome.isPresent()){
            Usuario usuario=seTiverNome.get();
            System.out.println(usuario.getId()+usuario.getNome());
        } else{
            System.out.println("Não há contatos com este nome.");
        }
    }

    public void deletarContato(int id){
        this.contatos.remove(id);
    }
}
