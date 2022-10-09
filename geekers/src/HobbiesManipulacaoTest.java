

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HobbiesManipulacaoTest<H> {
    Hobbies hobbies1;
    HobbiesManipulacao hobbiesManipulacaoTest = new HobbiesManipulacao();

    @BeforeEach
    public void init() {
        HobbiesManipulacaoTest hobbiesManipulacaoTest = new HobbiesManipulacaoTest();
        hobbies1 = new Hobbies();
    }

    @Test
    public void deveAdicionarHobbieEDescricaoComSucesso() {
        hobbies1.setDescricao("Senhor dos Aneis");
        hobbies1.setHobbies(TipoHobbies.FILMES);

        boolean retorno = hobbiesManipulacaoTest.adicionarHobbies(hobbies1);

        Assertions.assertTrue(retorno);
    }


    @Test
    public void deveAtualizarHobbiesComSucesso() {
        hobbies1.setDescricao("Mario Bros");
        hobbies1.setHobbies(TipoHobbies.JOGOS);
        hobbiesManipulacaoTest.adicionarHobbies(hobbies1);
        hobbiesManipulacaoTest.listarHobbies();
        boolean retorno = hobbiesManipulacaoTest.atualizarHobbie(hobbies1, TipoHobbies.JOGOS, "Call of duty");

        hobbiesManipulacaoTest.listarHobbies();
        Assertions.assertTrue(retorno);

    }

    @Test
    public void deveDeletarHobbieComSucesso() {

        hobbies1.setHobbies(TipoHobbies.FILMES);
        hobbies1.setDescricao("Senhor dos aneis");

        hobbiesManipulacaoTest.adicionarHobbies(hobbies1);
        hobbiesManipulacaoTest.listarHobbies();
        boolean retorno = hobbiesManipulacaoTest.deletarHobbie(0);

        Assertions.assertTrue(retorno);
    }

}
