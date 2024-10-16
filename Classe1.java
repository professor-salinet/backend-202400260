import java.util.*;

public class Classe1 {
    public static void main(String[] args) {
        Scanner scnInputUsuario = new Scanner(System.in);
        System.out.println("Olá! Bem vindo a calculadora de Java. Digite o primeiro número a ser calculado e tecle: \"Enter\".");
        int intInputUsuario1 = scnInputUsuario.nextInt();
        System.out.println("Digite o segundo número a ser calculado e tecle: \"Enter\".");
        int intInputUsuario2 = scnInputUsuario.nextInt();
        System.out.println("Digite o número da opção desejada e tecle: \"Enter\".");
        String[] opcoes = Classe2.mostrarOpcoes();

        for (int count = 0; count < opcoes.length; count++) {
            System.out.println("1 - " + opcoes[count]);
        }

        int resultadoDaSoma = Classe2.calcularSoma(intInputUsuario1, intInputUsuario2);
        System.out.println("O resultado da soma é: " + resultadoDaSoma);
        scnInputUsuario.close();
    }
}