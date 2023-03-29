package com.gogo.sample.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {
    
    private final TodoRepository todoRepository;

    public List<TodoDTO> findAll() {

        List<Todo> todoList=todoRepository.findAll();
        List<TodoDTO> todoDTOList=new ArrayList<>();

        for(Todo todo: todoList){

            todoDTOList.add(TodoDTO.toTodoDTO(todo));

        }

        return todoDTOList;
    }

    public void addTodo(TodoDTO todoDTO) {

        Todo todo = Todo.toTodoEntity(todoDTO);
        todoRepository.save(todo);

    }

    public TodoDTO findById(Long taskId) {

        Optional<Todo> optionalTodo = todoRepository.findById(taskId);

        if(optionalTodo.isPresent()) return TodoDTO.toTodoDTO(optionalTodo.get());
        else return null;

    }


    public void editTodo(TodoDTO todoDTO) {

        todoRepository.save(Todo.toEditTodoEntity(todoDTO));

    }

    public void delete(Long taskId) {

        todoRepository.deleteById(taskId);

    }


}//class
