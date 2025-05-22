package uz.example.steam_learning.model;

import javax.persistence.*;

@Entity
@Table(name = "virtual_lab_lessons")
public class VirtualLabLessons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String videoUrl; // agar video qo'shilsa

    private String labFilesUrl; // laboratoriya fayllari manzili

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User creator;

    // getters & setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getLabFilesUrl() {
        return labFilesUrl;
    }

    public void setLabFilesUrl(String labFilesUrl) {
        this.labFilesUrl = labFilesUrl;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
