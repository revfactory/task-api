package com.kakao.osa.taskapi.controller;

import com.kakao.osa.taskapi.model.Task;
import com.kakao.osa.taskapi.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    @GetMapping
    public List<Task> tasks() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable("id") Long id) {
        return taskService.findById(id);
    }

    @PostMapping
    public Task generateTask(@RequestBody Task task) {
        return taskService.save(task);
    }

    @PutMapping
    public Task update(@RequestBody Task task) {
        return taskService.update(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        taskService.delete(id);
    }
}
