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
public class Usuario {
    private int id_usuario;
    private String nome_usuario;
    private String email ;
    private String senha;
    private String telefone;

    public Usuario() {
        this.id_usuario=0;
        this.nome_usuario="";
        this.email="";
        this.senha="";
        this.telefone="";
        
    }

    public Usuario(int id_usuario, String nome_usuario,String email, String senha, String telefone) {
        this.id_usuario=id_usuario;
        this.nome_usuario = nome_usuario;
        this.email = email;
        this.senha=senha;
        this.telefone=telefone;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    
    
}
