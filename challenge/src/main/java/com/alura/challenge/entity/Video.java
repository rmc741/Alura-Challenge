package com.alura.challenge.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Video {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "The video title cannot be empty")
    @NotNull(message = "The video title cannot be null")
    private String title;
    @NotEmpty(message = "The video description cannot be empty")
    @NotNull(message = "The video description cannot be null")
    private String description;
    @NotEmpty(message = "The video url cannot be empty")
    @NotNull(message = "The video url cannot be null")
    private String url;

    @ManyToMany(mappedBy = "videos")
    @JoinColumn(referencedColumnName = "categoryId")
    private List<Category> categories;

    public Video() {
    }

    public Video(String title, String description, String url) {
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public Video(String title, String description, String url, List<Category> categories) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
