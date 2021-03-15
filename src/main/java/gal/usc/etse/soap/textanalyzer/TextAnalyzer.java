package gal.usc.etse.soap.textanalyzer;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface TextAnalyzer {
    //--solo el texto como argumento---
    //->Contar palabras
    /**
     * Cuenta el número de palabras del texto
     * @param texto el texto del que contar palabras
     * @return el número de palabras
     */
    @WebMethod(operationName = "contar_palabras")
    @WebResult(name = "numero_palabras")
    long contarPalabras(@WebParam(name = "texto") String texto);
    //->Contar caracteres (todos)
    /**
     * Cuenta caracteres de un texto incluyendo espacios y signos de puntuación
     * @param texto el texto del que contar caracteres
     * @return el número de caracteres del texto
     */
    @WebMethod(operationName = "contar_caracteres")
    @WebResult(name = "numero_caracteres")
    long contarCaracteres(@WebParam(name = "texto") String texto);
    //->Contar frases
    /**
     * Cuenta el número de frases de un texto
     * @param texto del que contar frases
     * @return el número de frases del texto
     */
    @WebMethod(operationName = "contar_frases")
    @WebResult(name = "numero_frases")
    long contarFrases(@WebParam(name = "texto") String texto);
    //->Contar palabra más usada
    /**
     * Devuelve la palabra que se repita más en un texto
     * @param texto el texto donde buscar las palabras
     * @return la palabra en cuestión
     */
    @WebMethod(operationName = "obtener_palabra_mas_usada")
    @WebResult(name = "palabra_mas_usada")
    String palabraMasUsada(@WebParam(name = "texto") String texto);
    //->Contar palabra menos usada
    /**
     * Devuelve la palabra menos usada en un texto
     * @param texto el texto donde buscar las palabras
     * @return la palabra menos usada
     */
    @WebMethod(operationName = "obtener_palabra_menos_usada")
    @WebResult(name = "palabra_menos_usada")
    String palabraMenosUsada(@WebParam(name = "texto") String texto);
    //--el texto y un argumento más--
    //->Contar apariciones de una palabra
    /**
     * Cuenta el número de veces que aparece una palabra en el texto
     * @param texto texto del que contar palabras
     * @param palabra palabra que se quiere contar
     * @return el número de veces que se repite una palabra
     */
    @WebMethod(operationName = "contar_apariciones_palabra")
    @WebResult(name = "numero_apariciones_palabra")
    long contarAparicionesPalabra(@WebParam(name = "texto") String texto, @WebParam(name = "palabra") String palabra);
    //--el texto y dos parámetros--
    //->Reemplazar palabra
    /**
     * Cambia una palabra en un texto por otra
     * @param texto el texto que alterar
     * @param objetivo la palabra que se desea reemplazar (solo una palabra, no varias y sin espacios)
     * @param reemplazo la palabra que será el reemplazo (solo una palabra, no varias y sin espacios)
     * @return el texto alterado
     */
    @WebMethod(operationName = "reemplazar_palabra")
    @WebResult(name = "texto_con_la_palabra_reemplazada")
    String reemplazarPalabra(@WebParam(name = "texto") String texto, @WebParam(name = "objetivo") String objetivo, @WebParam(name = "reemplazo") String reemplazo);

}
