package org.example.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class ToDo {
    UUID id;
    String title;
    String desc;
    LocalDateTime creationDate;
    public ToDo(String title, String desc, LocalDateTime creationDate) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.desc = desc;
        this.creationDate = creationDate;
    }
    public ToDo(UUID id, String title, String desc, LocalDateTime creationDate) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.creationDate = creationDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
