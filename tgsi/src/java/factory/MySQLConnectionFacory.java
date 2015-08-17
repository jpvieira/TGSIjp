/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 *
 * @author jp
 */
public final class MySQLConnectionFacory extends ConectionDB{

    public MySQLConnectionFacory(String [] params) {
        this.params=params;
        this.open();
        }

           @Override
    public Connection open() {
               try {
                   Class.forName("com.mysql.jdbc.Driver");
                   this.connection= DriverManager.getConnection("jdbc:mysql://localhost/"+this.params[0],this.params[1],this.params[2]);
                   
               } catch (Exception e) {
                   e.printStackTrace();
               }
               return this.connection;
    }
    
}
