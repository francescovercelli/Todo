package com.esercizio.toDoList.Controllers;

import com.esercizio.toDoList.Services.TaskService;
import com.esercizio.toDoList.entities.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TasksController {

    @Autowired
    private TaskService taskService;

   
    @GetMapping("api/tasks")
    public List<Tasks> getAllTasks() {
        return taskService.findAll();
    }
}
