package ie.atu.experiencelevel;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ExerciseService {

    // Leg workouts with their default weights
    private final int squat = 80;
    private final int deadlift = 120;
    private final int rdl = 70;
    private final int hstcurl = 65;
    private final int quadext = 65;

    private final int DbBench = 40;
    private final int pulldown = 90;
    private final int row = 80;
    private final int latRaise = 10;
    private final int curls = 20;

    private final ExperienceLevelRepository experienceLevelRepository;

    public ExerciseService(ExperienceLevelRepository experienceLevelRepository) {
        this.experienceLevelRepository = experienceLevelRepository;
    }

    public Map<String, Double> calculateExerciseWeights(Long expId) {
        // Fetch the multiplier
        Optional<ExperienceLevel> experienceLevel = experienceLevelRepository.findById(expId);

        if (experienceLevel.isPresent()) {
            Double multiplier = experienceLevel.get().getMultiplier();

            // Calculate weights for all upper body exercises
            Map<String, Double> exerciseWeights = new HashMap<>();
            exerciseWeights.put("Dumbbell Bench", DbBench * multiplier);
            exerciseWeights.put("Lat Pulldowns", pulldown * multiplier);
            exerciseWeights.put("Barbell rows", row * multiplier);
            exerciseWeights.put("Lat Raises", latRaise * multiplier);
            exerciseWeights.put("Bicep Curls", curls * multiplier);

            // Calculate weights for all lower body exercises
            exerciseWeights.put("Squat", squat * multiplier);
            exerciseWeights.put("Deadlift", deadlift * multiplier);
            exerciseWeights.put("RDL", rdl * multiplier);
            exerciseWeights.put("Hamstring Curl", hstcurl * multiplier);
            exerciseWeights.put("Quad Extension", quadext * multiplier);

            return exerciseWeights;

        } else {
            throw new IllegalArgumentException("Invalid experience level ID: " + expId);
        }
    }
}
