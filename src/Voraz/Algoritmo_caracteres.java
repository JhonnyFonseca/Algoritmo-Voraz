
package Voraz;

import java.util.Scanner;

public class Algoritmo_caracteres {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String cadena;
        do {
            System.out.println("Inserte la cadena de caracteres que desea ordenar (solo letras, sin espacios):");
            cadena = entrada.nextLine().trim();
            if (!cadena.matches("[a-zA-Z]+")) {
                System.out.println("La cadena debe contener solo letras y no debe tener espacios.");
            }
        } while (!cadena.matches("[a-zA-Z]+"));

        cadena = cadena.toLowerCase();
        char[] letras = cadena.toCharArray();
        String orden = letras[0] + "";
        System.out.println(orden);

        for (int i = 1; i < letras.length; i++) {
            char letra = letras[i];
            if (letra >= orden.charAt(0)) {
                orden += letra;
            } else {
                orden = letra + orden;
            }
            System.out.println(orden);
        }
    }
}
