package com.todo.todoapplication.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class User {
	
	@Id
	@SequenceGenerator(
			name ="user_seq",
			sequenceName="user_seq",
			allocationSize=1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator="user_seq"
	)
	private Long id;
	@Column(unique = true,nullable=false)
	private String name;
	@Column(unique = true,nullable=false)
	private String email;
	@Column(nullable=false)
	private String password;
	@OneToMany(
			mappedBy="user",
			cascade = CascadeType.ALL
			)
	private List<Task> tasks;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public User(Long id, String name, String email, String password, List<Task> tasks) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.tasks = tasks;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", tasks=" + tasks
				+ "]";
	}
	
}
