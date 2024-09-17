package sw.atelier1.atelier_sw.Implementation.services;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import sw.atelier1.atelier_sw.entities.Candidat;
import sw.atelier1.atelier_sw.repositories.CandidatRepository;



@Service
@AllArgsConstructor
@NoArgsConstructor
public class CandidatServiceImp {
    private CandidatRepository candidateRepository;

    public Candidat addCandidat(Candidat candidate) {
        return candidateRepository.save(candidate);
    }
    public Candidat updateCandidat(int id, Candidat newCandidat) {
        if (candidateRepository.findById(id).isPresent()) {
            Candidat existingCandidat = candidateRepository.findById(id).get();
            existingCandidat.setNom(newCandidat.getNom());
            existingCandidat.setPrenom(newCandidat.getPrenom());
            existingCandidat.setEmail(newCandidat.getEmail());
            return candidateRepository.save(existingCandidat);
        } else
            return null;
    }
    public String deleteCandidat(int id) {
        if (candidateRepository.findById(id).isPresent()) {
            candidateRepository.deleteById(id);
            return "candidat supprimé";
        } else
            return "candidat non supprimé";
    }
}
