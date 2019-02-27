package com.yammar.tasks.services;

import org.springframework.stereotype.Service;

import com.yammar.tasks.domain.Task;
import com.yammar.tasks.repository.TaskRepository;


@Service
public class TaskServiceImpl implements TaskService {

	private TaskRepository taskRepo;

	public TaskServiceImpl(TaskRepository taskRepo) {
		this.taskRepo = taskRepo;
	}

	@Override
	public Iterable<Task> listTasks() {
		return this.taskRepo.findAll();
	}

	@Override
	public Task save(Task task) {
		return this.taskRepo.save(task);
	}

}
