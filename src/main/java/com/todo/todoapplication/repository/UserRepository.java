package com.todo.todoapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.todoapplication.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   User findByName(String username);
}