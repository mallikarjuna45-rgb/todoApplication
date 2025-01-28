package com.todo.todoapplication.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Task {
	@Id
	@SequenceGenerator(
			name="task_seq",
			sequenceName="task_seq",
			allocationSize=1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "task_seq"
			)
	private Long id;
	private String title;
	private boolean completed;
	@ManyToOne(
			cascade = CascadeType.ALL
			)
	@JoinColumn(
			name = " user_id",
			referencedColumnName ="id",
			nullable=false
	)
	private User user;
	
	public Task() {
		super();
	}
	public Task(Long id, String title, boolean completed, User user) {
		super();
		this.id = id;
		this.title = title;
		this.completed = completed;
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", completed=" + completed + ", user=" + user + "]";
	}
	
	
	
}
