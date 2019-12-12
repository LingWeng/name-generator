package nexiosit.com.name_generator.repositories;

import nexiosit.com.name_generator.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate,Integer> {

    Candidate findByEmail(String Email);

}
