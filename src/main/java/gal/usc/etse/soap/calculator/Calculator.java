package gal.usc.etse.soap.calculator;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface Calculator {
    //--operaciones con un número--
    //->Raiz Cuadrada
    /**
     * Calcula la raíz cuadrada de un número
     * @param radicando es el número del que queremos calcular la raíz cuadrada
     * @return el resultado de la raíz cuadrada
     */
    @WebMethod(operationName = "raiz_cuadrada")
    @WebResult(name = "resultado")
    double raizCuadrada(@WebParam(name = "radicando") int radicando);
    //->Logaritmo Neperiano
    /**
     * Calcula el logaritmo neperiano de un número
     * @param argumento es el número del cual queremos calcular el ln
     * @return el logaritmo correspondiente al argumento
     */
    @WebMethod(operationName = "logaritmo_neperiano")
    @WebResult(name = "resultado")
    double logaritmoNeperiano(@WebParam(name = "argumento") int argumento);
    //--operaciones con dos números--
    //->Suma
    /**
     * Suma los dos sumandos que se pasen por parámetros
     * @param sum1 el primer sumando
     * @param sum2 el segundo sumando
     * @return la suma de los dos sumandos
     */
    @WebMethod(operationName = "suma")
    @WebResult(name = "resultado")
    int sum(@WebParam(name = "sumando1") int sum1, @WebParam(name = "sumando2") int sum2);
    //->Resta
    /**
     * Resta dos números que se le pasen por parámetros
     * @param minuendo número al que se le resta una cierta cantidad
     * @param sustraendo cantidad que se quita
     * @return el minuendo menos el sustraendo
     */
    @WebMethod(operationName = "resta")
    @WebResult(name = "diferencia")
    int resta(@WebParam(name = "minuendo") int minuendo, @WebParam(name = "sustraendo") int sustraendo);
    //->Multiplicación
    /**
     * Devuelve el producto de los dos alrgumentos
     * @param mult1 el primer argumento a multiplicar
     * @param mult2 el primer argumento a multiplicar
     * @return el resultado de la multiplicación
     */
    @WebMethod(operationName = "multiplicacion")
    @WebResult(name = "resultado")
    int multiplicacion(@WebParam(name = "multiplicando1") int mult1, @WebParam(name = "multiplicando2") int mult2);
    //->División
    /**
     * Devuelve la división del dividendo por el divisor
     * @param dividendo número que se dividira en grupos del tamaño del divisor
     * @param divisor tamaño de los grupos en los que se dividirá el dividendo
     * @return el resultado de la división
     */
    @WebMethod(operationName = "division")
    @WebResult(name = "cociente")
    double division(@WebParam(name = "dividendo") int dividendo, @WebParam(name = "divisor") int divisor);
    //->Potencia
    /**
     * Calcula la potencia de una base por un exponente determinado
     * @param base el número que queremos exponenciar
     * @param exponente número de veces por las que se multiplicará el número por sí mismo
     * @return la potencia
     */
    @WebMethod(operationName = "potencia")
    @WebResult(name = "resultado")
    double potencia(@WebParam(name = "base") int base, @WebParam(name = "exponente") int exponente);


    //--operaciones con una lista de números--
    //->Máximo
    /**
     * Devuelve el máximo valor en una lista
     * @param numeros lista de números
     * @return el valor más alto de la lista
     */
    @WebMethod(operationName = "maximo_lista")
    @WebResult(name = "resultado")
    int maximo(@WebParam(name = "lista_numeros") int[] numeros);
    //->Mínimo
    /**
     * Devuelve el valor mínimo en una lista
     * @param numeros lista de números
     * @return el valor más bajo de la lista
     */
    @WebMethod(operationName = "minimo_lista")
    @WebResult(name = "resultado")
    int minimo(@WebParam(name = "lista_numeros") int[] numeros);
    //->Media
    /**
     * Devuelve el valor medio de una lista
     * @param numeros lista de números
     * @return la media de la lista
     */
    @WebMethod(operationName = "media_lista")
    @WebResult(name = "resultado")
    double media(@WebParam(name = "lista_numeros") int[] numeros);
    //->Mediana
    /**
     * Devuelve la mediana de un conjunto de datos
     * @param numeros lista de números
     * @return la mediana de la lista de números
     */
    @WebMethod(operationName = "mediana_lista")
    @WebResult(name = "resultado")
    double mediana(@WebParam(name = "lista_numeros") int[] numeros);
    //->Moda
    /**
     * Devuelve la moda de un conjunto de números
     * @param numeros lista de números
     * @return la moda o si no el primer valor
     */
    @WebMethod(operationName = "moda_lista")
    @WebResult(name = "resultado")
    int moda(@WebParam(name = "lista_numeros") int[] numeros);
    //->Desviacion típica
    /**
     * Calcula la desviación típica de un conjunto de números
     * @param numeros lista de números
     * @return la desviación típica de la lista
     */
    @WebMethod(operationName = "desviacion_tipica_lista")
    @WebResult(name = "resultado")
    double desviacionTipica(@WebParam(name = "lista_numeros") int[] numeros);
}
