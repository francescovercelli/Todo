package com.esercizio.toDoList.Context;

import java.sql.Date;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.esercizio.toDoList.entities.Categories;
import com.esercizio.toDoList.entities.Tasks;

@Configuration
public class EntitiesContext {
    
    @Bean
    @Scope("prototype")
    public Categories newCategories(Map<String,String> params)
    {
        int id = params.containsKey("id") ? Integer.parseInt(params.get("id")) : -1;
        String name = params.containsKey("name_") ? params.get("id") : "";

        return new Categories(id, name);
    }


    // private String description_;
    // private Date due_date;
    // private boolean completed;
    // private int category_id;

    @Bean
    @Scope("prototype")
    public Tasks newTasks(Map<String,String> params)
    {
        int id = params.containsKey("id") ? Integer.parseInt(params.get("id")) : -1;
        String description = params.containsKey("description_") ? params.get("description_") : "";
        Date date = params.containsKey("due_date") ? Date.valueOf(params.get("due_date")) : Date.valueOf("");
        boolean completed = params.containsKey("completed") ? params.get("completed").equals("true") : false;
        int category_id = params.containsKey("category_id") ? Integer.parseInt(params.get("category_id")) : -1;

        return new Tasks(id, description, date, completed, category_id);
    }
}
