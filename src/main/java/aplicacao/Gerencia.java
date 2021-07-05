package aplicacao;

import negocio.Locacao;
import negocio.Predio;
import negocio.Sala;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Gerencia {

    public static void alocarSalaPredioEspecifico(List<Predio> blocos, String nomePredio, LocalDateTime dataHorario, Integer duracao, Integer qtdParticipantes, Boolean multimidia){
        List<Sala> salasElegiveis = new ArrayList<>();
        blocos.forEach(bloco -> {
            if (bloco.getNomePredio().equals(nomePredio)){
                bloco.getAndares().forEach(andar ->{
                    andar.getSalas().forEach(sala -> {
                        if (sala.getLocacao() == null){
                            salasElegiveis.add(sala);
                        }
                    });
                });
            }
        });
        alocarSala(salasElegiveis,dataHorario,duracao,qtdParticipantes,multimidia);
    }

    public static void alocarSala(List<Sala> salas, LocalDateTime dataHorario, Integer duracao, Integer qtdParticipantes, Boolean multimidia){
        String mensagem = "";
        for (Sala sala : salas) {
            if (sala.getMultimidia() == multimidia) {
                if(sala.getLotacaoMax() >= qtdParticipantes){
                    sala.setLocacao(new Locacao(dataHorario, qtdParticipantes, duracao));
                    System.out.println("A reunião foi agendada para o dia "+ sala.getLocacao().getDataHorarioLocacao()+" na sala " + sala.getNumeroSala() +" do bloco "+ sala.getNomeBloco());
                    break;
                }else{
                    mensagem = "Quantidade de participantes maior que o permitido nas salas disponíveis. Favor cadastre novamente com quantidade menor de participantes.";
                }
            }else{
                mensagem = "Nenhuma sala com o requisito de multimidia especificado disponível.";
            }
        }
        System.out.println(mensagem);
    }

    public static List<Sala> salasDisponiveis(List<Predio> predios){
        List<Sala> salasVazias = new ArrayList<>();
        todasSalas(predios).forEach(sala -> {
            if(sala.getLocacao() == null){
                salasVazias.add(sala);
            }
        });
        return salasVazias;
    }

    public static List<Sala> salasEmUso(List<Predio> predios){
        List<Sala> salasEmUso = new ArrayList<>();
        todasSalas(predios).forEach(sala -> {
            if(sala.getLocacao() != null){
                salasEmUso.add(sala);
            }
        });
        return salasEmUso;
    }

    public static void limparSala(List<Predio> predios, String nomePredio,Integer numeroSala){
        predios.forEach(predio -> {
            if (predio.getNomePredio().equals(nomePredio)){
                predio.getAndares().forEach(andar -> {
                    andar.getSalas().forEach(sala -> {
                        if (sala.getNumeroSala().equals(numeroSala)){
                            Integer lotacaoMax = sala.getLotacaoMax();
                            System.out.println("A limpeza da sala tem duração de "+ (5+lotacaoMax)+ " minutos, mas em "+ (5+lotacaoMax)+ " segundos será liberada.");
                            try {
                                Thread.sleep((long) ((5 + lotacaoMax) * 1000L));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            sala.setLocacao(null);
                            System.out.println("A sala foi limpa");
                        }
                    });
                });
            }
        });

    }

    private static List<Sala> todasSalas(List<Predio> predios){
        List<Sala> salas = new ArrayList<>();
        predios.forEach(predio -> {
            predio.getAndares().forEach(andar -> {
                salas.addAll(andar.getSalas());
            });
        });
        return salas;
    }

}
