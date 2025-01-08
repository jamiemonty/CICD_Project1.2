package ie.atu.experiencelevel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/experience-level")
public class ExperienceLevelController {

    private final ExperienceLevelRepository experienceLevelRepository;
    private final WeightClassClient weightClassClient;

    public ExperienceLevelController(ExperienceLevelRepository experienceLevelRepository, WeightClassClient weightClassClient) {
        this.experienceLevelRepository = experienceLevelRepository;
        this.weightClassClient = weightClassClient;
    }

    @GetMapping
    public List<ExperienceLevel> getAllExperienceLevels() {
        return experienceLevelRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienceLevel> getExperienceLevelById(@PathVariable Long id) {
        Optional<ExperienceLevel> experienceLevel = experienceLevelRepository.findById(id);
        return experienceLevel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get weights multiplied by experience level multiplier
    @GetMapping("/{experienceId}/weights/{weightId}")
    public ResponseEntity<Map<String, Object>> getCalculatedWeights(
            @PathVariable Long experienceId,
            @PathVariable Long weightId
    ) {
        Optional<ExperienceLevel> experienceLevelOptional = experienceLevelRepository.findById(experienceId);
        if (experienceLevelOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ExperienceLevel experienceLevel = experienceLevelOptional.get();

        WeightClass weightClass = weightClassClient.getWeightClassById(weightId);
        if (weightClass == null) {
            return ResponseEntity.notFound().build();
        }

        // Calculate multiplied weights
        double multiplier = experienceLevel.getMultiplier();
        Map<String, Object> response = Map.of(
                "weightRange", weightClass.getWeightRange(),
                "experienceLevel", experienceLevel.getLevel(),
                "calculatedWeights", Map.of(
                        "Squat", weightClass.getSquat() * multiplier,
                        "Deadlift", weightClass.getDeadlift() * multiplier,
                        "Romanian Deadlift", weightClass.getRdl() * multiplier,
                        "Hamstring Curl", weightClass.getHstCurl() * multiplier,
                        "Quad Extension", weightClass.getQuadExt() * multiplier,
                        "Dumbbell Bench", weightClass.getDbBench() * multiplier,
                        "Lateral Pulldown", weightClass.getPulldown() * multiplier,
                        "Lateral Raise", weightClass.getLatRaise() * multiplier,
                        "Bicep Curls", weightClass.getCurls() * multiplier
                )
        );

        return ResponseEntity.ok(response);
    }
}
