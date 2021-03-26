package gal.usc.etse.soap;

import gal.usc.etse.soap.calculator.Calculator;
import gal.usc.etse.soap.textanalyzer.TextAnalyzer;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Client {

    public static void main(String[] args) {
        try {
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
            TimeUnit.SECONDS.sleep(2);


            //empezamos el bucle
            Scanner scanner = new Scanner(System.in);
            int num1, num2;
            int[] arrayInts;
            String texto, palabra1, palabra2;
            boolean salir = false;

            while (!salir) {
                System.out.println("__MENU_PRINCIPAL__");
                System.out.println("[[Escoge de entre las opciones propuestas]]");
                System.out.println("a) Calculadora -> operaciones con un número");
                System.out.println("b) Calculadora -> operaciones con dos números");
                System.out.println("c) Calculadora -> operaciones con una lista de números");
                System.out.println("d) Analizador de textos -> propiedades de un texto");
                System.out.println("e) Analizador de textos -> buscar ocurrencias de una palabra en un texto");
                System.out.println("f) Analizador de textos -> sustituir ocurrencias de una palabra por otra en un texto");
                System.out.println("S) Salir");
                String op = scanner.nextLine();
                switch (op) {
                    case "a":
                        System.out.print("Introduce un número entero: ");
                        num1 = scanner.nextInt();
                        System.out.println("*) La raíz cuadrada de " + num1 + " es " +calculator.raizCuadrada(num1));
                        System.out.println("*) El logaritmo neperiano de " + num1 + " es " + calculator.logaritmoNeperiano(num1));
                        System.out.println();
                        scanner.nextLine();
                        break;
                    case "b":
                        System.out.print("Introduce un número entero: ");
                        num1 = scanner.nextInt();
                        System.out.print("Introduce otro número entero: ");
                        num2 = scanner.nextInt();
                        System.out.println("*) La suma de " + num1 + " más " + num2 + " es " + calculator.sum(num1, num2));
                        System.out.println("*) La resta de " + num1 + " menos " + num2 + " es " + calculator.resta(num1, num2));
                        System.out.println("*) La multiplicación de " + num1 + " por " + num2 + " es " + calculator.multiplicacion(num1, num2));
                        System.out.println("*) La división de " + num1 + " entre " + num2 + " es " + calculator.division(num1, num2));
                        System.out.println("*) La potencia de " + num1 + " elevado a " + num2 + " es " + calculator.potencia(num1, num2));
                        System.out.println();
                        scanner.nextLine();
                        break;
                    case "c":
                        System.out.print("Introduce una lista de enteros separados por comas (por ejemplo '3,57,-6' sin las comillas simples): ");
                        try{
                            texto = scanner.next(Pattern.compile("(-?[0-9]*,)*-?[0-9]+"));
                            arrayInts = Arrays.stream(texto.split(",")).mapToInt(Integer::parseInt).toArray();
                            System.out.println("*) El máximo de [" + texto + "] es " + calculator.maximo(arrayInts));
                            System.out.println("*) El mínimo de [" + texto + "] es " + calculator.minimo(arrayInts));
                            System.out.println("*) La media de [" + texto + "] es " + calculator.media(arrayInts));
                            System.out.println("*) La mediana de [" + texto + "] es " + calculator.mediana(arrayInts));
                            System.out.println("*) La moda de [" + texto + "] es " + calculator.moda(arrayInts));
                            System.out.println("*) La desviación típica de [" + texto + "] es " + calculator.desviacionTipica(arrayInts));
                        }catch (PatternSyntaxException badArraySyntax){
                            System.out.println("El array de ints introducido no es válido");
                        }finally {
                            System.out.println();
                            scanner.nextLine();
                        }
                        break;
                    case "d":
                        System.out.print("Introduce un texto (sin intros): ");
                        texto = scanner.nextLine();
                        System.out.println("Número de palabras: " + textAnalyzer.contarPalabras(texto));
                        System.out.println("Número de caracteres: " + textAnalyzer.contarCaracteres(texto));
                        System.out.println("Número de frases: " + textAnalyzer.contarFrases(texto));
                        System.out.println("Palabra más usada: " + textAnalyzer.palabraMasUsada(texto));
                        System.out.println("Palabra menos usada: " + textAnalyzer.palabraMenosUsada(texto));
                        break;
                    case "e":
                        System.out.print("Introduce un texto (sin intros): ");
                        texto = scanner.nextLine();
                        System.out.print("Introduce la palabra que quieras buscar en el texto: ");
                        palabra1 = scanner.nextLine();
                        System.out.println("Hay " + textAnalyzer.contarAparicionesPalabra(texto, palabra1) + " apariciones de " + palabra1 + " en el texto.");
                        break;
                    case "f":
                        System.out.print("Introduce un texto (sin intros): ");
                        texto = scanner.nextLine();
                        System.out.print("Introduce la palabra que reemplazar en el texto: ");
                        palabra1 = scanner.nextLine();
                        System.out.print("Introduce la palabra por la que la quieras reemplazar: ");
                        palabra2 = scanner.nextLine();
                        System.out.println("El texto resultante es: " + textAnalyzer.reemplazarPalabra(texto, palabra1, palabra2));
                        break;
                    case "S":
                        System.out.println("Saliendo...");
                        salir = true;
                        break;
                }

                System.out.println("------------------------------------------------------------------------------------------");
            }

        } catch (MalformedURLException | InterruptedException ex) {
            ex.printStackTrace();
        }


    }
}
