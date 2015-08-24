/**
 *
 @author joao
 * 
 */

package rna;

public class Interface {
    public void imprimeVetor(String titulo, double[] vetor){
        System.out.println(titulo);
        System.out.println("====================================================================");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " - ");
        }
        System.out.println("");
        System.out.println("");
    }
    
    public void imprimeMatriz(String titulo, double[][] matriz){
        System.out.println(titulo);
        System.out.println("====================================================================");
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                System.out.print(matriz[linha][coluna] + " - ");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
    }
}