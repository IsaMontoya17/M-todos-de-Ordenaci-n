package logica;

import java.util.ArrayList;
import java.util.Random;

public class Logica {

    public ArrayList<Integer> crearArrayList(int cantidadNumeros) {
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < cantidadNumeros; i++) {
            int numeroAleatorio = rand.nextInt(200);
            listaNumeros.add(numeroAleatorio);
        }

        return listaNumeros;

    }//CIERRE DEL METODO

    public ArrayList<Integer> ordenamientoBurbuja(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    int aux = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, aux);
                }
            }
        }

        return arr;

    }//CIERRE DEL METODO

    public ArrayList<Integer> ordenamientoSeleccion(ArrayList<Integer> arr) {
        int menor = 100;
        for (Integer elemento : arr) {
            for (Integer elemento1 : arr) {
                if (elemento1 < menor) {
                    menor = elemento1;
                }
            }
            arr.set(0, menor);
        }
        return arr;

    }//CIERRE DEL METODO

    public ArrayList<Integer> quickSort(ArrayList<Integer> arr) {

        if (arr.size() <= 1) {
            return arr;
        } else {
            int aux = arr.get(0);
            ArrayList<Integer> menores = new ArrayList<>();
            ArrayList<Integer> iguales = new ArrayList<>();
            ArrayList<Integer> mayores = new ArrayList<>();

            for (Integer elemento : arr) {
                if (elemento < aux) {
                    menores.add(elemento);
                } else if (elemento == aux) {
                    iguales.add(elemento);
                } else {
                    mayores.add(elemento);
                }
            }

            ArrayList<Integer> resultado = new ArrayList<>();
            resultado.addAll(quickSort(menores));
            resultado.addAll(iguales);
            resultado.addAll(quickSort(mayores));

            return resultado;
        }

    }//CIERRE DEL METODO

    public ArrayList<Integer> mergeSort(ArrayList<Integer> arr) {
        int n = arr.size();
        if (n > 1) {
            int mitad = n / 2;

            ArrayList<Integer> mitadIzquierda = new ArrayList<>(arr.subList(0, mitad));
            ArrayList<Integer> mitadDerecha = new ArrayList<>(arr.subList(mitad, n));

            mitadIzquierda = mergeSort(mitadIzquierda);
            mitadDerecha = mergeSort(mitadDerecha);

            return merge(mitadIzquierda, mitadDerecha);
        }

        return arr;
        
    }

    private static ArrayList<Integer> merge(ArrayList<Integer> izquierda, ArrayList<Integer> derecha) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < izquierda.size() && j < derecha.size()) {
            if (izquierda.get(i) <= derecha.get(j)) {
                result.add(izquierda.get(i++));
            } else {
                result.add(derecha.get(j++));
            }
        }

        while (i < izquierda.size()) {
            result.add(izquierda.get(i++));
        }

        while (j < derecha.size()) {
            result.add(derecha.get(j++));
        }

        return result;
    }

}//CIERRE DE LA CLASE
