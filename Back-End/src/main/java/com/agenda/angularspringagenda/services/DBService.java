package com.agenda.angularspringagenda.services;

import com.agenda.angularspringagenda.entities.Task;
import com.agenda.angularspringagenda.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TaskRepository taskRepository;

    public void instanciaBaseDeDados() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Task task = new Task(null, "Estudar", "Estudar Spring boot 2 e Angular 11", sdf.parse("25/03/2022"),false);
        Task task2 = new Task(null, "Ler", "Harry Potter", sdf.parse("22/03/2021"),true);
        Task task3 = new Task(null, "Exercicios", "Praticar Atividade Física", sdf.parse("21/03/2022"),false);
        Task task4 = new Task(null, "Meditar", "Meditar durante a manhã", sdf.parse("27/03/2021"),true);
        taskRepository.saveAll(Arrays.asList(task,task2,task3,task4));
    }

}
