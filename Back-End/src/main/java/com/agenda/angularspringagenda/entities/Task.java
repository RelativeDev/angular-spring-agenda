package com.agenda.angularspringagenda.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataFinalizar;
    private Boolean finalizado = false;

    public Task() {
    }

    public Task(Integer id, String titulo, String descricao, Date dataFinalizar, Boolean finalizado) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataFinalizar = dataFinalizar;
        this.finalizado = finalizado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataFinalizar() {
        return dataFinalizar;
    }

    public void setDataFinalizar(Date dataFinalizar) {
        this.dataFinalizar = dataFinalizar;
    }

    public Boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return getId() != null ? getId().equals(task.getId()) : task.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
