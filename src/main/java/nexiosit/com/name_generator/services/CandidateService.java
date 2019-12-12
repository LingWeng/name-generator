package nexiosit.com.name_generator.services;


import nexiosit.com.name_generator.model.dto.CandidateDTO;
import nexiosit.com.name_generator.model.dto.CharacterDTO;


public interface CandidateService {

    CharacterDTO saveCandidate(CandidateDTO candidateDTO);


}
