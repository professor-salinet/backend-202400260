public class Classe3 {
    private static final String[] operadoresMatematicos = {"Soma", "Subtração", "Multiplicação", "Divisão"};

    public static String[] pegarOpcoes() {
        return operadoresMatematicos;
    }

    public static int somar(int numero1, int numero2) {
        return numero1 + numero2;
    }

    public static int subtrair(int numero1, int numero2) {
        return numero1 - numero2;
    }

    public static int multiplicar(int numero1, int numero2) {
        return numero1 * numero2;
    }

    public static int dividir(int numero1, int numero2) {
        return numero1 / numero2;
    }
}
