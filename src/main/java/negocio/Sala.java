package negocio;

public class Sala {

    private Integer numeroSala;
    private Integer lotacaoMax;
    private Boolean multimidia;
    private Locacao locacao;
    private String nomeBloco;

    public Sala(Integer numeroSala, Integer lotacaoMax, Boolean multimidia, Locacao locacao,String nomeBloco) {
        this.numeroSala = numeroSala;
        this.lotacaoMax = lotacaoMax;
        this.multimidia = multimidia;
        this.locacao = locacao;
        this.nomeBloco = nomeBloco;
    }

    public Integer getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(Integer numeroSala) {
        this.numeroSala = numeroSala;
    }

    public Integer getLotacaoMax() {
        return lotacaoMax;
    }

    public void setLotacaoMax(Integer lotacaoMax) {
        this.lotacaoMax = lotacaoMax;
    }

    public Boolean getMultimidia() {
        return multimidia;
    }

    public void setMultimidia(Boolean multimidia) {
        this.multimidia = multimidia;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    public String getNomeBloco() {
        return nomeBloco;
    }

    public void setNomeBloco(String nomeBloco) {
        this.nomeBloco = nomeBloco;
    }
}
