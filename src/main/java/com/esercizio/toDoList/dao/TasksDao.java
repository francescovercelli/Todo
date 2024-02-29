package com.esercizio.toDoList.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.config.Task;

import com.esercizio.toDoList.entities.Entity;
import com.esercizio.toDoList.entities.Tasks;

public class TasksDao implements IDAO{
    @Autowired
    private Database database;
    @Autowired
    private ApplicationContext context;

    public void create(Entity e) {
        String query = "insert into Tasks(description_, due_date, completed, category_id) values (?,?,?,?) ";
        PreparedStatement ps = null;
        try{
            Tasks t = (Tasks)e;
            ps = database.getConnection().prepareStatement(query);
            ps.setString(1, t.getDescription_());
            ps.setDate(2, new Date(t.getDue_date().getTime()));
            ps.executeUpdate();
        }
        catch(SQLException exc){
            System.out.println("Errore inserimento attività: " + exc.getMessage());
        }
        catch(ClassCastException exc){
            System.out.println("Errore tipo dato errato in TasksDAO");
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
        String query = "select * from Tasks ";
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
                params.put("description_", rs.getString(2));
                params.put("due_date", rs.getDate(3)+"");
                params.put("completed", rs.getBoolean(4)+"");

                Tasks e = context.getBean(Tasks.class, params);

                ris.put(e.getId(), e);
            }
        }
        catch(SQLException exc) {
            System.out.println("Errore nella select in TasksDAO");
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
        String query = "update Tasks set description_ =?, due_date =?, completed =? where id =?";
        PreparedStatement ps = null;
        try {
            Tasks t = (Tasks)e;
            ps = database.getConnection().prepareStatement(query);
            ps.setString(1, t.getDescription_());
            ps.setDate(2, t.getDue_date());
            ps.setBoolean(3, t.isCompleted());
            ps.setInt(4, t.getId());
        } catch (Exception exc) {
            System.out.println("Errore aggiornamento Tasks: " + exc.getMessage());
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
      String query = "delete from Tasks where id =?";
      PreparedStatement ps = null;
      try {
        ps = database.getConnection().prepareStatement(query);
        ps.setInt(1, id);
      } catch (SQLException exc) {
        System.out.println("Errore cancellazione Tasks: " + exc.getMessage());
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