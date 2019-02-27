package com.yammar.tasks.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yammar.tasks.domain.Task;
import com.yammar.tasks.services.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	private TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	// works for localhost:8080 or localhost:8080/
	// we ca use use @requestMapping
	@GetMapping(value = { "", "/" })
	public Iterable<Task> listTasks() {
		return this.taskService.listTasks();
	}

	// /api/tasks/save
	@PostMapping("/save")
	public Task saveTask(@RequestBody Task task) {
		return this.taskService.save(task);
	}

}
