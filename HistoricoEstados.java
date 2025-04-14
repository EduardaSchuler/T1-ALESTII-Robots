public class HistoricoEstados {
    private int[][] tabela;
    private boolean[] ocupado;
    private int capacidade;
    private int n;

    public HistoricoEstados(int capacidade, int n) {
        this.capacidade = capacidade;
        this.n = n;
        this.tabela = new int[capacidade][];
        this.ocupado = new boolean[capacidade];
    }

    // Função de hash otimizada
    private int hash(int[] estado) {
        int hash = 0;
        for (int i = 0; i < estado.length; i++) {
            hash ^= (estado[i] + 0x9e3779b9 + (hash << 6) + (hash >> 2));
        }
        return Math.abs(hash % capacidade);
    }

    public boolean jaExiste(int[] estado) {
        int pos = hash(estado);

        for (int i = 0; i < capacidade; i++) {
            int idx = (pos + i) % capacidade;

            if (!ocupado[idx]) return false;

            if (iguais(tabela[idx], estado)) return true;
        }

        return false;
    }

    public void adicionar(int[] estado) {
        int pos = hash(estado);

        for (int i = 0; i < capacidade; i++) {
            int idx = (pos + i) % capacidade;

            if (!ocupado[idx]) {
                tabela[idx] = estado.clone();
                ocupado[idx] = true;
                return;
            }

            if (iguais(tabela[idx], estado)) return;
        }
    }

    private boolean iguais(int[] a, int[] b) {
        if (a == null || b == null) return false;
        if (a.length != b.length) return false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }

        return true;
    }
}
