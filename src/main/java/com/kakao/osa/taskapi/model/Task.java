package com.kakao.osa.taskapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Task implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;

    private LocalDateTime creationDate;

    private LocalDate startDate;

    private LocalDate endDate;

    @PrePersist
    private void init() {
        this.creationDate = LocalDateTime.now();
    }

    public Task(String title, String description) {
        super();
        this.title = title;
        this.description = description;
    }
}
