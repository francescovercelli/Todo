package com.esercizio.toDoList.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.esercizio.toDoList.entities.Entity;
import com.esercizio.toDoList.entities.Tasks;

import com.esercizio.toDoList.dao.Database;

import com.esercizio.toDoList.entities.Categories;

public class CategoriesDao implements IDAO {

     @Autowired
    private Database database;
    @Autowired
    private ApplicationContext context;

    @Override
   public void create(Entity e) {
        String query = "insert into Categories(name_) values (?)";
        PreparedStatement ps = null;
        try{
            Categories c = (Categories)e;
            ps = database.getConnection().prepareStatement(query);
            ps.setString(1, c.getName_());
            ps.executeUpdate();
        }
        catch(SQLException exc){
            System.out.println("Errore inserimento categories: " + exc.getMessage());
        }
        catch(ClassCastException exc){
            System.out.println("Errore tipo dato errato in CategoriesDao");
        }
        finally{
            try{
                ps.close();
            }
            catch(Exception exc){
                System.out.println("Errore chiusura PreparedStatement");
            }
        }
    }

    public Map<Integer, Entity> read() {
        String query = "select * from Categories ";
        PreparedStatement ps = null;
        ResultSet rs = null;

        Map<Integer, Entity> ris = new HashMap<>();
        
        
        try {
            ps = database.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) 
            {
                Map<String, String> params = new HashMap<>();

                params.put("id", rs.getInt(1)+"");
                params.put("name_", rs.getString(2));

                Categories e = context.getBean(Categories.class, params);

                ris.put(e.getId(), e);
            }
        }
        catch(SQLException exc) {
            System.out.println("Errore nella select in CategoriesDAO");
        }
        finally{
             try {
                ps.close();
                rs.close();
            } catch (Exception exc) {
                  System.out.println("Errore chiusura PreparedStatement");
            }
        }
        return ris;
    }


    @Override
    public void update(Entity e) throws ClassCastException {
        String query = "update categories set name_ =? where id =?";
        PreparedStatement ps = null;
        try {
            Categories c = (Categories)e;
            ps = database.getConnection().prepareStatement(query);
            ps.setString(1, c.getName_());
            ps.setInt(2, c.getId());
        } catch (Exception exc) {
            System.out.println("Errore aggiornamento Categories: " + exc.getMessage());
        }
        finally{
            try {
                ps.close();
            } catch (Exception exc) {
                System.out.println("Errore chiusura PreparedStatement");
            }
        }  
    }

    @Override
    public void delete(int id) {
      String query = "delete from Categories where id =?";
      PreparedStatement ps = null;
      try {
        ps = database.getConnection().prepareStatement(query);
        ps.setInt(1, id);
      } catch (SQLException exc) {
        System.out.println("Errore cancellazione Categories: " + exc.getMessage());
      }
        finally{
            try{
            ps.close();
        }
        catch(Exception exc) {
            System.out.println("Errore chiusura prepareStatement");
        }
      }
    }

    
}
