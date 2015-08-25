/**
 *
 *@author joao
 * 
 */

package rna;

import factory.*;
import dao.CategoriaDao;
import dao.CategoriaDaoImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import modelo.Diabete_pima;

public class RNA {
    
    private Interface ui;
    
    private double V[][];
    private double Vo[];
    private double W[][];
    private double Wo[];
    
    private ArrayList<Double> ErroTotal;

    public RNA(){
        this.ui = new Interface();
    }
    
    public void treinar() throws SQLException {
        
        /*
        % A bse de dados foi construída em uma pesquisa a partir de 768 mulheres 
        % contendo oito tipos de dados de entrada:
        %     1 Numberof times pregnant, 
        %     2 Plasma glucose concentration a 2 hours in an oral glucose tolerancetest, 
        %     3 Diastolicbloodpressure (mm Hg), 
        %     4 Tricepsskinfoldthickness (mm), 
        %     5 Hour seruminsulin (mu U/ml), 
        %     6 Bodymass index (weight in kg/(height in m)^2), 
        %     7 Diabetes pedigree function, 
        %     8 Age (years).
        %     9 Class
        %     10 gerada na normalização dos dados (Alvo para detectar pacientes norais)
        */
        
        //cria os objetos
        modelo.Diabete_pima modelopima = new Diabete_pima();
        TratamentoDeDados td = new TratamentoDeDados();
        dao.CategoriaDaoImpl categoria=new CategoriaDaoImpl();
        
        //obtem os dados não normalizados para um arrayList       
        ArrayList<modelo.Diabete_pima> dados = (ArrayList<modelo.Diabete_pima>) categoria.lista_Diabetepima();
   
        //normaliza os dados para a variavel de dados normalizados
        double dadosNormalizados[][] = td.normalizarDados(dados);
        
        //obtem o total de dados de treinamento
        int totalDadosTreinamento = dadosNormalizados.length;
        
        //Padrões para as entrada da RNA (de 0 a 7)
        int numColunasEntrada = 8; //deixar fora a coluna do alvo
        double X[][] = new double[totalDadosTreinamento][8];
        
        for (int linha = 0; linha < totalDadosTreinamento; linha++) {
            for (int coluna = 0; coluna < numColunasEntrada; coluna++) {
                X[linha][coluna] = dadosNormalizados[linha][coluna];
            }
        }
        this.ui.imprimeMatriz("X", X);
        
        //Valor desejado para cada entrada (Target ou alvo)
        //9 - Alvo para detectar pacientes com diabetes
        //10 - Alvo para detectar pacientes norais
        int colunaInicialAlvo = 8;
        double T[][] = new double[totalDadosTreinamento][2];
        
        for (int linha = 0; linha < totalDadosTreinamento; linha++) {
            for (int coluna = colunaInicialAlvo; coluna < dadosNormalizados[0].length; coluna++) {
                T[linha][9-coluna] = dadosNormalizados[linha][9-coluna];
            }
        }
        this.ui.imprimeMatriz("T", T);

        //size() no matilab retorna um vetor que o primeiro é o numero de linhas e o segundo o numero de colunas da matriz
        int NumNeuroniosCamEntrada = X[0].length;
        
        int NumPadroesEntrada = X.length;
        
        //define o numero de neuronios da camada escondida
        int NumNeuroniosCamEscondido = 8;
        
        //define os neuronios da camada de saída
        int NumNeuroniosCamSaida = T[0].length;
        
        //Total de porta logica a ser reconhecida
        int NADA = T.length;

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%Treinamento da RNA");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        
        /*
            Passo 0: Inicialização de dados
        =======================================================================
        */
        
        /*
            rand() = gera uma matriz com o numero de linhas e de colunas passada por parametro
        */
        
        Random random = new Random();
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        //Iniciando pesos da camada de entrada / camada escondida
        
        //     % Inicializa os pesos para a camada ESCONDIDA V=rand(NumNeuroniosCamEntrada,NumNeuroniosCamEscondido)*0.5-0.5;
        
        V = new double[NumNeuroniosCamEntrada][NumNeuroniosCamEscondido];
        for (int linha = 0; linha < V.length; linha++) {
            for (int coluna = 0; coluna < V[0].length; coluna++) {
                double numeroRandomico = random.nextDouble();
                V[linha][coluna] = (numeroRandomico * (-1.0000009)) - 0.5;
            }
        }
        this.ui.imprimeMatriz("V", V);
        
        //    % Inicializa os pesos do BIAS para a camada escondida Vo=rand(1,NumNeuroniosCamEscondido)*0.5-0.5; 
        Vo = new double[NumNeuroniosCamEscondido];
        for (int linha = 0; linha < Vo.length; linha++) {
            double numeroRandomico = random.nextDouble();
            Vo[linha] = (numeroRandomico * (-1.0000009)) - 0.5;
        }
        this.ui.imprimeVetor("Vo", Vo);
        
        //Iniciando pesos da camada de escondida / camada saida
        
        //      %Inicializa os pesos para a camada de SAIDA W=rand(NumNeuroniosCamEscondido,NumNeuroniosCamSaida)*0.5-0.5;
        W = new double[NumNeuroniosCamEscondido][NumNeuroniosCamSaida];
        for (int linha = 0; linha < W.length; linha++) {
            for (int coluna = 0; coluna < W[0].length; coluna++) {
                double numeroRandomico = random.nextDouble();
                W[linha][coluna] = (numeroRandomico * (-1.0000009)) - 0.5;
            }
        }
        this.ui.imprimeMatriz("W", W);
        
        //    % Inicializa os pesos do BIAS para a camada de SAIDA Wo=rand(1,NumNeuroniosCamSaida)*0.5-0.5; 
        Wo = new double[NumNeuroniosCamSaida];
        for (int linha = 0; linha < Wo.length; linha++) {
            double numeroRandomico = random.nextDouble();
            Wo[linha] = (numeroRandomico * (-1.0000009)) - 0.5;
        }
        this.ui.imprimeVetor("Wo", Wo);

        //Taxa de aprendizagem
        double Alfa = 0.03; 
        
        //Erro minimoaceitavel
        double ErroMinimo = 0.0001;

        //numero de iteraçoes
        int Interacoes = 0;
        
        //numero maximo de iteracoes
        double NumMaxInteracoes = 10000;

        //define o numero de erro total final
        double ErroTotalFinal = 100;
        
        //define o vetor de erro total
        ArrayList<Double> ErroTotal = new ArrayList<>();
        
        
        /*
            Treinamento
        =======================================================================
        */
        
        double [] y_in =  new double[2];
        double [] z_in = new double[9];
        double [] z = new double[9];
        double [] y = new double[2];
        double [] Sig_y = new double[2];
        double [] erroquadratico = new double[2];
        double [][] delta_w = new double[9][2];
        double [] delta_wo = new double[2];
        double [] Sig_in = new double[9];
        double [] Sig = new double[9];
        double [][] delta_v = new double[8][9];
        double [] delta_vo = new double[9];
        
        
        //%Passo 1- Condição de parada
        while ((Interacoes < NumMaxInteracoes) && (ErroTotalFinal > ErroMinimo)){ 
            Interacoes++;

            //%Passo 2 
            for (int p = 0; p < NumPadroesEntrada; p++) {
                //%feedforward        
                for (int k = 0; k < NumNeuroniosCamSaida; k++) {
                    y_in[k] = 0; //
                    //%Passo 4 
                    for (int j = 0; j < NumNeuroniosCamEscondido; j++) {
                        z_in[j] = 0;              
                        for (int i = 0; i < NumNeuroniosCamEntrada; i++) {                  
                            z_in[j] = z_in[j] + (X[p][i] * V[j][i]);
                        }
                        z_in[j] = z_in[j] + Vo[j];
                        z[j] = (2 / (1 + Math.exp( -z_in[j] ))) - 1; //%f2 - pag5      
                        y_in[k] = y_in[k] + (z[j]*W[j][k]);
                    }
                    
                    //%Passo 5           
                    y_in[k] = Wo[k]+y_in[k];
                    y[k] = (2 / (1 + Math.exp( -y_in[k] ))) - 1; //%f2
                    
                    //%Passo 6           
                    //%backpropagation of error
                    Sig_y[k] = (T[p][k]-y[k]) * 0.5 * (1+y[k]) * (1-y[k]);//////

                    erroquadratico[k] = Math.abs(0.5 * Math.pow(T[p][k]-y[k],2));

                    for (int j = 0; j < NumNeuroniosCamEscondido; j++) {
                        delta_w[j][k] = Alfa * Sig_y[k] * z[j];
                    }
                    delta_wo[k] = Alfa * Sig_y[k];
                }

                //%Passo 7
                for (int j = 0; j < NumNeuroniosCamEscondido; j++) { 
                    Sig_in[j] = 0;
                    for (int k = 0; k < NumNeuroniosCamSaida; k++) {
                        Sig_in[j] = Sig_in[j] + (Sig_y[k]*W[j][k]);
                    }                    
                    Sig[j] = Sig_in[j] * 0.5 * (1+z[j])*(1-z[j]);                  
                    for (int i = 0; i < NumNeuroniosCamEntrada; i++) {
                       delta_v[j][i] = Alfa * Sig[j] * X[p][i];
                    }
                    delta_vo[j] = Alfa * Sig[j]; 
                }

                //%Passo 8        
                //%Atualização de pesos
                for (int k = 0; k < NumNeuroniosCamSaida; k++) {   
                    Wo[k] = Wo[k] + delta_wo[k];
                    for (int j = 0; j < NumNeuroniosCamEscondido; j++) {
                        W[j][k] = W[j][k] + delta_w[j][k];
                        for (int i = 0; i < NumNeuroniosCamEscondido; i++) { //%<<<-----
                            V[i][j] = V[i][j] + delta_v[i][j];
                        }
                        Vo[j]= Vo[j] + delta_vo[j];        
                    }
                }
            }
            //%Armazena o maior erro entre a camada de saida e a camada escondida   
            ErroTotalFinal = erroquadratico[0] + erroquadratico[1];
            ErroTotal.add(ErroTotalFinal);
        }
        
        this.ErroTotal = ErroTotal;

        //plot(ErroTotal);

        System.out.println("Numero de Interacoes = " + Interacoes);
    }
    
    public String testar() throws SQLException {
        
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%Teste da RNA");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        
        //cria os objetos
        TratamentoDeDados td = new TratamentoDeDados();
        modelo.Diabete_pima Modelopima = new Diabete_pima();
        dao.CategoriaDaoImpl categoria=new CategoriaDaoImpl();
        
        //obtem os dados não normalizados para um arrayList       
        ArrayList<modelo.Diabete_pima> dados = (ArrayList<modelo.Diabete_pima>) categoria.lista_Diabetepima();
        //normaliza os dados para a variavel de dados normalizados
        double dadosNormalizados[][] = td.normalizarDados(dados);
        
        //obtem o total de dados de treinamento
        int totalDadosTeste = dadosNormalizados.length;
        
        //Padrões para as entrada da RNA (de 0 a 7)
        int numColunasEntrada = 8; //deixar fora a coluna do alvo
        double X[][] = new double[totalDadosTeste][numColunasEntrada];
        
        for (int linha = 0; linha < totalDadosTeste; linha++) {
            for (int coluna = 0; coluna < numColunasEntrada; coluna++) {
                X[linha][coluna] = dadosNormalizados[linha][coluna];
            }
        }
        this.ui.imprimeMatriz("X", X);
        
        //T=dados_Normalizados(539:768,9:10)';%Valor desejado para cada entrada (Target)
        int colunaInicialAlvo = 9;
        double T[][] = new double[totalDadosTeste][2];
        
        for (int linha = 0; linha < totalDadosTeste; linha++) {
            for (int coluna = colunaInicialAlvo; coluna < dadosNormalizados[0].length; coluna++) {
                T[linha][9-coluna] = dadosNormalizados[linha][coluna];
            }
        }
        this.ui.imprimeMatriz("T", T);
        
        
        //size() no matilab retorna um vetor que o primeiro é o numero de linhas e o segundo o numero de colunas da matriz
        int NumNeuroniosCamEntrada = X[0].length;
        
        int NumPadroesEntrada = X.length;
        
        //define o numero de neuronios da camada escondida
        int NumNeuroniosCamEscondido = 8;
        
        //define os neuronios da camada de saída
        int NumNeuroniosCamSaida = T[0].length;
        
        //Total de porta logica a ser reconhecida
        int NADA = T[0].length;


        int AcertosDiabetes=0;
        int AcertosNormal=0;
        int ErrosDiabetes=0;
        int ErrosNormal=0;
        
        double [] y_in =  new double[2];
        double [] z_in = new double[9];
        double [] z = new double[9];
        double [] y = new double[2];
        
        int p = 0;
        for (p = 0; p < NumPadroesEntrada; p++) {   
            for (int k = 0; k < NumNeuroniosCamSaida; k++) {
                y_in[k] = 0;
                for (int j = 0; j < NumNeuroniosCamEscondido; j++) {
                    z_in[j] = 0;
                    for (int i = 0; i < NumNeuroniosCamEntrada; i++) {
                        z_in[j] = z_in[j] + (X[p][i]*V[j][i]);
                    }
                    z_in[j] = z_in[j]+Vo[j];
                    z[j] = (2 / (1 + Math.exp(-z_in[j])))-1;        
                    y_in[k] = y_in[k] + (z[j]*W[j][k]);
                }
                y_in[k] = Wo[k]+y_in[k];
                y[k] = (2 / (1+Math.exp(-y_in[k])))-1;
                
                if(k==1){//%diabets
                    if((y[k]>0) & (T[p][k]>0)){
                        AcertosDiabetes=AcertosDiabetes+1;
                    }
                    else if(y[k]<0 & T[p][k]<0){
                        AcertosDiabetes=AcertosDiabetes+1;
                    }
                    else{
                        ErrosDiabetes = ErrosDiabetes+1;
                    }
                }


                if(k==2){//%normal
                    if(y[k]>0.2 & T[k][p]>0){
                        AcertosNormal=AcertosNormal+1;
                    }
                    else if(y[k]<-0.2 & T[k][p]<0){
                        AcertosNormal=AcertosNormal+1;
                    }
                    else{
                        ErrosNormal=ErrosNormal+1;
                    }
                }

            }

        }
        
        String resultadoTeste = "";
        resultadoTeste += "\nTESTE Padrão de entrada " + p;
        resultadoTeste += "\nA rede neural ACERTOU : " + AcertosDiabetes + "=>%" + (AcertosDiabetes/p*100);
        resultadoTeste += "\nA rede neural ERROU : " + ErrosDiabetes + "=>%" + (ErrosDiabetes/p*100);

        resultadoTeste += "\nTESTE Padrão de entrada  " + p;
        resultadoTeste += "\nA rede neural ACERTOU : " + AcertosNormal + "=>%" + (AcertosNormal/p*100);
        resultadoTeste += "\nA rede neural ERROU : " + ErrosNormal + "=>%" + (ErrosNormal/p*100);
        
        return resultadoTeste;
        
    }

    public ArrayList<Double> getErroTotal() {
        return ErroTotal;
    }

}
