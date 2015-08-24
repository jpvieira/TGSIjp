/**
 *
@author joao
 * 
 */

package rna;

import dados.PacienteModelo;
import java.util.ArrayList;

public class TratamentoDeDados {
    
    private Interface ui = new Interface();
    
    public double[][] normalizarDados(ArrayList<PacienteModelo> dados){
        
        //define o numero de colunas cuja a ultima é o alvo
        int numeroColunas = 10;
        
        //criamos então a matriz para armazenar os dados normalizados
        double dadosNormalizados[][] = new double[dados.size()][numeroColunas];
        
        //converter de arraylist para um array comum
        for(int linha = 0; linha < dados.size(); linha++) {
            dadosNormalizados[linha][0] = dados.get(linha).getNb_pregnant();
            dadosNormalizados[linha][1] = dados.get(linha).getPlasma_glucose();
            dadosNormalizados[linha][2] = dados.get(linha).getDiastolic_press();
            dadosNormalizados[linha][3] = dados.get(linha).getTriceps_skin();
            dadosNormalizados[linha][4] = dados.get(linha).getSerum_insulin();
            dadosNormalizados[linha][5] = dados.get(linha).getBody_mass();
            dadosNormalizados[linha][6] = dados.get(linha).getDiabetes();
            dadosNormalizados[linha][7] = dados.get(linha).getAge();
            dadosNormalizados[linha][8] = dados.get(linha).getClassificacao();
        }
        
        this.ui.imprimeMatriz("Dados não normalizados", dadosNormalizados);
        
        for(int linha = 0; linha < dadosNormalizados.length; linha++) {
            for (int coluna = 0; coluna <= dadosNormalizados[linha].length-2; coluna++) {
               
                //dados_Normalizados(linha,j)=((2*(dadosDiabetes(linha,j)-min(dadosDiabetes(:,j))))/(max(dadosDiabetes(:,j))-min(dadosDiabetes(:,j))))-1;
                dadosNormalizados[linha][coluna]=((2*(dadosNormalizados[linha][coluna]-this.min(this.converteColunaEmVetor(coluna, dadosNormalizados))))/(this.max(this.converteColunaEmVetor(coluna, dadosNormalizados))-this.min(this.converteColunaEmVetor(coluna, dadosNormalizados))))-1;
                double min1 = this.min(this.converteColunaEmVetor(coluna, dadosNormalizados));
                double max = this.max(this.converteColunaEmVetor(coluna, dadosNormalizados));
                double min2 = this.min(this.converteColunaEmVetor(coluna, dadosNormalizados));
                
                if(coluna == 8){
                    if(dadosNormalizados[linha][coluna] > 0){
                        //dados_Normalizados(i,j+1)=-1;
                        dadosNormalizados[linha][coluna+1] = -1;
                    }
                    else{
                        //dados_Normalizados(i,j+1)=1;
                        dadosNormalizados[linha][coluna+1] = 1;
                    }
                }
            }
        }
        
        this.ui.imprimeMatriz("Dados normalizados", dadosNormalizados);
        
        return dadosNormalizados;
    }
    
    //coverte uma coluna da matriz em um vetor
    private double[] converteColunaEmVetor(int coluna, double[][] matriz){
        double [] array = new double[matriz.length];
        
        for (int linha = 0; linha < matriz.length; linha++) {
            array[linha] = matriz[linha][coluna];
        }
        
        //this.ui.imprimeVetor("Coluna em vetor", array);
        
        return array;
    }
    
    //pega o elemento minimo de um array
    private double min(double[] array){
        double min = 999999999; //recebe um valor max
        
        for (int i = 0; i < array.length; i++) {
            if(min > array[i]){
                min = array[i];
            }
        }
        
        return min;
    }
    
    //pega o elemento maximo de um array
    private double max(double[] array){
        double max = 0; //recebe um valor min
        
        for (int i = 0; i < array.length; i++) {
            if(max < array[i]){
                max = array[i];
            }
        }
        
        return max;
    }
    
}