package com.agenda.angularspringagenda.repositories;

import com.agenda.angularspringagenda.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query("Select task FROM Task task WHERE task.finalizado = false ORDER BY task.dataFinalizar")
    List<Task> findAllOpen();

    @Query("Select task FROM Task task WHERE task.finalizado = true ORDER BY task.dataFinalizar")
    List<Task> findAllClose();
}
