package com.gogo.sample.todo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository <Todo, Long> {
    
    Optional<Todo> findById(Long taskId);


}
