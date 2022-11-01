package com.alura.challenge.entity;

import java.util.List;

public class Category {

    private Long id;
    private String titulo;
    private String color;

    private List<Video> videosList;

    public Category() {
    }

    public Category(String titulo, String color, List<Video> videosList) {
        this.titulo = titulo;
        this.color = color;
        this.videosList = videosList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Video> getVideosList() {
        return videosList;
    }

    public void setVideosList(List<Video> videosList) {
        this.videosList = videosList;
    }
}
