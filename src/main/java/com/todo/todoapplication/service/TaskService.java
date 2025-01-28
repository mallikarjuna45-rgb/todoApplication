package com.todo.todoapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.todoapplication.models.Task;
import com.todo.todoapplication.models.User;
import com.todo.todoapplication.repository.TaskRepository;
import com.todo.todoapplication.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepo;

    @Autowired
    private UserRepository urepo;

    public List<Task> getAllTasks(Long userId) {
        return taskRepo.findAllByUserId(userId);
    }

    public void createTask(Long userId, String title) {
        User user = urepo.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid User ID"));
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        task.setUser(user);
        taskRepo.save(task);
    }
    @Transactional
    public void deleteTask(Long taskId){
//        Task task = taskRepo.findById(taskId)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid Task ID"));
//       
//        taskRepo.delete(task);
    	
            taskRepo.deleteTaskById(taskId);
    }

    public void toggleTask(Long taskId) {
        Task task = taskRepo.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Task ID"));
        task.setCompleted(!task.isCompleted());
        taskRepo.save(task);
    }
}
