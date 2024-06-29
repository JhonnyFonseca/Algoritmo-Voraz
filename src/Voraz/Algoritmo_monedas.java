
package Voraz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Algoritmo_monedas {
    
    public static List <Integer> algoritmovoraz(int monto, int[] monedas){
        List<Integer> cambio = new ArrayList<>();
        
        for (int i = 0; i < monedas.length; i++) {
            while(monedas[i] <= monto && monto > 0){
                monto -= monedas[i];
                cambio.add(monedas[i]);
            }
        }
        
        if (monto != 0) {
            System.out.println("No se puede dar un cambio exacto");
        }
        
        return cambio;
    } 
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int mTotal, nElementos;
        int cuentacambio = 0;
        
        System.out.println("Digita el valor del cambio: ");
        mTotal = entrada.nextInt();
        
        if (mTotal <= 0) {
                for (int j = 0; j > mTotal; j++) {
                   System.out.println("Digita el valor del cambio: (el valor no puede ser negativo o vacio)"); 
                   mTotal = entrada.nextInt();
                }
            }
        
        System.out.println("Digita la cantidad de monedas disponibles: ");
        nElementos = entrada.nextInt();
        
        if (nElementos <= 0) {
                for (int j = 0; j > nElementos; j++) {
                   System.out.println("Digita la cantidad de monedas disponibles: (el valor no puede ser negativo o vacio)"); 
                   nElementos = entrada.nextInt();
                }
            }
        
        int[] monedasDisponibles = new int[nElementos];
        
        for (int i = 0; i < nElementos; i++) {
            System.out.println("Digita el valor de la moneda numero "+(i+1)+":");
            monedasDisponibles[i] = entrada.nextInt();
            if (monedasDisponibles[i] <= 0) {
                for (int j = 0; j > monedasDisponibles[i]; j++) {
                   System.out.println("Digita el valor de la moneda numero "+(i+1)+": (el valor no puede ser negativo o vacio)"); 
                   monedasDisponibles[i] = entrada.nextInt();
                }
            }
        }
        
        for (boolean ordenado = false; !ordenado;) {
            for (int i = 0; i < nElementos-1; i++) {
                if (monedasDisponibles[i] < monedasDisponibles[i+1]) {
                   int variableauxiliar =  monedasDisponibles[i];
                   monedasDisponibles[i] = monedasDisponibles[i+1];
                   monedasDisponibles[i+1] = variableauxiliar;
                   cuentacambio++;
                }
            }
            
            if (cuentacambio == 0) {
                ordenado = true;
            }
            
            cuentacambio = 0;
        }
        
        List<Integer> cambio = algoritmovoraz(mTotal, monedasDisponibles);
        System.out.println("Cambio de monedas: ");
        for (int moneda : cambio) {
            System.out.println(moneda + " ");
        }
    }

}


