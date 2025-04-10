import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        try {
            // Altere o caminho para o arquivo conforme necessário
            File arquivo = new File("CasosDeTeste\\caso79.txt");
            Scanner scanner = new Scanner(arquivo);

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

            HistoricoEstados historico = new HistoricoEstados(10000, n);

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
                    System.out.print(estadoAtual[i]+" ");
                }
                System.out.println();

                estadoAtual = proximoEstado;
            }

            System.out.println("A dança terminou após " + passos + " passos.");
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }
}
