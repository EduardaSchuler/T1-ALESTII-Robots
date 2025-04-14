import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("CasosDeTeste\\caso_12.txt"));

            int n = scanner.nextInt();
            int[] receita = new int[n];
            for (int i = 0; i < n; i++) {
                receita[i] = scanner.nextInt();
            }

            long inicio = System.currentTimeMillis();

            long passos = HistoricoEstados.contarRodadasAteRepeticao(receita);

            long fim = System.currentTimeMillis();

            System.out.println("A dança terminou após " + passos + " passos.");
            System.out.println("Tempo: " + (fim - inicio) + "ms");

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }
}
