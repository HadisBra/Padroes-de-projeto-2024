package org.example;

import java.util.List;
import java.util.function.Function;

public class ProcessarBoletos {
    private Function<String, List<Boleto>> leituraRetorno;

    public ProcessarBoletos(Function<String, List<Boleto>> leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
public void proessar(String nomeArquivo){
  List<Boleto>boletos=leituraRetorno.apply(nomeArquivo);
  for (Boleto boleto:boletos){
      System.out.println(boleto);
  }
 }

}
