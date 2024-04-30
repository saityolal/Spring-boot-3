package com.springboot.webapplication.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface todoRepository extends JpaRepository<todo, Integer> {

    public todo findById(int id);

    public List<todo> findByUsername(String username);

    // public todo updateTodoById(int id, todo todo);
}
