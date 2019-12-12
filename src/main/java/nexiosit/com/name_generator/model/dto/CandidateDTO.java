package nexiosit.com.name_generator.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CandidateDTO {
    String firstName;
    String lastName;
    String phoneNumber;
    String skills;
    String image;
    String email;

}
