package com.yammar.tasks.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate dueDate;
	private boolean completed;

}
