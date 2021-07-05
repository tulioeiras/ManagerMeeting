package negocio;

import java.time.LocalDateTime;

public class Locacao {

    private LocalDateTime dataHorarioLocacao;
    private Integer qtdParticipantes;
    private Integer periodoLocacao;

    public Locacao(LocalDateTime dataHorarioLocacao, Integer qtdParticipantes, Integer periodoLocacao) {
        this.dataHorarioLocacao = dataHorarioLocacao;
        this.qtdParticipantes = qtdParticipantes;
        this.periodoLocacao = periodoLocacao;
    }

    public LocalDateTime getDataHorarioLocacao() {
        return dataHorarioLocacao;
    }

    public void setDataHorarioLocacao(LocalDateTime dataHorarioLocacao) {
        this.dataHorarioLocacao = dataHorarioLocacao;
    }

    public Integer getQtdParticipantes() {
        return qtdParticipantes;
    }

    public void setQtdParticipantes(Integer qtdParticipantes) {
        this.qtdParticipantes = qtdParticipantes;
    }

    public Integer getPeriodoLocacao() {
        return periodoLocacao;
    }

    public void setPeriodoLocacao(Integer periodoLocacao) {
        this.periodoLocacao = periodoLocacao;
    }
}
