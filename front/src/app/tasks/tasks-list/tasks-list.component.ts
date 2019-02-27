import { TaskService } from './../task.service';
import { Component, OnInit } from '@angular/core';
import { Task } from 'app/tasks/task.model';

@Component({
  selector: 'app-tasks-list',
  templateUrl: './tasks-list.component.html',
  styleUrls: ['./tasks-list.component.css']
})
export class TasksListComponent implements OnInit {

  tasks: Task[] = [];

  constructor(private taskService: TaskService) { }

  ngOnInit() {
    this.taskService.getTasks();
    this.taskService.onTaskChanged.subscribe((tasks: Task[]) => {
      this.tasks = tasks;
    });
  }


  onTaskChange(event, task: Task) {
    this.taskService.saveTask(task, event.target.checked).subscribe();
  }

  getDueDateLabel(task: Task) {
    return task.completed ? 'label-success' : 'label-primary';
  }


}
