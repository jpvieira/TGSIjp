/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import factory.ConectionDB;
import factory.FactoryConnectionDb;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Amostra_paci;
import modelo.Diabete_pima;
import modelo.Treino_redes;
import modelo.Usuario;

/**
 *
 * @author jp
 */
public class CategoriaDaoImpl {
    
    ConectionDB conn;

    public CategoriaDaoImpl() {
                
    }
    

 
    public List<Diabete_pima> lista_Diabetepima() {
                this.conn=FactoryConnectionDb.open(FactoryConnectionDb.MYSQL);

        StringBuilder sql= new StringBuilder();
        sql.append("SELECT * FROM diabete_pima");
        List<Diabete_pima> list=new ArrayList<Diabete_pima>();
        try {
            ResultSet rs= this.conn.query(sql.toString());
            while(rs.next()){
                
                Diabete_pima diabetepima=new Diabete_pima();
                diabetepima.setId_pima(rs.getInt("id"));
                diabetepima.setAge(rs.getFloat("age"));
                diabetepima.setBody_mass(rs.getFloat("body_mass"));
                diabetepima.setClasse(rs.getFloat("classe"));
                diabetepima.setDiabetes(rs.getFloat("diabetes"));
                diabetepima.setDiastolic(rs.getFloat("diastolic"));
                diabetepima.setNb_pregnant(rs.getFloat("nb_pregnant"));
                diabetepima.setSerum_insulin(rs.getFloat("serum_insulin"));
                diabetepima.setTriceps_skin(rs.getFloat("triceps_skin"));     
                list.add(diabetepima);
            }
            
        } catch (Exception e) {
            
        }
        finally{
            this.conn.close();
        }
        return  list;
    }

    
    public List<Usuario> listusuarios() {
             this.conn=FactoryConnectionDb.open(FactoryConnectionDb.MYSQL);

        StringBuilder sql= new StringBuilder();
        sql.append("SELECT * FROM usuario");
        List<Usuario> list=new ArrayList<Usuario>();
        try {
            ResultSet rs= this.conn.query(sql.toString());
            while(rs.next()){
                
               Usuario usuario=new Usuario();
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setNome_usuario(rs.getString("nome_usuario"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTelefone(rs.getString("telefone"));
                list.add(usuario);
            }
            
        } catch (Exception e) {
            
        }
        finally{
            this.conn.close();
        }
        return  list;
    }

    
    public Usuario edit(int id) {
        this.conn=FactoryConnectionDb.open(FactoryConnectionDb.MYSQL);
        Usuario usuario = new  Usuario();
          StringBuilder sql= new StringBuilder();
          sql.append("select * from usuario where id_usuario=").append(id);
          try {
            ResultSet rs=this.conn.query(sql.toString());
              while (rs.next()) {                  
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setNome_usuario(rs.getString("nome_usuario"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTelefone(rs.getString("telefone"));
              }
        } catch (Exception e) {
            
        }
          finally{
              this.conn.close();
          }
                     
        return usuario;
     }
    

   
    public boolean salva(Usuario usuario) {
          
        this.conn=FactoryConnectionDb.open(FactoryConnectionDb.MYSQL);
        boolean salva = false;
        try {
            if (usuario.getId_usuario()== 0) {//significa que é um nova categoria
                StringBuilder sql=new StringBuilder();
                sql.append("INSERT INTO usuario(nome_usuario, email,senha,telefone) VALUES('" ).append(usuario.getNome_usuario());
                sql.append("','").append(usuario.getEmail());
                sql.append("','").append(usuario.getSenha());
                sql.append("','").append(usuario.getTelefone());
                sql.append("')");
                //System.out.println(sql);
               this.conn.execute(sql.toString());
            } 
            else {//se o valor for diferente de 0 tem que editar os dados 
                 StringBuilder sql=new StringBuilder();
                sql.append("UPDATE usuario SET id_usuario=").append(usuario.getId_usuario());
                sql.append(",nome_usuario='").append(usuario.getNome_usuario());
                sql.append("',email='").append(usuario.getEmail());
                sql.append("',senha='").append(usuario.getSenha());
                sql.append("',telefone='").append(usuario.getTelefone());
                sql.append("' where id_usuario=").append(usuario.getId_usuario());
                //System.out.println(sql);
               this.conn.execute(sql.toString());
            }
            salva=true;
        } catch (Exception e) {
           this.conn.close();
        }
        return salva;
    }

    
    public boolean deleteusuario(int id) {
        this.conn=FactoryConnectionDb.open(FactoryConnectionDb.MYSQL);

        boolean delete=false;  
        try {
             StringBuilder sql=new StringBuilder();
             sql.append("delete from usuario where id_usuario=").append(id);
             this.conn.execute(sql.toString());

             
            
            
        } catch (Exception e) {
        } finally{
            this.conn.close();
            
        
            }
        
        
        return delete;  
    }
    
    
       public List<Amostra_paci> lista_amostra_paci() {
                this.conn=FactoryConnectionDb.open(FactoryConnectionDb.MYSQL);

        StringBuilder sql= new StringBuilder();
        sql.append("SELECT * FROM amostra_paciente");
        List<Amostra_paci> list=new ArrayList<Amostra_paci>();
        
        try {
            ResultSet rs= this.conn.query(sql.toString());
            
            while(rs.next()){                
                Amostra_paci amostra_paci=new Amostra_paci();
                amostra_paci.setId_amostra(rs.getInt("id_amostra"));
                amostra_paci.setAge_amostra(rs.getFloat("age_amostra"));
                amostra_paci.setBody_mass_amostra(rs.getFloat("body_mass_amostra"));
                amostra_paci.setClass_amostra(rs.getFloat("class_amostra"));
                amostra_paci.setDiabetes_amostra(rs.getFloat("diabetes_amostra"));
                amostra_paci.setDiastolic_amostra(rs.getFloat("diastolic_amostra"));
                amostra_paci.setNbpregnant_amostra(rs.getFloat("nbpregnant_amostra"));
                amostra_paci.setSerum_isulin(rs.getFloat("serum_isulin"));
                amostra_paci.setTriceps_skin_amostra(rs.getFloat("triceps_skin_amostra"));
                amostra_paci.setPlasma_glucose_amostra(rs.getFloat("plasma_glucose_amostra"));
                amostra_paci.setData_amostra(rs.getString("data_amostra"));
                list.add(amostra_paci);
              
                
            }
            
        } catch (Exception e) {
            
        }
        finally{
            this.conn.close();
        }
        return  list;
    }
    //INSERT INTO `amostra_paciente`(`age_amostra`, `body_mass_amostra`, `class_amostra`, `diabetes_amostra`, `diastolic_amostra`, `nbpregnant_amostra`, `plasma_glucose_amostra`, `serum_isulin`, `triceps_skin_amostra`, `data_amostra`) VALUES (1,2,3,4,5,6,7,8,9,'03081993')
      public Amostra_paci edit_amostra(int id) {
        this.conn=FactoryConnectionDb.open(FactoryConnectionDb.MYSQL);
        Amostra_paci amostra_paci = new  Amostra_paci();
          StringBuilder sql= new StringBuilder();
          sql.append("SELECT * FROM amostra_paciente WHERE id_amostra=").append(id);
          try {
            ResultSet rs=this.conn.query(sql.toString());
              while (rs.next()) {                  
                amostra_paci.setId_amostra(rs.getInt("id_amostra"));
                amostra_paci.setAge_amostra(rs.getFloat("age_amostra"));
                amostra_paci.setBody_mass_amostra(rs.getFloat("body_mass_amostra"));
                amostra_paci.setClass_amostra(rs.getFloat("class_amostra"));
                amostra_paci.setDiabetes_amostra(rs.getFloat("diabetes_amostra"));
                amostra_paci.setDiastolic_amostra(rs.getFloat("diastolic_amostra"));
                amostra_paci.setNbpregnant_amostra(rs.getFloat("nbpregnant_amostra"));
                amostra_paci.setSerum_isulin(rs.getFloat("serum_isulin"));
                amostra_paci.setTriceps_skin_amostra(rs.getFloat("triceps_skin_amostra"));
                amostra_paci.setPlasma_glucose_amostra(rs.getFloat("plasma_glucose_amostra"));
                amostra_paci.setData_amostra(rs.getString("data_amostra"));
                
              }
        } catch (Exception e) {
            
        }
          finally{
              this.conn.close();
          }
                     
        return amostra_paci;
     }
      
      
      public boolean salva_amotra_paci(Amostra_paci amostra_paci) {
          
        this.conn=FactoryConnectionDb.open(FactoryConnectionDb.MYSQL);
        boolean salva = false;
        try {
            if (amostra_paci.getId_amostra()== 0) {//significa que é um nova categoria
                StringBuilder sql=new StringBuilder();
                sql.append("INSERT INTO amostra_paciente(age_amostra, body_mass_amostra, class_amostra,"
                        + " diabetes_amostra, diastolic_amostra, nbpregnant_amostra, plasma_glucose_amostra, "
                        + "serum_isulin, triceps_skin_amostra, data_amostra) VALUES (" );
                sql.append(amostra_paci.getAge_amostra());
                sql.append(",").append(amostra_paci.getBody_mass_amostra());
                sql.append(",").append(amostra_paci.getClass_amostra());
                sql.append(",").append(amostra_paci.getDiabetes_amostra());
                sql.append(",").append(amostra_paci.getDiastolic_amostra());
                sql.append(",").append(amostra_paci.getNbpregnant_amostra());
                sql.append(",").append(amostra_paci.getPlasma_glucose_amostra());
                sql.append(",").append(amostra_paci.getSerum_isulin());
                sql.append(",").append(amostra_paci.getTriceps_skin_amostra());
                sql.append(",'").append(amostra_paci.getData_amostra());
                sql.append("')");
                //System.out.println(sql);
               this.conn.execute(sql.toString());
            } 
            else {//se o valor for diferente de 0 tem que editar os dados 
                 StringBuilder sql=new StringBuilder();
                sql.append("UPDATE amostra_paciente SET id_amostra=").append(amostra_paci.getId_amostra());
                sql.append(",age_amostra=").append(amostra_paci.getAge_amostra());
                sql.append(",body_mass_amostra=").append(amostra_paci.getBody_mass_amostra());
                sql.append(",class_amostra=").append(amostra_paci.getClass_amostra());
                sql.append(",diabetes_amostra=").append(amostra_paci.getDiabetes_amostra());
                sql.append(",diastolic_amostra=").append(amostra_paci.getDiastolic_amostra());
                sql.append(",nbpregnant_amostra=").append(amostra_paci.getNbpregnant_amostra());
                sql.append(",plasma_glucose_amostra=").append(amostra_paci.getPlasma_glucose_amostra());
                sql.append(",serum_isulin=").append(amostra_paci.getSerum_isulin());
                sql.append(",triceps_skin_amostra=").append(amostra_paci.getTriceps_skin_amostra());    
                sql.append(",data_amostra='").append(amostra_paci.getData_amostra());          
                sql.append("' where id_amostra =").append(amostra_paci.getId_amostra());
                //System.out.println(sql);
               this.conn.execute(sql.toString());
            }
            salva=true;
        } catch (Exception e) {
           this.conn.close();
        }
        return salva;
    }
      
      
       public boolean deleteamostra_usu(int id) {
        this.conn=FactoryConnectionDb.open(FactoryConnectionDb.MYSQL);

        boolean delete=false;  
        try {
             StringBuilder sql=new StringBuilder();
             sql.append("DELETE FROM amostra_paciente WHERE id_amostra=").append(id);
             this.conn.execute(sql.toString());
             //System.out.println(sql);
             
        } catch (Exception e) {
        } finally{
            this.conn.close();
            
        
            }
        
        
        return delete;  
    }
       
    public List<Treino_redes> lista_treinoRedes() {
                this.conn=FactoryConnectionDb.open(FactoryConnectionDb.MYSQL);

        StringBuilder sql= new StringBuilder();
        sql.append("SELECT * FROM treino_redes");
        List<Treino_redes> list=new ArrayList<Treino_redes>();
        try {
            ResultSet rs= this.conn.query(sql.toString());
            while(rs.next()){
                
                Treino_redes treino_redes=new Treino_redes();
                treino_redes.setId_treino(rs.getInt("id_treino"));
                treino_redes.setData_treino(rs.getString("data_treino"));
                treino_redes.setNumero_interacao(rs.getInt("nume_interacao"));
                treino_redes.setUsuario_responsavel(rs.getInt("usuario_responsavel"));
                treino_redes.setPesoalfa(rs.getFloat("pesoalfa"));
                treino_redes.setPesobeta(rs.getFloat("pesobeta"));
                list.add(treino_redes);
            }
            
        } catch (Exception e) {
            
        }
        finally{
            this.conn.close();
        }
        return  list;
    }

    
    
     public Treino_redes edit_treinorede(int id) {
        this.conn=FactoryConnectionDb.open(FactoryConnectionDb.MYSQL);
       Treino_redes treino_redes = new  Treino_redes();
          StringBuilder sql= new StringBuilder();
          sql.append("SELECT * FROM treino_redes WHERE id_treino=").append(id);
          try {
            ResultSet rs=this.conn.query(sql.toString());
              while (rs.next()) {                  
                treino_redes.setId_treino(rs.getInt("id_treino"));
                treino_redes.setData_treino(rs.getString("data_treino"));
                treino_redes.setNumero_interacao(rs.getInt("nume_interacao"));
                treino_redes.setUsuario_responsavel(rs.getInt("usuario_responsavel"));
                treino_redes.setPesoalfa(rs.getFloat("pesoalfa"));
                treino_redes.setPesobeta(rs.getFloat("pesobeta"));

              }
        } catch (Exception e) {
            
        }
          finally{
              this.conn.close();
          }
                     
        return treino_redes;
     }
     
     
      public boolean salva_treino(Treino_redes treino_redes) {
          
        this.conn=FactoryConnectionDb.open(FactoryConnectionDb.MYSQL);
        boolean salva = false;
        try {
            if (treino_redes.getId_treino()== 0) {//significa que é um nova categoria
                StringBuilder sql=new StringBuilder();
                sql.append("INSERT INTO treino_redes(data_treino, nume_interacao, usuario_responsavel, pesoalfa, pesobeta) VALUES ('" );
                sql.append(treino_redes.getData_treino());
                sql.append("',").append(treino_redes.getNumero_interacao());
                sql.append(",").append(treino_redes.getUsuario_responsavel());
                sql.append(",").append(treino_redes.getPesoalfa());
                sql.append(",").append(treino_redes.getPesobeta());
                sql.append(")");
                //System.out.println(sql);
              this.conn.execute(sql.toString());
            } 
            else {//se o valor for diferente de 0 tem que editar os dados 
                 StringBuilder sql=new StringBuilder();
                sql.append("UPDATE treino_redes SET id_treino=").append(treino_redes.getId_treino());
                sql.append(",data_treino='").append(treino_redes.getData_treino());
                sql.append("',nume_interacao=").append(treino_redes.getNumero_interacao());
                sql.append(",usuario_responsavel=").append(treino_redes.getUsuario_responsavel());
                sql.append(",pesoalfa=").append(treino_redes.getPesoalfa());
                sql.append(",pesobeta=").append(treino_redes.getPesobeta());
                sql.append(" where id_treino =").append(treino_redes.getId_treino());
           
               // System.out.println(sql);
                this.conn.execute(sql.toString());
            }
            salva=true;
        } catch (Exception e) {
           this.conn.close();
        }
        return salva;
    }
      
      
}
