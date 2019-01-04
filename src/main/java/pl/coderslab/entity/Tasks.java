package pl.coderslab.entity;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Date date;

    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    private Project project;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Tasks() {
    }

    public Tasks(Date date, String name, String description, Project project) {
        this.date = date;
        this.name = name;
        this.description = description;
        this.project = project;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
               // ", project=" + project +
                '}';
    }
}
