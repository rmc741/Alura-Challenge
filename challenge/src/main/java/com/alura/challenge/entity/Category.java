package com.alura.challenge.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "The Category title cannot be empty")
    @NotNull(message = "The Category title cannot be null")
    private String title;

    @NotEmpty(message = "The Category color cannot be empty")
    @NotNull(message = "The Category color cannot be null")
    private String color;

    @ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "videoId")
    private List<Video> videos;

    public Category() {
    }

    public Category(String title, String color) {
        this.title = title;
        this.color = color;
    }

    public Category(String title, String color, List<Video> videos) {
        this.title = title;
        this.color = color;
        this.videos = videos;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String titulo) {
        this.title = titulo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
