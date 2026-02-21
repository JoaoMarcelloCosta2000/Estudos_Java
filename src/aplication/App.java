package aplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap <String,Integer> resultado = new HashMap<>();

        System.out.print("Digite o caminho do arquivo a ser lido pelo programa: ");
        String path = sc.nextLine();

        try (BufferedReader bf = new BufferedReader(new FileReader(path))) { 

            String linha = bf.readLine();

            while (linha != null) {

                linha = linha.replace("\uFEFF", "");
                String[] registros = linha.split(";");

                String nome = registros[0];
                int votos = Integer.parseInt(registros[1]);

                if (resultado.containsKey(nome)) {
                    int votosAtuais = resultado.get(nome);
                    resultado.put(nome, votosAtuais + votos);
                } else {
                    resultado.put(nome, votos);
                }

                linha = bf.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String nome : resultado.keySet()) {
            System.out.println("Nome: " + nome + " - Votos: " + resultado.get(nome));
        }

        sc.close();
    }
}