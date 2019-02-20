package com.kakao.osa.taskapi.service;

import com.kakao.osa.taskapi.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();
    List<Task> findByTitle(String title);
    Task findById(Long id);
    Task save(Task task);
    Task update(Task task);
    void delete(Long id);
}
