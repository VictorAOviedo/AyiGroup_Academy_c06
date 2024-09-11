import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;

public class EjercicioUno {

    public static void main(String[] args) {


        try {
            // Lectura de la cadena desde el teclado
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Introduce una cadena de texto:");
            String entrada = br.readLine();
            System.out.println("\n********************************");
            System.out.println("salida: " + entrada);
            System.out.println("********************************");



            // Crear un ArrayList para almacenar las palabras
            ArrayList<String> palabras = new ArrayList<>();

            // Crear un LinkedList para almacenar las palabras palíndromas
            LinkedList<String> palindromas = new LinkedList<>();




            // Utilizar BreakIterator para extraer las palabras
            BreakIterator bi = BreakIterator.getWordInstance(Locale.getDefault());
            bi.setText(entrada);

            int start = bi.first();
            for (int end = bi.next(); end != BreakIterator.DONE; start = end, end = bi.next()) {
                // Imprime solo las palabras, ignorando los espacios en blanco
                String palabra = entrada.substring(start, end).trim();
                if (!palabra.isEmpty()) { // Excluir espacios en blanco
                    palabras.add(palabra);
                }
            }

            System.out.println("Palabras extraídas:");
            for (String palabra : palabras) {
                System.out.println(palabra);
            }
            System.out.println("\n");
            System.out.println("ArrayList: " + palabras);
            System.out.println("********************************");


            // Verificar y mostrar las palabras que son palíndromas. Luego guardar la palabra en un LinkedList
            System.out.println("\nPalabras palíndromas:");
            for (String palabra : palabras) {
                if (esPalindroma(palabra)) {
                    System.out.println(palabra);
                    palindromas.add(palabra); // Guardar la palabra palíndroma en el LinkedList
                }
            }
            System.out.println("\nLinkedList: " + palindromas);
            System.out.println("\nCantidad de palabras Palindromas: " + palindromas.size());
            System.out.println("\nCantidad de palabras NO Palindromas: " + (palabras.size() - palindromas.size()));


            //Eliminar palabra Palindroma del ArrayList
            palabras.removeAll(palindromas);
            System.out.println("ArrayList sin palabras Palindromas: " + palabras);

            // Mostrar el tamaño del ArrayList sin usar size()
            int contador = 0;
            for (String palabra : palabras) {
                contador++;
            }
            System.out.println("\nTamaño del ArrayList (sin usar size()): " + contador);

            //Limpiar ArrayList
            palabras.clear();
            System.out.println("ArrayList limpio: " + palabras);


            // Mostrar el tamaño del LinkedList sin usar size()
            int contadorLinkedList = 0;
            for (String palabra : palindromas) {
                contadorLinkedList++;
            }
            System.out.println("\nTamaño del LinkedList (sin usar size()): " + contadorLinkedList);

            //Limpiar LinkedList
            palindromas.clear();
            System.out.println("LinkedList limpio: " + palabras);


        }catch (Exception e){
            System.out.println("error Exception");
        }

    }

    // Método para verificar si una palabra es palíndroma
    public static boolean esPalindroma(String palabra) {
        int inicio = 0;
        int fin = palabra.length() - 1;
        while (inicio < fin) {
            if (palabra.charAt(inicio) != palabra.charAt(fin)) {
                return false;
            }
            inicio++;
            fin--;
        }
        return true;
    }


}
