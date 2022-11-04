package com.agenda.angularspringagenda.services;

import com.agenda.angularspringagenda.entities.Task;
import com.agenda.angularspringagenda.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TaskRepository taskRepository;

    public void instanciaBaseDeDados(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Task task = new Task(null, "Estudar", "Estudar Spring boot 2 e Angular 11", LocalDateTime.parse("25/03/2022 10:40", dateTimeFormatter),false);
        Task task2 = new Task(null, "Ler", "Harry Potter", LocalDateTime.parse("22/03/2021 13:00", dateTimeFormatter),true);
        Task task3 = new Task(null, "Exercicios", "Praticar Atividade Física", LocalDateTime.parse("21/03/2022 10:15", dateTimeFormatter),false);
        taskRepository.saveAll(Arrays.asList(task,task2,task3));
    }

}
