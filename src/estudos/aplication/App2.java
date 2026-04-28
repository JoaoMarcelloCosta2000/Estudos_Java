package estudos.aplication;

import java.util.ArrayList;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        int numeros[] = {29,19,71,01,43,21,12};

        int temp;

        for (int i = 0; i < numeros.length - 1; i++){
            for (int j = 0; j < numeros.length -1; j++){
                if (numeros[j] > numeros[j+1]){
                    temp = numeros[j];
                    numeros[j] = numeros[j+1];
                    numeros[j+1] = temp;
                }
            }
        }

        for (int numero : numeros){
            System.out.println(numero);
        }
               
    }   
}
