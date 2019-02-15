package pl.coderslab.entity;

import org.hibernate.annotations.CreationTimestamp;
import pl.coderslab.enums.ProjectPrioEnum;
import pl.coderslab.enums.ProjectStatusEnum;

import javax.persistence.*;
import java.util.*;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToMany
    @JoinTable(
            name = "project_user",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "project",fetch = FetchType.EAGER ,cascade = {CascadeType.ALL})
    private List<Tasks> tasks = new ArrayList<>();

    @OneToMany(mappedBy = "project1",fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private Set<UploadFile> uploadFiles = new HashSet<>();


    @CreationTimestamp
    private Date creationTime;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private ProjectPrioEnum projectPrioEnum;

    @Enumerated(EnumType.STRING)
    private ProjectStatusEnum projectStatusEnum;


    public ProjectPrioEnum getProjectPrioEnum() {
        return projectPrioEnum;
    }

    public void setProjectPrioEnum(ProjectPrioEnum projectPrioEnum) {
        this.projectPrioEnum = projectPrioEnum;
    }

    public ProjectStatusEnum getProjectStatusEnum() {
        return projectStatusEnum;
    }

    public void setProjectStatusEnum(ProjectStatusEnum projectStatusEnum) {
        this.projectStatusEnum = projectStatusEnum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
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

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }

    public Set<UploadFile> getUploadFiles() {
        return uploadFiles;
    }

    public void setUploadFiles(Set<UploadFile> uploadFiles) {
        this.uploadFiles = uploadFiles;
    }

    public Project(List<User> users, List<Tasks> tasks, Set<UploadFile> uploadFiles, Date creationTime, String name, String description, ProjectPrioEnum projectPrioEnum, ProjectStatusEnum projectStatusEnum) {
        this.users = users;
        this.tasks = tasks;
        this.uploadFiles = uploadFiles;
        this.creationTime = creationTime;
        this.name = name;
        this.description = description;
        this.projectPrioEnum = projectPrioEnum;
        this.projectStatusEnum = projectStatusEnum;
    }

    public Project() {
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
             //   ", users=" + users +
              //  ", tasks=" + tasks +
                ", creationTime=" + creationTime +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", projectPrioEnum=" + projectPrioEnum +
                ", projectStatusEnum=" + projectStatusEnum +
                '}';
    }

}