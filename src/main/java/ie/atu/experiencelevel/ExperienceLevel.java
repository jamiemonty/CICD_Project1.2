package ie.atu.experiencelevel;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "experience_level")
public class ExperienceLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id") // Specifies the column name in MySQL
    private Long expId;

    @Column(name = "level") // Assuming level is the name of the column
    private String level;

    public ExperienceLevel() {}

    public ExperienceLevel(Long id, String level) {
        this.expId = id;
        this.level = level;
    }

    public Long getId() {
        return expId;
    }

    public void setId(Long id) {
        this.expId = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
