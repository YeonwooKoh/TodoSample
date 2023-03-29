package com.gogo.sample.todo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String addTodo(@ModelAttribute TodoDTO todoDTO) {

        todoService.addTodo(todoDTO);

        return "redirect:/";
    }

    @GetMapping("/getTodo")
    public ResponseEntity<Map<String, Object>> getTodo(@RequestParam Long taskId){

        TodoDTO todoDTO = todoService.findById(taskId);

        if (todoDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        
        Map<String, Object> result = new HashMap<>();

        result.put("taskId", todoDTO.getTaskId());
        result.put("taskName", todoDTO.getTaskName());
        result.put("dueDate", todoDTO.getDueDate());

        return ResponseEntity.ok(result);
    }


    @PostMapping("/editTodo")
    public String editTodo(@ModelAttribute TodoDTO todoDTO) {

        todoService.editTodo(todoDTO);

        return "redirect:/";
    }

    
    @PostMapping("/deleteTodo")
    public String deleteTodo(TodoDTO todoDTO) {

        todoService.delete(todoDTO.getTaskId());

        return "redirect:/";
    }

    
}//class
