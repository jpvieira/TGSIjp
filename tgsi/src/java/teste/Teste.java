/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dao.CategoriaDaoImpl;
import dao.CategoriaDao;
import java.util.List;
import modelo.Amostra_paci;
import modelo.Diabete_pima;
import modelo.Treino_redes;
import modelo.Usuario;

/**
 *
 * @author jp
 */
public class Teste {
    public static void main(String[]args){
        
        Teste teste= new Teste();
       //teste.listapima();
        //teste.listausuarios();
        //teste.editusuario();
      // teste.salvausuario();
       // teste.deletarusuario();
       // teste.listaMysql();
        teste.listaamostra_paci();
        //teste.editamostrapaci();
        //teste.salva_amostra();
        //teste.deletaramostra();
        //teste.listatreino_redes();
          //teste.salvarTreino();
    }
    
    
    public void listapima(){
        CategoriaDaoImpl categoriaDao = new CategoriaDaoImpl();
        List<Diabete_pima> lista=categoriaDao.lista_Diabetepima();
        for (Diabete_pima categoria : lista) {
            System.out.println("id pima: "+categoria.getId_pima()+"nb_pregnant: "+categoria.getNb_pregnant()+"plasma glucose: "+categoria.getPlasma_glucose()+"diastolic: "+categoria.getDiastolic()+"	triceps_skin"+categoria.getTriceps_skin()+"serum_insulin: "+categoria.getSerum_insulin()+"body_mass: "+categoria.getBody_mass()+"diabetes: "+categoria.getDiabetes()+"age: "+categoria.getAge()+"classe: "+categoria.getClasse());
            
        }              
        }
    public void listausuarios(){
        CategoriaDaoImpl categoriaDao = new CategoriaDaoImpl();
        List<Usuario> lista=categoriaDao.listusuarios();
        for (Usuario usuario : lista) {
            System.out.println("id usuario: "+usuario.getId_usuario()+" nome: "+usuario.getNome_usuario()+" telefone: "+usuario.getTelefone()+" email: "+usuario.getEmail()+" senha: "+usuario.getSenha());
            
        }
    }
    
    public void editusuario(){
                CategoriaDaoImpl categoriaDao = new CategoriaDaoImpl();
                Usuario usuario=categoriaDao.edit(1);
                System.out.println("Id:"+usuario.getId_usuario()+"nome: "+usuario.getNome_usuario()+" telefone: "+usuario.getTelefone()+" email: "+usuario.getEmail()+" senha: "+usuario.getSenha());

    }
 
    public void salvausuario(){
         CategoriaDaoImpl categoriaDao = new CategoriaDaoImpl();
        Usuario usuario=new Usuario();
        usuario.setNome_usuario("usuario salvo pelo programa");
        usuario.setId_usuario(0);
        usuario.setEmail("teste@teste");
        usuario.setTelefone("888888");
        usuario.setSenha("0002222teste");
        categoriaDao.salva(usuario);
}
       
    public void deletarusuario(){
          CategoriaDaoImpl categoriaDao = new CategoriaDaoImpl();
        categoriaDao.deleteusuario(3);

    }
    
     public void listaamostra_paci(){
        CategoriaDaoImpl categoriaDao = new CategoriaDaoImpl();
        List<Amostra_paci> lista=categoriaDao.lista_amostra_paci();
        for (Amostra_paci amostra_paci : lista) {
            
            System.out.println("id amostra: "+amostra_paci.getId_amostra()+" age_amostra: "+amostra_paci.getAge_amostra()+" body_mass_amostra: "+amostra_paci.getBody_mass_amostra()+" class_amostra: "+amostra_paci.getClass_amostra()+" data_amostra: "+amostra_paci.getData_amostra()+" diabetes_amostra:"+amostra_paci.getDiabetes_amostra()+" diastolic_amostra:"+amostra_paci.getDiastolic_amostra()+" nbpregnant_amostra:"+amostra_paci.getNbpregnant_amostra()+" plasma_glucose_amostra:"+amostra_paci.getPlasma_glucose_amostra()+"Coluna\n" +
"serum_isulin:"+amostra_paci.getSerum_isulin()+"triceps_skin_amostra:"+ amostra_paci.getTriceps_skin_amostra());
            
        }
    System.out.println("passou");
     }
     
       public void editamostrapaci(){
                CategoriaDaoImpl categoriaDao = new CategoriaDaoImpl();
                Amostra_paci amostra_paci=categoriaDao.edit_amostra(1);
                System.out.println("id amostra: "+amostra_paci.getId_amostra()+" age_amostra: "+amostra_paci.getAge_amostra()+" body_mass_amostra: "+amostra_paci.getBody_mass_amostra()+" class_amostra: "+amostra_paci.getClass_amostra()+" data_amostra: "+amostra_paci.getData_amostra()+" diabetes_amostra:"+amostra_paci.getDiabetes_amostra()+" diastolic_amostra:"+amostra_paci.getDiastolic_amostra()+" nbpregnant_amostra:"+amostra_paci.getNbpregnant_amostra()+" plasma_glucose_amostra:"+amostra_paci.getPlasma_glucose_amostra()+"Coluna\n" +
                "serum_isulin:"+amostra_paci.getSerum_isulin()+"triceps_skin_amostra:"+ amostra_paci.getTriceps_skin_amostra());
            
    }
       public  void salva_amostra(){
           CategoriaDaoImpl categoriaDao = new CategoriaDaoImpl();
        
           for (int i = 0; i < 10; i++) {
               
           
           Amostra_paci amostra_paci=new Amostra_paci();
           amostra_paci.setId_amostra(0);
           amostra_paci.setAge_amostra(15+i);
           amostra_paci.setBody_mass_amostra((float) 9.89+i*2);
           amostra_paci.setClass_amostra((float) (2+((3*2)/2)));
           amostra_paci.setData_amostra("010104");
           amostra_paci.setDiabetes_amostra((float)34*i/5);
           amostra_paci.setDiastolic_amostra((float)i*2/3);
           amostra_paci.setNbpregnant_amostra(i*32);
           amostra_paci.setPlasma_glucose_amostra((float) 43.4+i/3);
           amostra_paci.setSerum_isulin(32*i+i);
           amostra_paci.setTriceps_skin_amostra(i/32+50);
           categoriaDao.salva_amotra_paci(amostra_paci);
           }
       }
       
        public void deletaramostra(){
          CategoriaDaoImpl categoriaDao = new CategoriaDaoImpl();
        categoriaDao.deleteamostra_usu(2);

    }
       public void listatreino_redes(){
        CategoriaDaoImpl categoriaDao = new CategoriaDaoImpl();
        List<Treino_redes> lista=categoriaDao.lista_treinoRedes();
        for (Treino_redes treino_redes:  lista) {
            
            System.out.println("id treino: "+treino_redes.getId_treino()+" data do treino:"+treino_redes.getData_treino()+" numero de interaçoes= "+treino_redes.getNumero_interacao()+" usuario responsavel: "+treino_redes.getUsuario_responsavel()+" peso alfa: "+treino_redes.getPesoalfa()+" peso beta:"+treino_redes.getPesobeta());
            
        }
     }
     
       
       public void salvarTreino(){
           CategoriaDaoImpl categoriaDao=new CategoriaDaoImpl();
                        Treino_redes treino_redes=new Treino_redes();
                        treino_redes.setId_treino(21);
                        treino_redes.setData_treino("03081993");
                        treino_redes.setNumero_interacao(200000000);
                        treino_redes.setPesoalfa((float) 3.4);
                        treino_redes.setPesobeta((float) 4.0021);
                        treino_redes.setUsuario_responsavel(34);
                        categoriaDao.salva_treino(treino_redes);
              }
           
        
        
}
        

