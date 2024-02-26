package org.example;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class LeituraRetornoBradesco implements LeituraRetorno {
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    @Override
    @SneakyThrows
    public List<Boleto> lerArquivo(String nomeArquivo) {
        System.out.println("Lendo arquivo Bradesco !!!");
        var linhas = Files.readAllLines(Path.of(nomeArquivo));
        var boletos = new ArrayList<Boleto>();

        for (String linha : linhas) {
            String[] vetor = linha.split(";");

            if (vetor.length < 4) {
                // Verifique se há dados suficientes na linha
                // Caso contrário, pule para a próxima linha
                continue;
            }

            var boleto = new Boleto();
            boleto.setId(Integer.parseInt(vetor[0]));
            boleto.setCodBanco(vetor[1]);

            try {

                boleto.setDataVencimento(LocalDate.parse(vetor[4], FORMATO_DATA));
                boleto.setDataPagamento(LocalDateTime.parse(vetor[5], FORMATO_DATA_HORA));
            } catch (DateTimeParseException e) {
                // Se ocorrer um erro ao analisar a data, registre o problema e pule para a próxima linha
                System.err.println("Erro ao analisar data na linha: " + linha);
                e.printStackTrace();
                continue;
            }

            // incluir boletos
            boletos.add(boleto);
        }

        return boletos;
    }
}
