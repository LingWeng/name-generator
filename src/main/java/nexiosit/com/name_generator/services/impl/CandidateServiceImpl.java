package nexiosit.com.name_generator.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import nexiosit.com.name_generator.model.Candidate;
import nexiosit.com.name_generator.model.dto.CandidateDTO;
import nexiosit.com.name_generator.model.dto.CharacterDTO;
import nexiosit.com.name_generator.repositories.CandidateRepo;
import nexiosit.com.name_generator.services.CandidateService;
import nexiosit.com.name_generator.utils.ImageGenerator;
import nexiosit.com.name_generator.utils.NameGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepo candidateRepo;
    private final ModelMapper modelMapper;
    private final ImageGenerator imageGenerator;
    private final NameGenerator nameGenerator;


    @Override
    public CharacterDTO saveCandidate(CandidateDTO candidateDTO) {

        Candidate c = modelMapper.map(candidateDTO, Candidate.class);
        c.setCharacterImg(imageGenerator.generateImage(c.getImage()));
        c.setCharacterName(nameGenerator.generateName(c));
        Candidate savedCandidate = candidateRepo.save(c);

        return new CharacterDTO(savedCandidate.getCharacterImg(), savedCandidate.getCharacterName()) ;
    }

}
