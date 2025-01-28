package com.todo.todoapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.todo.todoapplication.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{


	public List<Task> findAllByUserId(Long Id);
	@Modifying
    @Query("DELETE FROM Task t WHERE t.id = :taskId")
    void deleteTaskById(@Param("taskId") Long taskId);
}
