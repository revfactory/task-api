package com.kakao.osa.taskapi.repository;

import com.kakao.osa.taskapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTitleLike(String title);
    List<Task> findByTitle(String title);
}
