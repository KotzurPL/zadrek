package pl.kotzur.zadrek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduktApi {

    private ProduktRepo produktRepo;

    @Autowired
    public ProduktApi(ProduktRepo produktRepo) {
        this.produktRepo = produktRepo;
    }

    @GetMapping("/api/produkt")
    public Iterable<Produkt> getProdukt() {
        return produktRepo.findAll();
    }

    @PostMapping("/api/produkt")
    public Produkt addProdukt(@RequestBody Produkt produkt) {
        return produktRepo.save(produkt);
    }

    @PutMapping("/api/produkt")
    public Produkt updateProdukt(@RequestBody Produkt produktDst) {
        Produkt produktSrc = produktRepo.findById(produktDst.getId()).get();
        produktSrc.setNazwa(produktDst.getNazwa());
        produktSrc.setCena(produktDst.getCena());
        return produktRepo.save(produktSrc);


    }

}
