package sw.atelier1.atelier_sw.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sw.atelier1.atelier_sw.Implementation.services.CandidatServiceImp;
import sw.atelier1.atelier_sw.entities.Candidat;

@RestController
@RequestMapping("/candidatrestcontroller")
public class CandidatRestController {

    private CandidatServiceImp candidatServiceImp;

    @PostMapping
    @ResponseStatus
    public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat candidat) {
        return new ResponseEntity<>(candidatServiceImp.addCandidat(candidat), HttpStatus.OK);
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Candidat> updateCandidat(@PathVariable(value = "id") int id,
                                                   @RequestBody Candidat candidat){
        return new ResponseEntity<>(candidatServiceImp.updateCandidat(id, candidat),
                HttpStatus.OK);
    }
    @DeleteMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> deleteCandidat(
            @PathVariable(value = "id") int id
    ) {
        // Call the service to delete the candidate
        String result = candidatServiceImp.deleteCandidat(id);
        // Return the response
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
