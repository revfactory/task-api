package com.kakao.osa.taskapi.service;

import com.kakao.osa.taskapi.exception.TaskAlreadyExistsException;
import com.kakao.osa.taskapi.exception.TaskNotFoundException;
import com.kakao.osa.taskapi.model.Task;
import com.kakao.osa.taskapi.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskRepository repository;

    @Override
    public List<Task> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Task> findByTitle(String title) {
        return repository.findByTitleLike(title);
    }

    @Override
    public Task findById(Long id) {
        return repository.findById(id)
                .orElseThrow(TaskNotFoundException::new);
    }

    @Override
    public Task save(Task task) {
        if (!repository.findByTitle(task.getTitle()).isEmpty()) {
            throw new TaskAlreadyExistsException();
        }
        return repository.save(task);
    }

    @Override
    public Task update(Task task) {
        if (!repository.existsById(task.getId())) {
            throw new TaskNotFoundException();
        }
        return repository.save(task);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new TaskNotFoundException();
        }
        repository.findById(id)
                .ifPresent(repository::delete);
    }
}
