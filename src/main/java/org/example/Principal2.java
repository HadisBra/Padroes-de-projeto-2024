package org.example;

public class Principal2 {

        public static  void main(String[] args){


                var leituraRetorno =  new LeituraRetornoBradesco();
                final  var processarBoleto = new ProcesarBoleto(leituraRetorno);
                processarBoleto.processar("bradesco-1.csv");



        }
}
