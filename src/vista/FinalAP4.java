package vista;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import logica.Logica;

public class FinalAP4 {

    public static void main(String[] args) {

        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de datos que quiere que tenga el arraylist: "));
        Logica logica = new Logica();
        ArrayList<Integer> arr = logica.crearArrayList(cantidad);
        System.out.println("ArrayList generado: " + arr);

        int opcion;

        do {
            String menu = "Menu:\n"
                    + "1. Ordenamiento burbuja\n"
                    + "2. Ordenamiento por selección\n"
                    + "3. Quick sort\n"
                    + "4. Merge sort\n"
                    + "5. Imprimir arraylist\n"
                    + "0. Salir\n"
                    + "Selecciona una opción: ";

            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1:
                    long inicio = System.currentTimeMillis();
                    arr = logica.ordenamientoBurbuja(arr);
                    long fin = System.currentTimeMillis();
                    imprimirArraylist(arr);
                    long tiempoEjecucion = fin - inicio;
                    System.out.println("Tiempo de ejecución: " + tiempoEjecucion + " milisegundos");
                    break;
                case 2:
                    inicio = System.currentTimeMillis();
                    arr = logica.ordenamientoSeleccion(arr);
                    fin = System.currentTimeMillis();
                    imprimirArraylist(arr);
                    tiempoEjecucion = fin - inicio;
                    System.out.println("Tiempo de ejecución: " + tiempoEjecucion + " milisegundos");
                    break;
                case 3:
                    inicio = System.currentTimeMillis();
                    arr = logica.quickSort(arr);
                    fin = System.currentTimeMillis();
                    imprimirArraylist(arr);
                    tiempoEjecucion = fin - inicio;
                    System.out.println("Tiempo de ejecución: " + tiempoEjecucion + " milisegundos");
                    break;
                case 4:
                    inicio = System.currentTimeMillis();
                    arr = logica.mergeSort(arr);
                    fin = System.currentTimeMillis();
                    imprimirArraylist(arr);
                    tiempoEjecucion = fin - inicio;
                    System.out.println("Tiempo de ejecución: " + tiempoEjecucion + " milisegundos");
                    break;
                case 5:
                    imprimirArraylist(arr);
                    break;
                default:
            }
        } while (opcion != 0);

    }//CIERRE DEL MAIN

    public static void imprimirArraylist(ArrayList<Integer> arr) {

        StringBuilder mensaje = new StringBuilder("Elementos del ArrayList:\n");

        for (Integer elemento : arr) {
            mensaje.append(elemento).append("\n");
        }

        JTextArea textArea = new JTextArea(mensaje.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 400)); // Tamaño preferido ajustable
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JOptionPane.showMessageDialog(null, scrollPane, "ArrayList", JOptionPane.PLAIN_MESSAGE);

    }//CIERRE DEL METODO

    public static void imprimirPorConsola(ArrayList<Integer> arr) {

        System.out.println("Elementos del ArrayList:");
        for (Integer elemento : arr) {
            System.out.println(elemento);
        }

    }//CIERRE DEL METODO

}//CIERRE DE LA CLASE
