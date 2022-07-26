package balanced;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Balanced {
    private static final Logger log = Logger.getLogger("Balanced");
    
    public static void main(String[] args) {
        List<String> test1 = Arrays.asList("]", "(");
        boolean respTest1 = validarCadena(test1);
        log.info(String.format("resultado test1::: %s", respTest1)); //FALSE
        
        List<String> test2 = Arrays.asList("(", "{", "[", "]", "}", ")");
        boolean respTest2 = validarCadena(test2);
        log.info(String.format("resultado test2::: %s", respTest2)); //TRUE
        
        List<String> test3 = Arrays.asList("(", "{", "[", ")", "}", ")");
        boolean respTest3 = validarCadena(test3);
        log.info(String.format("resultado test3::: %s", respTest3)); //FALSE
    
        List<String> test4 = Arrays.asList("**", "{", "[", ")", "}", ")");
        boolean respTest4 = validarCadena(test4);
        log.info(String.format("resultado test4::: %s", respTest4)); //FALSE
    
        List<String> test5 = Arrays.asList("{", "[", "]", "}");
        boolean respTest5 = validarCadena(test5);
        log.info(String.format("resultado test5::: %s", respTest5)); //TRUE
    }
    
    private static boolean validarCadena(List<String> cadena) {
        /*
        Se crea un mapa con los pares de símbolos Key = apertura, Value = cierre
         */
        Map<String, String> dictCombinaciones = new HashMap<>();
        dictCombinaciones.put("(", ")");
        dictCombinaciones.put("{", "}");
        dictCombinaciones.put("[", "]");
        
        if (cadena.size() % 2 != 0) {
            return false;
        }
        /*
          Se crea un objeto de tipo Cola que únicamente almacena el elemento de cierre, ), }, ] asociado al
          elemento encontrado, p.ej, si el primer elemento es {, result guardará }
         */
        Deque<String> result = new ArrayDeque<>();
        for (String simbolo : cadena) {
            /**
             * La comparación se hace con el Key del diccionario y la cola almacena el Value.
             */
            if (dictCombinaciones.containsKey(simbolo)) {
                /**
                 * Guarda el value, o elemento de cierre en la Cola.
                 */
                result.push(dictCombinaciones.get(simbolo));
                /*
                  Se retorna false si el elemento actual no existe en el diccionario.
                  La instrucción "pop" quita el primer elemento de la cola y lo compara con el elemento actual.
                 */
            } else if (result.isEmpty() || ! result.pop().equals(simbolo)) {
                return false;
            }
        }
        return result.isEmpty();
    }
}
