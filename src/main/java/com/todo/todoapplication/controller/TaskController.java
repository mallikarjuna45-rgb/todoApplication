package com.todo.todoapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.todo.todoapplication.models.Task;
import com.todo.todoapplication.models.User;
import com.todo.todoapplication.service.TaskService;
import com.todo.todoapplication.service.UserService;

@Controller
@SessionAttributes("user")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService uservice;
    @GetMapping("/tasks")
    public String getTasks(@RequestParam Long userId, Model model) {
        List<Task> tasks = taskService.getAllTasks(userId);
        User user = uservice.findById(userId);
        model.addAttribute("user",user);
        model.addAttribute("tasks", tasks);
        model.addAttribute("userId", userId); // Pass userId to the view for redirection
        return "tasks";
    }

    @PostMapping("/tasks")
    public String createTask(@RequestParam Long userId, @RequestParam String title,Model model) {
        taskService.createTask(userId, title);
        model.addAttribute("msg","task added");
        return "redirect:/tasks?userId="+userId; // Redirect to the user's tasks page
    }

    @GetMapping("/tasks/{userId}/delete/{taskId}")
    public String deleteTask(@PathVariable Long userId, @PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return "redirect:/tasks?userId="+userId; // Redirect to the user's tasks page
    }

    @GetMapping("/tasks/{userId}/toggle/{taskId}")
    public String toggleTask(@PathVariable Long userId, @PathVariable Long taskId) {
        taskService.toggleTask(taskId);
        return "redirect:/tasks?userId="+userId; // Redirect to the user's tasks page
    }
}
