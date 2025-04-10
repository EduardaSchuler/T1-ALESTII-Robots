import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class App {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("CasosDeTeste\\caso79.txt"));

            int n = scanner.nextInt();

            int[] receita = new int[n];
            for (int i = 0; i < n; i++) {
                receita[i] = scanner.nextInt();
            }

            int[] estadoAtual = new int[n];
            for (int i = 0; i < n; i++) {
                estadoAtual[i] = i;
            }

            Set<String> historico = new HashSet<>();
            int passos = 0;

            while (true) {
                String estadoStr = Arrays.toString(estadoAtual);
                if (historico.contains(estadoStr)) {
                    break;
                }

                historico.add(estadoStr);
                passos++;

                int[] proximoEstado = new int[n];
                for (int i = 0; i < n; i++) {
                    proximoEstado[i] = estadoAtual[receita[i]];
                }

                estadoAtual = proximoEstado;
            }

            System.out.println("A dança terminou após " + passos + " passos.");
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }
}
