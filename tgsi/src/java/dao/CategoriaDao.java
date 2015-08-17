/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Usuario;
import modelo.Diabete_pima;

/**
 *
 * @author jp
 */
public interface CategoriaDao {
    
    public  List<Usuario> list();
    public Usuario edit(int id);
    public boolean salva(Usuario categoria);
    public boolean  delete(int id);
    public List<Diabete_pima> listapima();
    
    
    
}
