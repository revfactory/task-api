package com.kakao.osa.taskapi.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException() {
        super("Not Found Task");
    }
}
