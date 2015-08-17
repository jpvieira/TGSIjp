/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jp
 */
public class Treino_redes {
    private  int id_treino;
    private String data_treino;
    private int numero_interacao;
    private int usuario_responsavel;
    private float pesoalfa;
    private float pesobeta;
    
  

    public Treino_redes() {
         this.id_treino = 0;
         this.data_treino="";
         this.numero_interacao=0;
         this.usuario_responsavel=0;
         this.pesoalfa=0;
         this.pesobeta=0;
        
    }

    public Treino_redes(int id_treino,String data_treino,int numero_interacao,int usuario_responsavel,float pesoalfa,float pesobeta) {
        this.id_treino = id_treino;
        this.data_treino=data_treino;
        this.numero_interacao=numero_interacao;
        this.usuario_responsavel=usuario_responsavel;
        this.pesoalfa=pesoalfa;
        this.pesobeta=pesobeta;
    }

    public int getId_treino() {
        return id_treino;
    }

    public void setId_treino(int id_treino) {
        this.id_treino = id_treino;
    }

    public String getData_treino() {
        return data_treino;
    }

    public void setData_treino(String data_treino) {
        this.data_treino = data_treino;
    }

    public int getNumero_interacao() {
        return numero_interacao;
    }

    public void setNumero_interacao(int numero_interacao) {
        this.numero_interacao = numero_interacao;
    }

    public int getUsuario_responsavel() {
        return usuario_responsavel;
    }

    public void setUsuario_responsavel(int usuario_responsavel) {
        this.usuario_responsavel = usuario_responsavel;
    }

    public float getPesoalfa() {
        return pesoalfa;
    }

    public void setPesoalfa(float pesoalfa) {
        this.pesoalfa = pesoalfa;
    }

    public float getPesobeta() {
        return pesobeta;
    }

    public void setPesobeta(float pesobeta) {
        this.pesobeta = pesobeta;
    }

   
    
}
