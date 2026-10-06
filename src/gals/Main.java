package gals;

import java.io.StringReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código:");
        String codigo = scanner.nextLine();
        // tem que ser em uma so linha ex: A = 10; B = A + 11; Show(B);
        // Resultado: 101 (decimal: 5)

        try {
            Lexico lexico = new Lexico(new StringReader(codigo));
            Sintatico sintatico = new Sintatico();
            Semantico semantico = new Semantico();

            sintatico.parse(lexico, semantico);

            System.out.println("Execução finalizada.");

        } catch (Exception e) {
            System.out.println("Erro durante execução: " + e.getMessage());
        }

        scanner.close();
    }
}