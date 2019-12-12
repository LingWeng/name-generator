package nexiosit.com.name_generator.controller;

import lombok.RequiredArgsConstructor;
import nexiosit.com.name_generator.model.dto.CharacterDTO;
import nexiosit.com.name_generator.services.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/character")
@RequiredArgsConstructor
@CrossOrigin
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping()
    public ResponseEntity<List<CharacterDTO>> getCharacters(){
        return ResponseEntity.ok(characterService.getCharacters());
    }

    @GetMapping("/{email}")
    public ResponseEntity<CharacterDTO> getCharacter(@PathVariable String email){
        return ResponseEntity.ok(characterService.getCharacter(email));
    }



}
