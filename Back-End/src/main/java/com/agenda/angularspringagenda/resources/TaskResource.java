package com.agenda.angularspringagenda.resources;

import com.agenda.angularspringagenda.entities.Task;
import com.agenda.angularspringagenda.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {

    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Task> findById(@PathVariable Integer id){
        Task task = taskService.findByID(id);
        return ResponseEntity.ok().body(task);
    }

    @GetMapping(value = "/open")
    public ResponseEntity<List<Task>> listOpen(){
        List<Task> list = taskService.findAllOpen();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/close")
    public ResponseEntity<List<Task>> listClose(){
        List<Task> list = taskService.findAllClose();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping()
    public ResponseEntity<List<Task>> listAll(){
        List<Task> list = taskService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Task> Create(@RequestBody Task task){
        task = taskService.create(task);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(task.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Task> delete(@PathVariable Integer id){
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Task> update(@PathVariable Integer id, @RequestBody Task task){
        task = taskService.update(id, task);
        return ResponseEntity.ok().body(task);
    }

}
