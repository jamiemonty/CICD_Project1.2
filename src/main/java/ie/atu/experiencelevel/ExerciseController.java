package ie.atu.experiencelevel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    // Calculate exercise weights for a specific experience level
    @GetMapping("/exercise/calculate-weights/{expId}")
    public ResponseEntity<Map<String, Double>> calculateWeights(@PathVariable Long expId) {
        try {
            Map<String, Double> exerciseWeights = exerciseService.calculateExerciseWeights(expId);
            return ResponseEntity.ok(exerciseWeights);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
