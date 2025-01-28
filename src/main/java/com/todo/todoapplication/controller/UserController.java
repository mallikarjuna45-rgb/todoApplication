package com.todo.todoapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.todo.todoapplication.models.User;
import com.todo.todoapplication.service.UserService;

@Controller
public class UserController {
		@Autowired
		private UserService uservice;
		
		@GetMapping("/login")
		public String loginPage() {
			return "login";
		}
		
		@PostMapping("/login")
		public String loginUser(@RequestParam String name, @RequestParam String password,ModelMap model) {
			User user = uservice.authenticate(name, password);
			if(user == null) {
				model.addAttribute("error","Invalid User Name or password");
				return "login";
			}
			model.put("name", name);
		return "redirect:/tasks?userId="+user.getId();
		}
		
		@GetMapping("/regi")
		public String regiPage() {
			return "regi";
		}
		@PostMapping("/regi")
		public String regi(@ModelAttribute User user) {
			uservice.save(user);
			return "login";
		}
		
}
