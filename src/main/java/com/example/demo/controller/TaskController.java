package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController{
    @Autowired // Аннотация @Autowired нужна, чтобы Spring подставил bean класса TaskRepository в данный класс.
        private TaskRepository taskRepository;

    // Метод создания новой задачи. "rest по созданию задачи"
    @PostMapping("/tasks") // @PostMapping указывает на то, что метод принимает POST запрос.
    public Task create(@RequestBody Task task) { // Аннотация @RequestBody ставится, если в запросе есть json тело,
        // которое нужно сериализовать в Java объект. В данном случае, мы ожидаем объект класса Task.
            return taskRepository.save(task);
    }

    @PutMapping("/tasks/{id}")
    public Task update(@PathVariable long id, @RequestBody Task task) {//редактирование записи по id
        task.setId(id);
        return taskRepository.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable long id) {//удалить запись по id
        taskRepository.deleteById(id);
    }

    @GetMapping("/tasks/{id}")
    public Task get(@PathVariable long id) {//получить запись по id
        return (Task) taskRepository.findById(id).orElse(null);
    }

    @GetMapping("/tasks")
    public Iterable<Task> get() {//получить все записи
        return taskRepository.findAll();
    }

    @PatchMapping("/tasks/{id}")
    public void patchMethod(@PathVariable Long id,
                            @RequestBody Task task) {
        if(task.isDone()) {
            taskRepository.markAsDone(id);
        }
    }

    @PatchMapping("/tasks/{id}:mark-as-done")
    public void patchMethod(@PathVariable Long id) {
        taskRepository.markAsDone(id);
    }
}