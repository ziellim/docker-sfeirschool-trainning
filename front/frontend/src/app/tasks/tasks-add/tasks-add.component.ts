import { TaskService } from './../task.service';
import { Component, OnInit } from '@angular/core';
import { Task } from 'app/tasks/task.model';

@Component({
  selector: 'app-tasks-add',
  templateUrl: './tasks-add.component.html',
  styleUrls: ['./tasks-add.component.css']
})
export class TasksAddComponent implements OnInit {
  taskName: string;

  constructor(private taskService: TaskService) { }

  ngOnInit() {
  }

  onTaskAdd() {
    let task = new Task(this.taskName, false, this.getTodayAsString());
    this.taskService.addTask(task);
    this.taskName = '';
  }


  getTodayAsString() {
    let toDay = new Date();
    let dd: any = toDay.getDate();
    let mm: any = toDay.getMonth() + 1;
    let yyyy: any = toDay.getFullYear();

    if (dd < 10) {
      dd = '0' + dd;
    }
    if (mm < 10) {
      mm = '0' + mm;
    }
    return mm + '/' + dd + '/' + yyyy;
  }

}
