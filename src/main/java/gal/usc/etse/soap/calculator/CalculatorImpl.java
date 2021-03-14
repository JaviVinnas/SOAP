package gal.usc.etse.soap.calculator;

import javax.jws.WebService;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@WebService(
        endpointInterface = "gal.usc.etse.soap.calculator.Calculator",
        serviceName = "Calculator"
)
public class CalculatorImpl implements Calculator {


    /**
     * Calcula la raíz cuadrada de un número
     *
     * @param radicando es el número del que queremos calcular la raíz cuadrada
     * @return el resultado de la raíz cuadrada
     */
    @Override
    public double raizCuadrada(int radicando) {
        return Math.sqrt(radicando);
    }

    /**
     * Calcula el logaritmo neperiano de un número
     *
     * @param argumento es el número del cual queremos calcular el ln
     * @return el logaritmo correspondiente al argumento
     */
    @Override
    public double logaritmoNeperiano(int argumento) {
        return Math.log(argumento);
    }

    /**
     * Suma los dos sumandos que se pasen por parámetros
     *
     * @param sum1 el primer sumando
     * @param sum2 el segundo sumando
     * @return la suma de los dos sumandos
     */
    @Override
    public int sum(int sum1, int sum2) {
        return sum1 + sum2;
    }

    /**
     * Resta dos números que se le pasen por parámetros
     *
     * @param minuendo   número al que se le resta una cierta cantidad
     * @param sustraendo cantidad que se quita
     * @return el minuendo menos el sustraendo
     */
    @Override
    public int resta(int minuendo, int sustraendo) {
        return minuendo - sustraendo;
    }

    /**
     * Devuelve el producto de los dos alrgumentos
     *
     * @param mult1 el primer argumento a multiplicar
     * @param mult2 el primer argumento a multiplicar
     * @return el resultado de la multiplicación
     */
    @Override
    public int multiplicacion(int mult1, int mult2) {
        return mult1 * mult2;
    }

    /**
     * Devuelve la división del dividendo por el divisor
     *
     * @param dividendo número que se dividira en grupos del tamaño del divisor
     * @param divisor   tamaño de los grupos en los que se dividirá el dividendo
     * @return el resultado de la división
     */
    @Override
    public double division(int dividendo, int divisor) {
        return (double) dividendo / divisor;
    }

    /**
     * Calcula la potencia de una base por un exponente determinado
     *
     * @param base      el número que queremos exponenciar
     * @param exponente número de veces por las que se multiplicará el número por sí mismo
     * @return la potencia
     */
    @Override
    public double potencia(int base, int exponente) {
        return Math.pow(base, exponente);
    }

    /**
     * Devuelve el máximo valor en una lista
     *
     * @param numeros lista de números
     * @return el valor más alto de la lista
     */
    @Override
    public int maximo(int[] numeros) {
        return Arrays.stream(numeros).max().orElse(-1);
    }

    /**
     * Devuelve el valor mínimo en una lista
     *
     * @param numeros lista de números
     * @return el valor más bajo de la lista
     */
    @Override
    public int minimo(int[] numeros) {
        return Arrays.stream(numeros).min().orElse(-1);
    }

    /**
     * Devuelve el valor medio de una lista
     *
     * @param numeros lista de números
     * @return la media de la lista
     */
    @Override
    public double media(int[] numeros) {
        return Arrays.stream(numeros).average().orElse(-1.0);
    }

    /**
     * Devuelve la mediana de un conjunto de datos
     *
     * @param numeros lista de números
     * @return la mediana de la lista de números
     */
    @Override
    public double mediana(int[] numeros) {
        return Arrays.stream(numeros).sorted()
                //descartamos por el principio
                .skip((numeros.length-1)/2)
                //descartamos por el final
                .limit(2- numeros.length%2)
                .average().orElse(-1.0);
    }

    /**
     * Devuelve la moda de un conjunto de números
     *
     * @param numeros lista de números
     * @return la moda o si no el primer valor
     */
    @Override
    public int moda(int[] numeros) {
        return Arrays.stream(numeros)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(-1);
    }

    /**
     * Calcula la desviación típica de un conjunto de números
     *
     * @param numeros lista de números
     * @return la desviación típica de la lista
     */
    @Override
    public double desviacionTipica(int[] numeros) {
        double media = Arrays.stream(numeros).average().orElse(-1.0);
        return Math.sqrt(Arrays.stream(numeros).mapToDouble(num -> (double) num).map( num -> Math.pow(num-media, 2)).sum() / numeros.length);
    }
}
