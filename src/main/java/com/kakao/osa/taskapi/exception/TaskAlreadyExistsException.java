package com.kakao.osa.taskapi.exception;

public class TaskAlreadyExistsException extends RuntimeException {
    public TaskAlreadyExistsException() {
        super("Already Exists Task");
    }
}
