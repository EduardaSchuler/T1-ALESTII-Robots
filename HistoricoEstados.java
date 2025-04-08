public class HistoricoEstados {
    private int[][] estados;
    private int tamanho;
    private int capacidade;
    private int n;

    public HistoricoEstados(int capacidade, int n) {
        this.capacidade = capacidade;
        this.n = n;
        this.estados = new int[capacidade][n];
        this.tamanho = 0;
    }

    public boolean jaExiste(int[] estado) {
        for (int i = 0; i < tamanho; i++) {
            boolean igual = true;
            for (int j = 0; j < n; j++) {
                if (estados[i][j] != estado[j]) {
                    igual = false;
                    break;
                }
            }
            if (igual) return true;
        }
        return false;
    }

    public void adicionar(int[] estado) {
        if (tamanho >= capacidade) return; // evita estourar
        for (int i = 0; i < n; i++) {
            estados[tamanho][i] = estado[i];
        }
        tamanho++;
    }
}