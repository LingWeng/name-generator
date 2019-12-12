package nexiosit.com.name_generator.controller;

import lombok.RequiredArgsConstructor;
import nexiosit.com.name_generator.model.Candidate;
import nexiosit.com.name_generator.model.dto.CandidateDTO;
import nexiosit.com.name_generator.model.dto.CharacterDTO;
import nexiosit.com.name_generator.services.CandidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/candidate")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @PostMapping
    public ResponseEntity<CharacterDTO> postCharacter(@RequestBody CandidateDTO candidateDTO) throws URISyntaxException {

        CharacterDTO character = candidateService.saveCandidate(candidateDTO);

        return ResponseEntity.created(new URI("")).body(character);
        }

}
