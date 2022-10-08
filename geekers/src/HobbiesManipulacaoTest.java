

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HobbiesManipulacaoTest<H> {
    Hobbies hobbies;
    HobbiesManipulacaoTest<H> hobbiesManipulacaoTest=new HobbiesManipulacaoTest<>();

    @BeforeEach
    public void init(){
        Hobbies hobbies = new Hobbies();
        HobbiesManipulacaoTest hobbiesManipulacaoTest = new HobbiesManipulacaoTest();
    }

    @Test
    public void deveAdicionarHobbieEDescricaoComSucesso(){
    hobbies.setHobbies(TipoHobbies.BEBIDAS);
    hobbies.setDescricao("Whisky");

    boolean retorno = hobbiesManipulacaoTest
    }
}
