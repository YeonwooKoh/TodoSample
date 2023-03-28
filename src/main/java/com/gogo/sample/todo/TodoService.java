package com.gogo.sample.todo;

import java.util.ArrayList;
import java.util.List;

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

    public void editTodo(TodoDTO todoDTO) {

        todoRepository.save(Todo.toEditTodoEntity(todoDTO));

    }




    


}
