package org.example;

import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LeituraRetornoBancoBrasil implements LeituraRetorno {
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override @SneakyThrows
    public List<Boleto> lerArquivo(String nomeArquivo){
        System.out.println("Lendo arquivo BB !!!");
        var linhas = Files.readAllLines(Path.of(nomeArquivo));
        var boletos = new ArrayList<Boleto>();

        for (String linha : linhas) {
        String[] vetor = linha.split(";");
        var boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetor[0]));
        boleto.setCodBanco(vetor[1]);
        boleto.setDataVencimento(LocalDate.parse(vetor[2], FORMATO_DATA));
        boleto.setDataPagamento(LocalDate.parse(vetor[3], FORMATO_DATA).atStartOfDay());

        // incluir boletos
        boletos.add(boleto);

    }

    return boletos;
    }
}
