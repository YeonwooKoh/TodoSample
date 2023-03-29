package com.gogo.sample.todo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class TodoDTO {

    private Long taskId;
    private String taskName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    public static TodoDTO toTodoDTO(Todo todo) {
        
        TodoDTO todoDTO=new TodoDTO();

        todoDTO.setTaskId(todo.getTaskId());
        todoDTO.setTaskName(todo.getTaskName());
        todoDTO.setDueDate(todo.getDueDate());
        
        return todoDTO;
    }


    
}
