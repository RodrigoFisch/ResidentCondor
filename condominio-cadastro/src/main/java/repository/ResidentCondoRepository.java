package repository;

import domain.ResidentCondo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface ResidentCondoRepository extends MongoRepository {

    Optional<ResidentCondo> findByCpf(String cpf);

}
