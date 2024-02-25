package org.example;

import lombok.Data;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Setter
public class ProcesarBoleto {
 private LeituraRetorno leituraRetorno;

    public ProcesarBoleto(LeituraRetornoBancoBrasil leituraRetorno) {

        this.leituraRetorno = leituraRetorno;
    }
    public ProcesarBoleto(LeituraRetornoBradesco leituraRetorno) {

        this.leituraRetorno = leituraRetorno;
    }

    public void processar(String nomeArquivo) {
        if (nomeArquivo.contains("banco-brasil-1.csv")) {
            var Lista = leituraRetorno.lerArquivo("banco-brasil-1.csv");
            System.out.println(Lista);

        }else if (nomeArquivo.contains("bradesco-1.csv")){
            var Lista = leituraRetorno.lerArquivo("bradesco-1.csv");
            System.out.println(Lista);
        }

    }

}
