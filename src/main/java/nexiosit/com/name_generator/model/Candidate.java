package nexiosit.com.name_generator.model;



import lombok.*;
import lombok.experimental.FieldDefaults;


import javax.persistence.*;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;
    @Column
    String firstName;
    @Column
    String lastName;
    @Column
    String phoneNumber;
    @Column
    String email;
    @Column
    String skills;
    @Column(length = 10000000)
    String image;
    @Column(length = 10000000)
    String characterImg;
    @Column
    String characterName;



}
