package fact.it.oefeningjpa.controller;

import fact.it.oefeningjpa.model.Training;
import fact.it.oefeningjpa.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")

public class TrainingRestController {

    @Autowired
    private TrainingRepository trainingRepository;

    @GetMapping("/training")
    public List<Training> getAllTrainings() {
        return trainingRepository.giveListOfAllTrainingsSortedByTheme();
    }

    //    @GetMapping("/training/{number}")
//    public ResponseEntity<Training> getTrainingById(@PathVariable long number) {
//        Optional<Training> training = trainingRepository.findById(number);
//        if (training.isPresent()) {
//            return new ResponseEntity<>(training.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>((HttpStatus.NOT_FOUND));
//    }
    @GetMapping("/training/{number}")
    public ResponseEntity<Training> getTraining(@PathVariable long number) {
        Optional<Training> training1 = trainingRepository.findById(number);
        if (training1.isPresent()) {
            Training training = training1.get();
            return new ResponseEntity<>(training, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/training/title")
    public List<Training> getTrainingByTitle(@RequestBody String title) {
        return trainingRepository.findAllByTitleContaining(title);
    }

    @PostMapping("/training")
    public Training createTraining(@RequestBody Training training) {
        return trainingRepository.save(training);
    }

    @DeleteMapping("/training/{id}")
    public ResponseEntity<Integer> deleteTraining(@PathVariable("id") long trainingId) {
        Optional<Training> training1 = trainingRepository.findById(trainingId);
        if (training1.isPresent()) {
            Training training = training1.get();
            trainingRepository.delete(training);
            return new ResponseEntity<>(trainingRepository.findAll().size(), HttpStatus.OK);

        }
        return new ResponseEntity<>(trainingRepository.findAll().size(), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/training/{id}")
    public ResponseEntity<Training> editTraining(@RequestBody Training updateTraining, @PathVariable("id") long trainingId) {
        Optional<Training> training1 = trainingRepository.findById(trainingId);
        if (training1.isPresent()) {
            Training training = training1.get();
            training.setTitle(updateTraining.getTitle());
            training.setCode(updateTraining.getCode());
            training.setTheme(updateTraining.getTheme());
            training.setDuration(updateTraining.getDuration());
            training.setMax(updateTraining.getMax());
            trainingRepository.save(training);
            return new ResponseEntity<>(training, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
