package com.agenda.angularspringagenda.services;

import com.agenda.angularspringagenda.entities.Task;
import com.agenda.angularspringagenda.repositories.TaskRepository;
import com.agenda.angularspringagenda.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task findByID(Integer id){
        return taskRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + " Tipo: " + Task.class.getName()));
    }

    public List<Task> findAllOpen(){
        return taskRepository.findAllOpen();
    }

    public List<Task> findAllClose() {
        return taskRepository.findAllClose();
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task create(Task task) {
        task.setId(null);
        return taskRepository.save(task);
    }

    public void delete(Integer id){
        taskRepository.deleteById(id);
    }

    public Task update(Integer id, Task task) {
        Task obj = findByID(id);
        obj = new Task(id, task.getTitulo(), task.getDescricao(), task.getDataFinalizar(), task.getFinalizado());
        taskRepository.save(obj);
        return obj;
    }
}
