package com.springboot.webapplication.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class todoController {

    @Autowired
    private todoService todoService;

    @RequestMapping("/todo-list")
    public String todoPage(Model model) {
        List<todo> todos = todoService.getTodos();
        model.addAttribute("todos", todos);

        return "todo-list";
    }

    @RequestMapping(value = "/todo-add", method = RequestMethod.GET)
    public String showTodo(Model model) {
        todo todo = new todo(todoService.getTodoCounter() + 1, (String) model.getAttribute("name"), "",
                LocalDate.now().plusYears(1), false);
        model.addAttribute("todo", todo);
        return "todo-add";
    }

    @RequestMapping(value = "/todo-add", method = RequestMethod.POST)
    public String addTodo(@Valid todo todo, BindingResult result) {

        if (result.hasErrors()) {

            return "todo-add";
        }
        /*
         * todoService.addTodo((String)model.getAttribute("name"),description,
         * // LocalDate.now().plusYears(1), done);
         */
        todoService.addTodo(todo.getUsername(), todo.getDescription(), todo.getTargetDate(), todo.isDone());
        return "redirect:/todo-list";
    }

    @RequestMapping("/todo-delete")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteTodoById(id);

        return "redirect:/todo-list";
    }

    @RequestMapping("/todo-update")
    public String showUpdateTodo(@RequestParam int id, Model model) {
        todo todo = todoService.findTodoById(id);
        model.addAttribute("todo", todo);

        return "/todo-add";
    }

    @RequestMapping(value = "/todo-update", method = RequestMethod.POST)
    public String updateTodo(@RequestParam int id, Model model, @Valid todo todo, BindingResult result) {

        if (result.hasErrors()) {

            return "/todo-add";
        }

        todoService.updateTodoById(id, todo);

        return "redirect:/todo-list";
    }

}
