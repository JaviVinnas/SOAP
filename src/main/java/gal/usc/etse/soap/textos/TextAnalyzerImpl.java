package gal.usc.etse.soap.textos;


import javax.jws.WebService;

@WebService(endpointInterface = "gal.usc.etse.soap.textos.TextAnalyzer", serviceName = "Calculator")
public class TextAnalyzerImpl implements TextAnalyzer{
    /**
     * Cuenta el número de palabras del texto
     *
     * @param texto el texto del que contar palabras
     * @return el número de palabras
     */
    @Override
    public int contarPalabras(String texto) {
        return 0;
    }

    /**
     * Cuenta caracteres de un texto incluyendo espacios y signos de puntuación
     *
     * @param texto el texto del que contar caracteres
     * @return el número de caracteres del texto
     */
    @Override
    public int contarCaracteres(String texto) {
        return 0;
    }

    /**
     * Cuenta el número de frases de un texto
     *
     * @param texto del que contar frases
     * @return el número de frases del texto
     */
    @Override
    public int contarFrases(String texto) {
        return 0;
    }

    /**
     * Devuelve la palabra que se repita más en un texto
     *
     * @param texto el texto donde buscar las palabras
     * @return la palabra en cuestión
     */
    @Override
    public String palabraMasUsada(String texto) {
        return null;
    }

    /**
     * Devuelve la palabra menos usada en un texto
     *
     * @param texto el texto donde buscar las palabras
     * @return la palabra menos usada
     */
    @Override
    public String palabraMenosUsada(String texto) {
        return null;
    }

    /**
     * Cuenta el número de veces que aparece una palabra en el texto
     *
     * @param texto   texto del que contar palabras
     * @param palabra palabra que se quiere contar
     * @return el número de veces que se repite una palabra
     */
    @Override
    public int contarAparicionesPalabra(String texto, String palabra) {
        return 0;
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
        return null;
    }
}
