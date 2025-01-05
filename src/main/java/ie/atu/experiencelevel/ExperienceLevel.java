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

    private Double multiplier;

    public ExperienceLevel() {}

    public ExperienceLevel(Long id, String level, Double multiplier) {
        this.expId = id;
        this.level = level;
        this.multiplier = multiplier;
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

    public Double getMultiplier() {return multiplier;}

    public void setMultiplier(Double multiplier) {
        this.multiplier = multiplier;
    }
}
