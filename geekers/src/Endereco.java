import java.util.ArrayList;
import java.util.List;

public class Endereco {

    private String rua;
    private String cidade;
    private String estado;
    private String pais;

    private List<Endereco> enderecos = new ArrayList<>();

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void adicionarEndereco(Endereco endereco) {
        if (enderecos == null) {
            enderecos = new ArrayList<>();
        }
        enderecos.add(endereco);
    }

    public void listarContatos() {
        for (int i = 0; i < enderecos.size(); i++) {
            System.out.println("ID -" + i + " | " + enderecos.get(i));
        }
    }

    public void atualizarEndereco(int id, Endereco Endereco) {
        Endereco enderecoAtualizar = enderecos.get(id);
        enderecoAtualizar.setRua(getRua());
        enderecoAtualizar.setCidade((getCidade()));
    }

    public void deletarEndereco(int id) {
        this.enderecos.remove(id);
    }

}
