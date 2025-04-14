public class HistoricoEstados {

    public static long contarRodadasAteRepeticao(int[] receita) {
        int n = receita.length;
        boolean[] visitado = new boolean[n];
        long resultado = 1;

        for (int i = 0; i < n; i++) {
            if (!visitado[i]) {
                int contador = 0;
                int atual = i;

                while (!visitado[atual]) {
                    visitado[atual] = true;
                    atual = receita[atual];
                    contador++;
                }

                resultado = mmc(resultado, contador);
            }
        }

        return resultado;
    }

    private static long mmc(long a, long b) {
        return a * (b / mdc(a, b));
    }

    private static long mdc(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
