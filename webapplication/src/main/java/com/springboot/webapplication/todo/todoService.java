package com.springboot.webapplication.todo;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class todoService {
    public ArrayList<todo> todos = new ArrayList<>();

    public int getTodoCounter() {
        return todoCounter;
    }

    public void setTodoCounter(int todoCounter) {
        this.todoCounter = todoCounter;
    }

    private int todoCounter = 0;

    public todoService() {

        todos.add(new todo(++todoCounter, "instructor_Springboot", "Learn Spring Boot", LocalDate.now().plusYears(1), true));
        todos.add(new todo(++todoCounter, "instructor_React", "Learn React", LocalDate.now(), true));
        todos.add(new todo(++todoCounter, "instructor_Java", "Learn Java", LocalDate.now().plusYears(2), false));

    }

    public List<todo> getTodos() {
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
    todos.add(new todo(++todoCounter, username, description, LocalDate.now().plusYears(1), done));
    }
}
