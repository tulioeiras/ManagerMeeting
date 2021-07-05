package aplicacao;

import negocio.Predio;
import negocio.Sala;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static aplicacao.Gerencia.*;
import static aplicacao.MockPredios.distribuirSalas;

public class Principal {

    public static void main(String[] args) {

        List<Predio> blocos = distribuirSalas();

        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        do{
            try {
                System.out.println("## Escolha uma das opções abaixo ##");
                System.out.println("Opção 1 - Visualizar salas disponíveis");
                System.out.println("Opção 2 - Visualizar salas em uso");
                System.out.println("Opção 3 - Agendar reunião em sala");
                System.out.println("Opção 4 - Agendar reunião em um predio especifico");
                System.out.println("Opção 5 - Limpar sala de reunião");
                System.out.println("Opção 0 - Sair do programa");
                System.out.println("_______________________");

                System.out.print("Digite aqui sua opção: ");
                opcao = Integer.parseInt(sc.nextLine());

                if (opcao == 1){
                    List<Sala> salas = salasDisponiveis(blocos);
                    System.out.println("São "+ salas.size()+" salas disponíveis:");
                    salas.forEach(sala -> {
                        System.out.println("Sala "+ sala.getNumeroSala()+" do bloco: "+ sala.getNomeBloco() +" com suporte a multimidia:" + sala.getMultimidia() +" e com alocação máxima de "+ sala.getLotacaoMax());
                    });
                }
                if (opcao == 2){
                    List<Sala> salas = salasEmUso(blocos);
                    System.out.println("São "+ salas.size()+" salas alocadas:");
                    salas.forEach(sala -> {
                        System.out.println("Sala "+ sala.getNumeroSala()+" do bloco: "+ sala.getNomeBloco() +" com suporte a multimidia:" + sala.getMultimidia());
                    });
                }
                if (opcao == 3){

                    System.out.println("Digite uma data no formato: DD/MM/AAAA HH:MM");
                    String dataRecebida = sc.nextLine();
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    Date dt = df.parse(dataRecebida);
                    LocalDateTime localDateTime = new Timestamp(dt.getTime()).toLocalDateTime();

                    System.out.println("Digite a duração da reunião em horas:");
                    String duracao = sc.nextLine();

                    System.out.println("Digite a quantidade de participante na reunião:");
                    String qtdParticipantes = sc.nextLine();

                    System.out.println("A reunião requer multimidia? : Digite true ou false");
                    String multimidia = sc.nextLine();

                    List<Sala> salasDisponiveis = salasDisponiveis(blocos);
                    alocarSala(salasDisponiveis, localDateTime, Integer.parseInt(duracao), Integer.parseInt(qtdParticipantes), Boolean.valueOf(multimidia));
                }
                if (opcao == 4){

                    System.out.println("Digite um bloco que deseja agendar a reunião:");
                    String nomeBloco = sc.nextLine();

                    System.out.println("Digite uma data no formato: DD/MM/AAAA HH:MM");
                    String dataRecebida = sc.nextLine();
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    Date dt = df.parse(dataRecebida);
                    LocalDateTime localDateTime = new Timestamp(dt.getTime()).toLocalDateTime();

                    System.out.println("Digite a duração da reunião em horas:");
                    String duracao = sc.nextLine();

                    System.out.println("Digite a quantidade de participante na reunião:");
                    String qtdParticipantes = sc.nextLine();

                    System.out.println("A reunião requer multimidia? : Digite true ou false");
                    String multimidia = sc.nextLine();

                    alocarSalaPredioEspecifico(blocos,nomeBloco, localDateTime, Integer.parseInt(duracao), Integer.parseInt(qtdParticipantes), Boolean.valueOf(multimidia));
                }
                if(opcao == 5){
                    System.out.println("Digite um bloco da sala que deseja limpar");
                    String nomePredio = sc.nextLine();
                    System.out.println("Digite a sala que deseja limpar");
                    String numerosala = sc.nextLine();
                    limparSala(blocos,nomePredio, Integer.parseInt(numerosala));
                }

            }catch (NumberFormatException | ParseException e){
                System.out.println("Comando invalido");
            }
        }while (opcao != 0);
        sc.close();
    }



}
