package negocio;

import java.util.List;

public class Predio {

    private String nomePredio;
    private List<Andar> andares;

    public Predio(String nomePredio, List<Andar> andares) {
        this.nomePredio = nomePredio;
        this.andares = andares;
    }

    public String getNomePredio() {
        return nomePredio;
    }

    public void setNomePredio(String nomePredio) {
        this.nomePredio = nomePredio;
    }

    public List<Andar> getAndares() {
        return andares;
    }

    public void setAndares(List<Andar> andares) {
        this.andares = andares;
    }
}
