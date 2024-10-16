public class Classe3 {
    private static final String[] operadoresMatematicos = {"Soma", "Subtração", "Multiplicação", "Divisão"};

    public static String[] pegarOpcoes() {
        return operadoresMatematicos;
    }

    public static String processarDados(int inputUsuario1, int inputUsuario2, int opcaoEscolhida) {
        int resultado;
        switch (opcaoEscolhida) {
            case 0:
                resultado = somar(inputUsuario1, inputUsuario2);
                break;

            case 1:
                resultado = subtrair(inputUsuario1, inputUsuario2);
                break;

            case 2:
                resultado = multiplicar(inputUsuario1, inputUsuario2);
                break;

            case 3:
                resultado = dividir(inputUsuario1, inputUsuario2);
                break;

            default:
                resultado = 0;
                break;
        }
        return String.valueOf(resultado);
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
