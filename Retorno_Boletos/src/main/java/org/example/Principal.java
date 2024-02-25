package org.example;

import org.example.LeituraRetorno;
import org.example.LeituraRetornoBancoBrasil;
import org.example.ProcesarBoleto;

public class Principal {

public static  void main(String[] args){

 var leituraRetorno =  new LeituraRetornoBancoBrasil();
 final  var processarBoleto = new ProcesarBoleto(leituraRetorno);
 processarBoleto.processar("banco-brasil-1.csv");


}



}
