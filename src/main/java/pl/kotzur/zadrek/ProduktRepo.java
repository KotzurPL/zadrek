package pl.kotzur.zadrek;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduktRepo extends CrudRepository<Produkt, Long> {
}
