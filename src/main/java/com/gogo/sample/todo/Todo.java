package com.gogo.sample.todo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private String taskName;

    private LocalDate dueDate;


    public static Todo toTodoEntity(TodoDTO todoDTO) {
        
        Todo todo = new Todo();

        todo.setTaskName(todoDTO.getTaskName());
        todo.setDueDate(todoDTO.getDueDate());

        return todo;
    
    }

    public static Todo toEditTodoEntity(TodoDTO todoDTO) {

        Todo todo = new Todo();

        todo.setTaskId(todoDTO.getTaskId());
        todo.setTaskName(todoDTO.getTaskName());
        todo.setDueDate(todoDTO.getDueDate());

        return todo;
        
    }


}//class
