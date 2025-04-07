import java.util.*;

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

        // Configuração inicial dos robôs (0 até n-1)
        int[] estadoAtual = new int[n];
        for (int i = 0; i < n; i++) {
            estadoAtual[i] = i;
        }

        Set<String> historico = new HashSet<>();
        int passos = 0;

        while (true) {
            String estadoString = Arrays.toString(estadoAtual);

            // Verifica se já dançou essa configuração antes
            if (historico.contains(estadoString)) {
                break;
            }

            historico.add(estadoString);
            passos++;

            // Aplica a receita
            int[] proximoEstado = new int[n];
            for (int i = 0; i < n; i++) {
                proximoEstado[i] = estadoAtual[receita[i]];
            }

            System.out.println("");
            for (int i = 0; i < estadoAtual.length; i++) {
                System.out.print(estadoAtual[i]);
            }
            estadoAtual = proximoEstado;
        }

        System.out.println("A dança terminou após " + passos + " passos.");
    }
}
