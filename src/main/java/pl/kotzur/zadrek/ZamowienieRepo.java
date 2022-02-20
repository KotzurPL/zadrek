package pl.kotzur.zadrek;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ZamowienieRepo extends CrudRepository<Zamowienie, Long> {

    List<Zamowienie> findByDataBetween(Date start, Date end);

    @Query(value = "SELECT sum(pr.cena) FROM zamowienie za join l_zamowienie_produkt lzp ON lzp.id_zamowienie = za.id join produkt pr ON pr.id = lzp.id_produkt WHERE za.id = :zamId GROUP BY za.id", nativeQuery = true)
    double getTotalAmount(@Param("zamId") Long zamId);

}
