import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("CasosDeTeste\\caso_72.txt"));

            int n = scanner.nextInt();

            int[] receita = new int[n];
            for (int i = 0; i < n; i++) {
                receita[i] = scanner.nextInt();
            }

            int[] estadoAtual = new int[n];
            for (int i = 0; i < n; i++) {
                estadoAtual[i] = i;
            }

            int capacidadeHash = 100_000; // aumentada para reduzir colisões
            HistoricoEstados historico = new HistoricoEstados(capacidadeHash, n);

            int passos = 0;

            long inicio = System.currentTimeMillis(); // para medir o tempo

            while (true) {
                if (historico.jaExiste(estadoAtual)) {
                    break;
                }

                historico.adicionar(estadoAtual);
                passos++;

                int[] proximoEstado = new int[n];
                for (int i = 0; i < n; i++) {
                    proximoEstado[i] = estadoAtual[receita[i]];
                }

                estadoAtual = proximoEstado;
            }

            long fim = System.currentTimeMillis();

            System.out.println("A dança terminou após " + passos + " passos.");
            System.out.println("Tempo: " + (fim - inicio) + "ms");

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }
}
