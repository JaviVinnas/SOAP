package gal.usc.etse.soap.calculator;

import javax.jws.WebService;
import java.util.Arrays;

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
    public int raizCuadrada(int radicando) {
        return 0;
    }

    /**
     * Calcula el logaritmo neperiano de un número
     *
     * @param argumento es el número del cual queremos calcular el ln
     * @return el logaritmo correspondiente al argumento
     */
    @Override
    public int logaritmoNeperiano(int argumento) {
        return 0;
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
        return 0;
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
        return 0;
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
        return 0;
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
        return 0;
    }

    /**
     * Calcula la potencia de una base por un exponente determinado
     *
     * @param base      el número que queremos exponenciar
     * @param exponente número de veces por las que se multiplicará el número por sí mismo
     * @return la potencia
     */
    @Override
    public int potencia(int base, int exponente) {
        return 0;
    }

    /**
     * Devuelve el máximo valor en una lista
     *
     * @param numeros lista de números
     * @return el valor más alto de la lista
     */
    @Override
    public int maximo(int[] numeros) {
        return 0;
    }

    /**
     * Devuelve el valor mínimo en una lista
     *
     * @param numeros lista de números
     * @return el valor más bajo de la lista
     */
    @Override
    public int minimo(int[] numeros) {
        return 0;
    }

    /**
     * Devuelve el valor medio de una lista
     *
     * @param numeros lista de números
     * @return la media de la lista
     */
    @Override
    public double media(int[] numeros) {
        return 0;
    }

    /**
     * Devuelve la mediana de un conjunto de datos
     *
     * @param numeros lista de números
     * @return la mediana de la lista de números
     */
    @Override
    public int mediana(int[] numeros) {
        return 0;
    }

    /**
     * Devuelve la moda de un conjunto de números
     *
     * @param numeros lista de números
     * @return la moda o si no el primer valor
     */
    @Override
    public int moda(int[] numeros) {
        return 0;
    }

    /**
     * Calcula la desviación típica de un conjunto de números
     *
     * @param numeros lista de números
     * @return la desviación típica de la lista
     */
    @Override
    public double desviacionTipica(int[] numeros) {
        return 0;
    }
}
