package com.durand.introduction;

import java.io.Console;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class prueba {



    public static void main(String[] args) {
        int[] numeros = { 1, 2, 3, 1, 1, 2, 3, 4, 2, 4, 412, 3, 12, 321, 12, 3, 213, 13, 213121, 1, 345, 12, 312, 3, 5424,
                314 };
        System.out.printf("El arreglo es: %s\n", Arrays.toString(numeros));
        HashMap<Integer, Integer> mapa = new HashMap<>();
        for (int x = 0; x < numeros.length; x++) {
            int numero = numeros[x];
            if (mapa.containsKey(numero)) {
                mapa.put(numero, mapa.get(numero) + 1);
            } else {
                mapa.put(numero, 1);
            }
        }
        int moda = 0, mayor = 0;
        for (HashMap.Entry<Integer, Integer> entry : mapa.entrySet()) {
            if (entry.getValue() > mayor) {
                mayor = entry.getValue();
                moda = entry.getKey();
            }
        }
        System.out.printf("La moda es %d porque se repite %d veces", moda, mayor);
    }

}
