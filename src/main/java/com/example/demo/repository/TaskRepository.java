package com.example.demo.repository;

import com.example.demo.model.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
    Task save(Task task);
    Iterable<Task> findAll();
    void deleteById(long id);
    Optional<Object> findById(long id);
    @Modifying
    @Query("UPDATE Task t SET t.done = TRUE WHERE t.id = :id")
    void markAsDone(@Param("id") Long id);
}
