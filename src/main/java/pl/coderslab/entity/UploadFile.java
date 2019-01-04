package pl.coderslab.entity;

import javax.persistence.*;

@Entity
@Table(name = "FILES_UPLOAD")
public class UploadFile {

    @Id
    @GeneratedValue
    @Column(name = "FILE_ID")
    private long id;

    @Column(name = "FILE_NAME")
    private String fileName;

    @Column(name = "FILE_DATA",length =1000000000)
    private byte[] data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="project_id")
    private Project project1;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }


    public Project getProject1() {
        return project1;
    }

    public void setProject1(Project project1) {
        this.project1 = project1;
    }



    public UploadFile() {
    }

    public UploadFile(long id, String fileName, byte[] data, Project project1) {
        this.id = id;
        this.fileName = fileName;
        this.data = data;
        this.project1 = project1;
    }
}