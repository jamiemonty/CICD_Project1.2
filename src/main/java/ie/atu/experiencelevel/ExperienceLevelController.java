package ie.atu.experiencelevel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/experience-level")
public class ExperienceLevelController {

    private final ExperienceLevelRepository experienceLevelRepository;

    public ExperienceLevelController(ExperienceLevelRepository experienceLevelRepository) {
        this.experienceLevelRepository = experienceLevelRepository;
    }

    // Get all experience levels
    @GetMapping
    public List<ExperienceLevel> getAllExperienceLevels() {
        return experienceLevelRepository.findAll();
    }

    // Get experience level by ID
    @GetMapping("/{id}")
    public ResponseEntity<ExperienceLevel> getExperienceLevelById(@PathVariable Long id) {
        Optional<ExperienceLevel> experienceLevel = experienceLevelRepository.findById(id);
        return experienceLevel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}