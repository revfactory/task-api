package com.kakao.osa.taskapi;

import com.kakao.osa.taskapi.model.Task;
import com.kakao.osa.taskapi.service.TaskService;
import lombok.AllArgsConstructor;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@AllArgsConstructor
@SpringBootApplication
public class TaskApiApplication implements CommandLineRunner {

    private final TaskService taskService;

    public static void main(String[] args) {
        SpringApplication.run(TaskApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 5; i++) {
            taskService.save(new Task("title " + i, "description " + i));
        }
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server inMemoryH2DatabaseaServer() throws SQLException {
        return Server.createTcpServer(
                "-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
    }
}
