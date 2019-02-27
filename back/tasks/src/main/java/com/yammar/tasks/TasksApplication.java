package com.yammar.tasks;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.yammar.tasks.domain.Task;
import com.yammar.tasks.services.TaskService;

@SpringBootApplication
public class TasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(TaskService taskService) {
		return args -> {
			taskService.save(new Task(1L, "spring boot first task", LocalDate.now(), true));
			taskService.save(new Task(2L, "spring boot second task", LocalDate.now().plus(1, ChronoUnit.DAYS), false));
			taskService.save(new Task(3L, "spring boot third task", LocalDate.now().plus(2, ChronoUnit.DAYS), false));
		};
	}
}
