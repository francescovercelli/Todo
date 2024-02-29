package com.esercizio.toDoList.Services;

import com.esercizio.toDoList.dao.TasksDao;
import com.esercizio.toDoList.entities.Entity;
import com.esercizio.toDoList.entities.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TaskService {
    @Autowired
    private TasksDao tasksdao;
    @Autowired
    private ApplicationContext context;

    public  List<Tasks> findAll(){

        //salvo i dati della read nella mappa che abbiamo chiamata data
        Map<Integer, Entity> data = tasksdao.read();
        List<Tasks> ris = new ArrayList<>();

        //con il ciclo for cicliamo i valori della mappa data e li salviamo nella lista paziente
        for(Entity e : data.values()){
            if(e instanceof Tasks){
                ris.add((Tasks) e);
            }
        }

        return ris;
    }

    public Tasks findById(int id){
        Map<Integer, Entity> data = tasksdao.read();

        return (Tasks) data.get(id);
    }

    public List<Tasks> findByNome(String nome){
        Map<Integer, Entity> data = tasksdao.read();
        List<Tasks> ris = new ArrayList<>();

        for(Entity e : data.values()){
            if(e instanceof Tasks){
                ris.add((Tasks) e);
            }
        }

        return ris;
    }


    public void insertTask(Map<String, String> params){
        Tasks t = context.getBean(Tasks.class, params);
        tasksdao.create(t);
    }

    public void updateTask(Map<String, String> params){
        Tasks t = context.getBean(Tasks.class, params);
        tasksdao.update(t);
    }

    public void deleteTask(int id){
        tasksdao.delete(id);
    }

    
}

