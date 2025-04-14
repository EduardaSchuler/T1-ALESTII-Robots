public class HistoricoEstados {
    private int[] receita;
    private boolean[] visitados;
    private int quantidadePessoas;
    private long totalPassos;

    public HistoricoEstados(int[] receita) {
        this.receita = receita;
        this.quantidadePessoas = receita.length;
        this.visitados = new boolean[quantidadePessoas];
        this.totalPassos = 1;
        contaEstados();
    }

    private void contaEstados() {
        for (int pessoa = 0; pessoa < quantidadePessoas; pessoa++) {
            if (!visitados[pessoa]) {
                int tamanhoCiclo = 0;
                int atual = pessoa;

                while (!visitados[atual]) {
                    visitados[atual] = true;
                    atual = receita[atual];
                    tamanhoCiclo++;
                }

                totalPassos = calcularMMC(totalPassos, tamanhoCiclo);
            }
        }
    }

    private long calcularMMC(long a, long b) {
        return a * (b / calcularMDC(a, b));
    }

    private long calcularMDC(long a, long b) {
        while (b != 0) {
            long resto = a % b;
            a = b;
            b = resto;
        }
        return a;
    }

    public long getTotalPassos() {
        return totalPassos;
    }
}
