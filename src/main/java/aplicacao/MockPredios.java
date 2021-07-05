package aplicacao;

import negocio.Andar;
import negocio.Locacao;
import negocio.Predio;
import negocio.Sala;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class MockPredios {

    public static List<Predio> distribuirSalas() {

        String nomeBlocoA = "A";
        Locacao locacao1 = new Locacao(LocalDateTime.of(2021, 7, 5, 14, 10, 0), 5, 1);
        Sala sala1 = new Sala(101,10,true, locacao1,nomeBlocoA);
        Sala sala2 = new Sala(102,10,true,null,nomeBlocoA);
        Sala sala3 = new Sala(201,10,false,null,nomeBlocoA);
        Sala sala4 = new Sala(202,10,false,null,nomeBlocoA);

        Andar andar1 = new Andar(1, Arrays.asList(sala1,sala2));
        Andar andar2 = new Andar(1, Arrays.asList(sala3,sala4));

        Predio blocoA = new Predio(nomeBlocoA,Arrays.asList(andar1,andar2));

        String nomeBlocob = "B";
        Sala sala5 = new Sala(101,10,false,null,nomeBlocob);
        Sala sala6 = new Sala(102,10,true,null,nomeBlocob);
        Sala sala7 = new Sala(201,10,false,null,nomeBlocob);
        Sala sala8 = new Sala(202,10,false,null,nomeBlocob);

        Andar andar3 = new Andar(1, Arrays.asList(sala5,sala6));
        Andar andar4 = new Andar(1, Arrays.asList(sala7,sala8));

        Predio blocob = new Predio(nomeBlocob,Arrays.asList(andar3,andar4));

        return Arrays.asList(blocoA,blocob);
    }
}
