package gal.usc.etse.soap;

import gal.usc.etse.soap.calculator.Calculator;
import gal.usc.etse.soap.calculator.CalculatorImpl;
import gal.usc.etse.soap.textanalyzer.TextAnalyzer;
import gal.usc.etse.soap.textanalyzer.TextAnalyzerImpl;

import javax.xml.ws.Endpoint;

public class Server {
    public static void main(String[] args) {
        //publicamos la calculadora
        Calculator calculator = new CalculatorImpl();
        String calculatorAddress = "http://localhost:8080/calculator";
        Endpoint.publish(calculatorAddress, calculator);
        //publicamos el analizador de textanalyzer
        TextAnalyzer textAnalyzer = new TextAnalyzerImpl();
        String textAnalyzerAddress = "http://localhost:8080/textanalyzer";
        Endpoint.publish(textAnalyzerAddress,textAnalyzer);

    }
}
