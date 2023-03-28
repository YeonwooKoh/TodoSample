package com.gogo.sample.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
    private final TodoRepository todoRepository;

    @GetMapping("/")

    public String showTodoList(Model model) {

        List<Todo> todoList = todoRepository.findAll();
        model.addAttribute("tasks", todoList);
        return "index";
    }

    @PostMapping("/addTodo")
    public String addTodo(@RequestParam String taskName, 
                        @RequestParam String dueDate) {
        Todo todo = new Todo();
        todo.setName(taskName);
        todo.setDueDate(LocalDate.parse(dueDate));
        todoRepository.save(todo);
        return "redirect:/";
    }

    /* 
    @PostMapping("/editTodo")
    public String editTodo(@RequestParam Long id, @RequestParam String taskName, @RequestParam String dueDate) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid todo item id: " + id));
        todo.setName(taskName);
        todo.setDueDate(LocalDate.parse(dueDate));
        todoRepository.save(todo);
        return "redirect:/";
    }

    @GetMapping("/deleteTodo/{id}")
    public String deleteTodo(@PathVariable Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid todo item id: " + id));
        todoRepository.delete(todo);
        return "redirect:/";
    }
    */
    
}//class
