package nexiosit.com.name_generator.services.impl;

import lombok.RequiredArgsConstructor;
import nexiosit.com.name_generator.model.Candidate;
import nexiosit.com.name_generator.model.dto.CharacterDTO;
import nexiosit.com.name_generator.repositories.CandidateRepo;
import nexiosit.com.name_generator.services.CharacterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    private final CandidateRepo candidateRepo;

    @Override
    public List<CharacterDTO> getCharacters() {
        List<Candidate> candidates = candidateRepo.findAll();
        List<CharacterDTO> characterDTOS = new ArrayList<>();

        for (Candidate candidate : candidates) {
            characterDTOS.add(new CharacterDTO(candidate.getCharacterImg(),candidate.getCharacterName()));
        }
        return characterDTOS ;
    }

    @Override
    public CharacterDTO getCharacter(String email) {
        Candidate candidate = candidateRepo.findByEmail(email);
        return new CharacterDTO(candidate.getCharacterImg(), candidate.getCharacterName());
    }


}
