import java.util.Arrays;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) throws Exception {
        // TODO: Implementar menu interativo com as seguintes opcoes:
        // 1. Exercicio 01: Progressao Geometrica
        // 2. Exercicio 02: Sequencia Decrescente
        // 3. Exercicio 03: Vetor Dinamico
        // 4. Exercicio 04: Sequencia Crescente com Soma
        // 5. Exercicio 05: Matriz com Valores Incrementais
        // 6. Exercicio 06: Operacao entre Matrizes
        // 0. Sair
        
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1 - Exercicio 01");
            System.out.println("2 - Exercicio 02");
            System.out.println("3 - Exercicio 03");
            System.out.println("4 - Exercicio 04");
            System.out.println("5 - Exercicio 05");
            System.out.println("6 - Exercicio 06");
            System.out.println("0 - Sair");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println(Arrays.toString(ex01()));
                    break;
                case 2:
                    System.out.println(Arrays.toString(ex02()));
                    break;
                case 3:
                    System.out.println(Arrays.toString(ex03()));
                    break;
                case 4:
                    int[] vetor = ex04();
                    System.out.println(Arrays.toString(vetor));
                    System.out.println("Soma: " + calcularSoma(vetor));
                    break;
                case 5:
                    exibirMatriz(ex05());
                    break;
                case 6:
                    int[][][] matrizes = ex06();
                    System.out.println("Matriz N:");
                    exibirMatriz(matrizes[0]);
                    System.out.println("Matriz Z:");
                    exibirMatriz(matrizes[1]);
                    System.out.println("Matriz Soma:");
                    exibirMatriz(matrizes[2]);
                    break;
            }
        } while (opcao != 0);
        scanner.close();
    }
    
    private static int lerValor(Scanner scanner, String mensagem, int min, int max) {
        int valor;
        do {
            System.out.println(mensagem);
            valor = scanner.nextInt();
        } while (!(valor > min && valor <= max));
        return valor;
    }
    
    private static void exibirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%4d ", matriz[i][j]);
            }
            System.out.println();
        }
    }
    
    public static int[] progressaoGeometrica(int valorInicial) {
        if (valorInicial > 20) return null;
        int[] vetor = new int[10];
        vetor[0] = valorInicial;
        for (int i = 1; i < 10; i++) {
            vetor[i] = vetor[i-1] * 2;
        }
        return vetor;
    }
    
    public static int[] sequenciaDecrescente(int valorInicial) {
        if (valorInicial <= 1) return null;
        int[] vetor = new int[10];
        vetor[0] = valorInicial;
        for (int i = 1; i < 10; i++) {
            vetor[i] = vetor[i-1] - 1;
        }
        return vetor;
    }
    
    public static int[] vetorDinamico(int tamanho) {
        if (tamanho > 1000) return null;
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = i + 1;
        }
        return vetor;
    }
    
    public static int[] sequenciaCresenteComSoma(int valorInicial) {
        int[] vetor = new int[10];
        vetor[0] = valorInicial;
        for (int i = 1; i < 10; i++) {
            vetor[i] = vetor[i-1] + 1;
        }
        return vetor;
    }
    
    public static int calcularSoma(int[] vetor) {
        int soma = 0;
        for (int valor : vetor) soma += valor;
        return soma;
    }
    
    public static int[][] matrizIncrementais(int tamanho) {
        int[][] matriz = new int[tamanho][tamanho];
        int contador = tamanho + 1;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                matriz[i][j] = contador++;
            }
        }
        return matriz;
    }
    
    public static int[][][] operacaoEntreMatrizes(int tamanho) {
        int[][] N = new int[tamanho][tamanho];
        int[][] Z = new int[tamanho][tamanho];
        int[][] Soma = new int[tamanho][tamanho];
        int contador = tamanho + 1;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                N[i][j] = contador;
                Z[i][j] = contador;
                Soma[i][j] = N[i][j] + Z[i][j];
                contador++;
            }
        }
        return new int[][][]{N, Z, Soma};
    }
    
    public static int[] ex01() {
        Scanner scanner = new Scanner(System.in);
        int valor = lerValor(scanner, "Digite um valor <= 20", Integer.MIN_VALUE, 20);
        return progressaoGeometrica(valor);
    }
    
    public static int[] ex02() {
        Scanner scanner = new Scanner(System.in);
        int valor = lerValor(scanner, "Digite um valor entre 1 e 100", 1, 99);
        return sequenciaDecrescente(valor);
    }
    
    public static int[] ex03() {
        Scanner scanner = new Scanner(System.in);
        int valor = lerValor(scanner, "Digite um valor entre 1 e 1000", 1, 1000);
        return vetorDinamico(valor);
    }
    
    public static int[] ex04() {
        Scanner scanner = new Scanner(System.in);
        int valor = lerValor(scanner, "Digite um valor entre 1 e 100", 1, 99);
        return sequenciaCresenteComSoma(valor);
    }
    
    public static int[][] ex05() {
        Scanner scanner = new Scanner(System.in);
        int valor = lerValor(scanner, "Digite um valor entre 3 e 50", 3, 50);
        return matrizIncrementais(valor);
    }
    
    public static int[][][] ex06() {
        Scanner scanner = new Scanner(System.in);
        int valor = lerValor(scanner, "Digite um valor entre 3 e 50", 3, 50);
        return operacaoEntreMatrizes(valor);
    }
}
