import { Task } from "app/tasks/task.model";
import { Injectable } from "@angular/core";
import { Http, Response } from "@angular/http";

import "rxjs/add/operator/map";
import { Subject } from "rxjs/Subject"


@Injectable()
export class TaskService {

    onTaskChanged = new Subject<Task[]>();
    tasks: Task[] = [];

    constructor(private http: Http) {

    }

    saveTask(task: Task, checked: boolean) {
        task.completed = checked;
        return this.http.post('/api/tasks/save', task)
            .map((response: Response) => { return response.json() });
    }

    getTasks() {
        return this.http.get('/api/tasks')
            .map(response => {
                return response.json();
            }
            ).subscribe((tasks: Task[]) => {
                this.tasks = tasks;
                this.onTaskChanged.next(this.tasks);
            }, (error) => {
                console.log(error);
            });
    }

    addTask(task: Task) {
        return this.http.post('/api/tasks/save', task)
            .map((response: Response) => { return response.json() })
            .subscribe((task: Task) => {
                this.tasks.push(task);
                this.onTaskChanged.next(this.tasks.slice());
            }, (error) => console.log(error));
    }
}