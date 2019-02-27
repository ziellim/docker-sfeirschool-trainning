package com.yammar.tasks.services;

import com.yammar.tasks.domain.Task;


public interface TaskService {
	
	Iterable<Task> listTasks();
	
	Task save(Task task);

}
