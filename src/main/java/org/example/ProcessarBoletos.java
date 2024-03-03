package org.example;

import java.util.List;
import java.util.function.Function;

public class ProcessarBoletos {
    private Function<String, List<Boleto>> leituraRetorno;

    public ProcessarBoletos(Function<String, List<Boleto>> leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
 void proessar(String nomeArquivo){
var lista = leituraRetorno.apply("banco-brasil-1.csv");
     System.out.println(lista);
 }
}


