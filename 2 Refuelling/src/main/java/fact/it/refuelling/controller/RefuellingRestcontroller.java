package fact.it.refuelling.controller;

import fact.it.refuelling.model.Refuelling;
import fact.it.refuelling.model.RefuellingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.sql.Ref;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RefuellingRestcontroller {
    private RefuellingService refuellingService;

    @PostConstruct
    public void fillProductServiceWithProducts() {
        refuellingService = new RefuellingService();
    }

    @GetMapping("/refuellings")
    public List<Refuelling> getAllRefuellings() {
        return refuellingService.getRefuellingList();
    }

    @GetMapping("/refuelling/{id}")
    public ResponseEntity<Refuelling> getRefuellingById(@PathVariable("id") int refuellingId) {

        Optional<Refuelling> refuelling = refuellingService.getOptionalRefuellingById(refuellingId);
        if (refuelling.isPresent()) {
            return new ResponseEntity<>(refuelling.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("refuelling/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Refuelling addRefuelling(@RequestBody Refuelling newRefuelling) {
        return refuellingService.addRefuelling(newRefuelling);
    }

    @PutMapping("refuelling/update/{id}")
    public ResponseEntity<Refuelling> updateRefuelling(@RequestBody Refuelling updateRefuelling, @PathVariable("id")
            int refuellingId) {
        Refuelling refuelling = refuellingService.updateRefuellingById(updateRefuelling, refuellingId);
        if (refuelling == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(refuelling, HttpStatus.OK);
    }

    @DeleteMapping("refuelling/delete/{id}")
    public ResponseEntity<Integer> deleteRefuelling(@PathVariable("id") int refuellingId){
        Optional<Refuelling> refuelling = refuellingService.getOptionalRefuellingById(refuellingId);
        if (refuelling.isPresent()){
            refuellingService.getRefuellingList().remove(refuelling.get());
            return new ResponseEntity<>(refuellingService.getRefuellingList().size(), HttpStatus.OK);
        }
        return new ResponseEntity<>(refuellingService.getRefuellingList().size(), HttpStatus.NOT_FOUND);
    }

}
