package ie.atu.experiencelevel;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "experience_level")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExperienceLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expId;

    private String level;
}
