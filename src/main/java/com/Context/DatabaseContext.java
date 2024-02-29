package com.Context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.esercizio.toDoList.dao.CategoriesDao;
import com.esercizio.toDoList.dao.Database;
import com.esercizio.toDoList.dao.TasksDao;

@Configuration
public class DatabaseContext {
    
    @Bean
    public Database newDatabase()
    {
        return new Database("ToDoApp");
    }

    @Bean
    public CategoriesDao newCategoriesDao()
    {
        return new CategoriesDao();
    }

    @Bean
    public TasksDao newTasksDao()
    {
        return new TasksDao();
    }
}
