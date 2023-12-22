package com.example.securitycsrfdemo.web.controller;


import com.example.securitycsrfdemo.model.Todo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {


    private final List<Todo> todos = generateTodos();

    private List<Todo> generateTodos() {
        List<Todo> todos = new ArrayList<>();
        for (long i = 1; i <= 10; i++) {
            todos.add(new Todo(i,"Task " + i));
        }
        return todos;
    }


    @GetMapping("/home")
    public ModelAndView getTodos() {

        ModelAndView mav = new ModelAndView("home");
        mav.addObject("todos", todos);
        return mav;
    }

    @GetMapping("/")
    public ModelAndView  homePage() {

        ModelAndView mav = new ModelAndView("home");
        mav.addObject("todos", todos);
        return mav;
    }

    @GetMapping("/home/add")
    public String showTodo() {
       return "add";
    }
    @PostMapping("/home/add")
    public ResponseEntity<String> addTodo(@RequestBody Todo todo) {
        // Add todo to the list
        todos.add(todo);
        return ResponseEntity.ok("Todo added successfully");
    }

    @SessionScope
    @GetMapping("/home/delete/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable long id) {
        todos.removeIf(todo -> todo.getId() == id);
        return ResponseEntity.ok().build();
    }
}
