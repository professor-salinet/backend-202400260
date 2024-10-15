import java.util.*;

public class Classe1 {
    public static void main(String[] args) {
        Scanner scnInputUsuario = new Scanner(System.in);
        System.out.println("Olá! Bem vindo a calculadora de Java. Digite o primeiro número a ser somado e tecle: \"Enter\".");
        int intInputUsuario1 = scnInputUsuario.nextInt();
        System.out.println("Digite o segundo número a ser somado e tecle: \"Enter\".");
        int intInputUsuario2 = scnInputUsuario.nextInt();
        int resultadoDaSoma = Classe2.calcularSoma(intInputUsuario1, intInputUsuario2);
        System.out.println("O resultado da soma é: " + resultadoDaSoma);
        scnInputUsuario.close();
    }
}