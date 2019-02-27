package com.yammar.tasks.repository;

import org.springframework.data.repository.CrudRepository;

import com.yammar.tasks.domain.Task;

public interface TaskRepository extends CrudRepository<Task, Long>{

}
