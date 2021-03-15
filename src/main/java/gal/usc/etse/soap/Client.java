package gal.usc.etse.soap;

import gal.usc.etse.soap.calculator.Calculator;
import gal.usc.etse.soap.textanalyzer.TextAnalyzer;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class Client {
    public static void main(String[] args) throws MalformedURLException {
        //cargamos la calculadora
        URL calculatorWsdlURL = new URL("http://localhost:8080/calculator?wsdl");
        QName calculatorServiceName = new QName("http://calculator.soap.etse.usc.gal/", "Calculator");
        Service calculatorService = Service.create(calculatorWsdlURL, calculatorServiceName);
        Calculator calculator = calculatorService.getPort(Calculator.class);
        //cargamos el analizador de textos
        URL textAnalyzerURL = new URL("http://localhost:8080/textanalyzer?wsdl");
        QName textAnalyzerServiceName = new QName("http://textanalyzer.soap.etse.usc.gal/", "TextAnalyzer");
        Service textAnalyzerService = Service.create(textAnalyzerURL, textAnalyzerServiceName);
        TextAnalyzer textAnalyzer = textAnalyzerService.getPort(TextAnalyzer.class);


        long numCaracteres = textAnalyzer.contarCaracteres("hola buenas tardes");
        System.out.println(numCaracteres);

        int result = calculator.sum(1, 2);
        System.out.println(result);
    }
}
