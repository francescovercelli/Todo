import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { Task } from '../model/task';
import { TaskService } from '../task-service.service';

@Component({
  selector: 'app-task-list-component',
  templateUrl: './task-list-component.component.html',
  styleUrls: ['./task-list-component.component.css']
})
export class TaskListComponentComponent implements OnInit {
  tasks : Task[] = [];

  constructor(private taskService: TaskService) {
   
   }
 
  ngOnInit(): void {
    this.taskService.getAllTasks().subscribe(tasks => this.tasks = tasks);
    
  }
}
