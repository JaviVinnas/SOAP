package gal.usc.etse.soap.textos;


import javax.jws.WebService;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@WebService(endpointInterface = "gal.usc.etse.soap.textos.TextAnalyzer", serviceName = "TextAnalyzer")
public class TextAnalyzerImpl implements TextAnalyzer {
    /**
     * Cuenta el número de palabras del texto
     *
     * @param texto el texto del que contar palabras
     * @return el número de palabras
     */
    @Override
    public long contarPalabras(String texto) {
        //quitamos el espacio del principio y el final
        return Arrays.stream(texto.strip().trim().split(" ")).count();
    }

    /**
     * Cuenta caracteres de un texto incluyendo espacios y signos de puntuación
     *
     * @param texto el texto del que contar caracteres
     * @return el número de caracteres del texto
     */
    @Override
    public long contarCaracteres(String texto) {
        return Arrays.stream(texto.split("")).count();
    }

    /**
     * Cuenta el número de frases de un texto
     *
     * @param texto del que contar frases
     * @return el número de frases del texto
     */
    @Override
    public long contarFrases(String texto) {
        return Arrays.stream(texto.strip().trim().split("\\.")).count();
    }

    /**
     * Devuelve la palabra que se repita más en un texto
     *
     * @param texto el texto donde buscar las palabras
     * @return la palabra en cuestión
     */
    @Override
    public String palabraMasUsada(String texto) {
        return Arrays.stream(texto.strip().trim().split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    /**
     * Devuelve la palabra menos usada en un texto
     *
     * @param texto el texto donde buscar las palabras
     * @return la palabra menos usada
     */
    @Override
    public String palabraMenosUsada(String texto) {
        return Arrays.stream(texto.strip().trim().split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    /**
     * Cuenta el número de veces que aparece una palabra en el texto
     *
     * @param texto   texto del que contar palabras
     * @param palabra palabra que se quiere contar
     * @return el número de veces que se repite una palabra
     */
    @Override
    public long contarAparicionesPalabra(String texto, String palabra) {
        return Arrays.stream(texto.strip().trim().split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .getOrDefault(palabra, -1L);
    }

    /**
     * Cambia una palabra en un texto por otra
     *
     * @param texto     el texto que alterar
     * @param objetivo  la palabra que se desea reemplazar (solo una palabra, no varias y sin espacios)
     * @param reemplazo la palabra que será el reemplazo (solo una palabra, no varias y sin espacios)
     * @return el texto alterado
     */
    @Override
    public String reemplazarPalabra(String texto, String objetivo, String reemplazo) {
        final String fixedObjetivo = objetivo.strip().trim();
        final String fixedreemplazo = reemplazo.strip().trim();
        return Arrays.stream(texto.strip().trim().split(" "))
                .map(palabra -> palabra.strip().trim().equals(fixedObjetivo) ? fixedreemplazo : palabra)
                .reduce("", String::concat);
    }
}
