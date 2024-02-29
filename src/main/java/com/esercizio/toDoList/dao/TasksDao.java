package main.java.com.esercizio.toDoList.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import main.java.com.esercizio.toDoList.entities.Tasks;

public class TasksDao implements IDAO{
    @Autowired
    private Database database;
    @Autowired
    private ApplicationContext context;

    public void create(Entity e) {
        String query = "insert into Tasks(description_, due_date, completed, category_id) values (?),(?),(?),(?) ";
        PreparedStatement ps = null;
        try{
            Tasks t = (Task)e;
            ps = database.getConnection().prepareStatement(query);
            ps.setString(1, t.getNome());
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
            
            while (re.next()) 
            {
                Map<Integer, Entity> params = new HashMap<>();

                params.put("id", rs.getInt(1)+"");
                params.put("description_", rs.getString(2));
                params.put("due_date", rs.getString(3));
                params.put("completed", rs.getBoolean(4));

                Tasks e = context.getBean(Tasks.class, params);

                ris.put(e.getId(), e);
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





