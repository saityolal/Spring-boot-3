package com.springboot.webapplication.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.springboot.webapplication.login.AuthenticationService;

import java.time.LocalDate;
import java.util.List;

@Controller
// @SessionAttributes("name")
public class todoControllerJpa {

    @Autowired
    private todoRepository todoRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping("/todo-list")
    public String todoPage(Model model) {

        List<todo> todos = todoRepository.findAll();
        model.addAttribute("todos", todos);

        return "todo-list";
    }

    @RequestMapping(value = "/todo-add", method = RequestMethod.GET)
    public String showTodo(Model model) {
        todo todo = new todo(todoService.getTodoCounter()+ 1, authenticationService.getLoggedinUsername(), "",
                LocalDate.now().plusYears(1), false);
        model.addAttribute("todo", todo);
        return "todo-add";
    }

    @RequestMapping(value = "/todo-add", method = RequestMethod.POST)
    public String addTodo(@Valid todo todo, BindingResult result, Model model) {

        if (result.hasErrors()) {

            return "todo-add";
        }
        todo.setUsername(authenticationService.getLoggedinUsername());
        todoRepository.save(todo);

        return "redirect:/todo-list";
    }

    @RequestMapping("/todo-delete")
    public String deleteTodo(@RequestParam int id) {

        todoRepository.deleteById(id);
        return "redirect:/todo-list";
    }

    @RequestMapping("/todo-update")
    public String showUpdateTodo(@RequestParam int id, Model model) {
        todo todo = todoRepository.findById(id);
        model.addAttribute("todo", todo);

        return "todo-add";
    }

    @RequestMapping(value = "/todo-update", method = RequestMethod.POST)
    public String updateTodo(@RequestParam int id, @Valid todo todo, BindingResult result) {

        if (result.hasErrors()) {

            return "todo-add";
        }
        todo.setUsername(authenticationService.getLoggedinUsername());
        todoRepository.save(todo);  

        return "redirect:/todo-list";
    }

}
