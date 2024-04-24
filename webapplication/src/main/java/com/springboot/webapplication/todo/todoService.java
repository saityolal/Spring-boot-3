package com.springboot.webapplication.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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

        todos.add(new todo(++todoCounter, "instructor_Springboot", "Learn Spring Boot", LocalDate.now().plusYears(1),
                true));
        todos.add(new todo(++todoCounter, "instructor_React", "Learn React", LocalDate.now(), true));
        todos.add(new todo(++todoCounter, "instructor_Java", "Learn Java", LocalDate.now().plusYears(2), false));

    }

    public List<todo> getTodos() {
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        todos.add(new todo(++todoCounter, username, description, targetDate, done));
    }

    public todo findTodoById(int id) {
        todo todo;
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId() == id) {
                todo = todos.get(i);
                return todo;
            }
        }
        return null;
    }

    public void deleteTodoById(int id) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId() == id) {
                todos.remove(i);
                break;
            }
        }
    }

    public void updateTodoById(int id, todo todo) {

        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId() == id) {
                todos.get(i).setId(id);
                todos.get(i).setUsername(todo.getUsername());
                todos.get(i).setDescription(todo.getDescription());
                todos.get(i).setTargetDate(todo.getTargetDate());
                todos.get(i).setDone(todo.isDone());
                break;
            }
        }
    }

    public List<todo> findByUsername(String username) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getUsername() == username) {
                    
                return (List<todo>) todos.get(i);
            }
        }
        return todos;
    }
}
