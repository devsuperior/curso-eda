public class JuizCidade {

    public static int findJudge(int n, int[][] trust) {
        // Vetor para contar quantas pessoas confiam em cada pessoa
        int[] trustCount = new int[n + 1];
        // Vetor para verificar se uma pessoa confia em alguém
        boolean[] trustsSomeone = new boolean[n + 1];

        // Processa a lista de confiança
        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];
            // Marca que a pessoa 'a' confia em alguém
            trustsSomeone[a] = true;
            // Incrementa o contador de confiança para a pessoa 'b'
            trustCount[b]++;
        }

        // Verifica cada pessoa para encontrar o juiz
        for (int i = 1; i <= n; i++) {
            // O juiz não confia em ninguém e todos (exceto ele mesmo) confiam nele
            if (trustCount[i] == n - 1 && !trustsSomeone[i]) {
                return i;
            }
        }

        // Se não encontrar nenhum juiz, retorna -1
        return -1;
    }

    public static void main(String[] args) {
        // Exemplo 1
        int n = 2;
        int[][] trust1 = { { 1, 2 } };
        System.out.println(findJudge(n, trust1));

        // Exemplo 2
        n = 3;
        int[][] trust2 = { { 1, 3 }, { 2, 3 } };
        System.out.println(findJudge(n, trust2));

        // Exemplo 3
        n = 3;
        int[][] trust3 = { { 1, 3 }, { 2, 3 }, { 3, 1 } };
        System.out.println(findJudge(n, trust3));
    }
}