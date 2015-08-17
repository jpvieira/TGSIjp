/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import javax.management.Query;

/**
 *
 * @author jp
 */
public abstract class ConectionDB {
   protected String[]  params;
   protected Connection connection;
   
   abstract Connection open();
   
   public ResultSet query(String query){
       Statement st;
       ResultSet rs = null;
       try {
           st =connection.createStatement();
           rs= st.executeQuery(query);
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return rs;
    }
   
    public boolean execute(String query){
       Statement st;
      boolean save= true;
       try {
           st =connection.createStatement();
        st.executeUpdate(query);
       } catch (SQLException e) {
           save=false;
           e.printStackTrace();
       }
       return save;
    }
    
    public boolean close(){
        
        boolean ok= true;
        try {
            connection.close();
        } catch (Exception e) {
            ok=false;
        }
        return ok;
    }
}
