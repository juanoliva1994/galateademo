package com.demogatalea.galateademo.model;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "manuscripts")
public class Modelo {

    @Id
    private String id;
    private List<String> manuscript;
    private boolean clueFound;

    // Constructor, getters y setters

    public Modelo() {}

    public Modelo(List<String> manuscript, boolean clueFound) {
        this.manuscript = manuscript;
        this.clueFound = clueFound;
    }

    public String getId() {
        return id;
    }
    public List<String> getManuscript() {
        return manuscript;
    }
    public boolean isClueFound() {
        return clueFound;
    }
}
