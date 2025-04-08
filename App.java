import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê a quantidade de robôs
        int n = scanner.nextInt();

        // Lê a receita
        int[] receita = new int[n];
        for (int i = 0; i < n; i++) {
            receita[i] = scanner.nextInt();
        }

        // Estado inicial dos robôs
        int[] estadoAtual = new int[n];
        for (int i = 0; i < n; i++) {
            estadoAtual[i] = i;
        }

        HistoricoEstados historico = new HistoricoEstados(10000, n); // pode ajustar o tamanho máximo

        int passos = 0;

        while (true) {
            if (historico.jaExiste(estadoAtual)) {
                break;
            }

            historico.adicionar(estadoAtual);
            passos++;

            // Calcula o próximo estado
            int[] proximoEstado = new int[n];
            for (int i = 0; i < n; i++) {
                proximoEstado[i] = estadoAtual[receita[i]];
            }

            // Apenas para visualização
            for (int i = 0; i < n; i++) {
                System.out.print(estadoAtual[i]);
            }
            System.out.println();

            estadoAtual = proximoEstado;
        }

        System.out.println("A dança terminou após " + passos + " passos.");
    }
}