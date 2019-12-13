package nexiosit.com.name_generator.utils;

import lombok.extern.slf4j.Slf4j;
import nexiosit.com.name_generator.constants.NamingConstants;
import nexiosit.com.name_generator.model.Candidate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NameGenerator {

    public String generateName(Candidate candidate){
        return generatePrefix(candidate) + " " + generateStarWarsName(candidate) + " " + generatePlanet(candidate);
    }

    private String generatePrefix(Candidate candidate){
        return NamingConstants.prefixes.get(generateIndex(candidate.getSkills(), NamingConstants.prefixes.size()));
    }

    private String generateStarWarsName(Candidate candidate){
        return NamingConstants.names.get(generateIndex(candidate.getFirstName(), NamingConstants.names.size()));
    }

    private String generatePlanet(Candidate candidate){
        return NamingConstants.planets.get(generateIndex(candidate.getLastName(), NamingConstants.planets.size()));
    }

    private int generateIndex(String strValue, int size){
        int value = 0;
        for(char c : strValue.toCharArray()){
            value += c;
        }
        int index = value % size;

        return index;
    }
}
