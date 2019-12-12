package nexiosit.com.name_generator.utils;

import nexiosit.com.name_generator.model.Candidate;
import org.springframework.stereotype.Component;

@Component
public class NameGenerator {

    public String generateName(Candidate candidate){
        return candidate.getFirstName();
    }
}
