package negocio;

import java.util.List;

public class Andar {

    private Integer numAndar;
    private List<Sala> salas;

    public Andar(Integer numAndar, List<Sala> salas) {
        this.numAndar = numAndar;
        this.salas = salas;
    }

    public Integer getNumAndar() {
        return numAndar;
    }

    public void setNumAndar(Integer numAndar) {
        this.numAndar = numAndar;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }
}
