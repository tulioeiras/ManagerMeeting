package aplicacao;

import negocio.Predio;
import negocio.Sala;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static aplicacao.Gerencia.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GerenciaTest {

    @Test
    public void alocar_sala_por_predio_sucesso(){
        List<Predio> blocos = MockPredios.distribuirSalas();
        Assert.assertNull(blocos.get(0).getAndares().get(0).getSalas().get(1).getLocacao());
        alocarSalaPredioEspecifico(blocos, "A", LocalDateTime.now(), 1, 10, true);

        assertThat(blocos.get(0).getAndares().get(0).getSalas().get(1).getLocacao().getQtdParticipantes(),is(10));
    }

    @Test
    public void alocar_sala_verificacao_qtd_participantes(){
        List<Sala> salas = salasDisponiveis(MockPredios.distribuirSalas());
        Assert.assertNull(salas.get(1).getLocacao());
        alocarSala(salas,LocalDateTime.now(), 1, 15, true);
        Assert.assertNull(salas.get(1).getLocacao());
    }

    @Test
    public void salas_disponiveis_sucesso(){
        List<Sala> salas = salasDisponiveis(MockPredios.distribuirSalas());

        assertThat(salas.size(), is(7));
        assertThat(salas.get(0).getNumeroSala(),is(102));
        assertThat(salas.get(0).getNomeBloco(),is("A"));
        assertThat(salas.get(0).getLotacaoMax(),is(10));
        assertThat(salas.get(0).getMultimidia(),is(Boolean.TRUE));
    }

    @Test
    public void salas_em_uso_sucesso(){
        List<Sala> salas = salasEmUso(MockPredios.distribuirSalas());

        assertThat(salas.size(), is(1));
        assertThat(salas.get(0).getNumeroSala(),is(101));
        assertThat(salas.get(0).getNomeBloco(),is("A"));
        assertThat(salas.get(0).getLotacaoMax(),is(10));
        assertThat(salas.get(0).getMultimidia(),is(Boolean.TRUE));
    }

    @Test
    public void limpar_salas_sucesso(){
        List<Predio> predios = MockPredios.distribuirSalas();

        Assert.assertNotNull(predios.get(0).getAndares().get(0).getSalas().get(0).getLocacao());
        limparSala(predios,"A",101);

        Assert.assertNull(predios.get(0).getAndares().get(0).getSalas().get(0).getLocacao());

    }
}
