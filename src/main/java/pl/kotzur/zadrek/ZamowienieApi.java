package pl.kotzur.zadrek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.util.Set;

@RestController
public class ZamowienieApi {

    private ZamowienieRepo zamowienieRepo;

    @Autowired
    public ZamowienieApi(ZamowienieRepo zamowienieRepo) {
        this.zamowienieRepo = zamowienieRepo;
    }

    @GetMapping("/api/zamowienie")
    public Iterable<Zamowienie> getZamowienie(
            @RequestParam(name = "start", required = false) String start,
            @RequestParam(name = "end", required = false) String end) {
        if (start == null || end == null) {
            return zamowienieRepo.findAll();
        } else {
            return zamowienieRepo.findByDataBetween(Date.valueOf(start), Date.valueOf(end));
        }
    }

    @PostMapping("/api/zamowienie")
    public Zamowienie addZamowienie(@RequestBody Zamowienie zamowienie) {
        Zamowienie zapisane = zamowienieRepo.save(zamowienie);
        Zamowienie pobrane = zamowienieRepo.findById(zapisane.getId()).get();
        double obliczonaKwota = zamowienieRepo.getTotalAmount(pobrane.getId());
        pobrane.setKwota(obliczonaKwota);
        return zamowienieRepo.save(pobrane);
    }

    @PutMapping("/api/zamowienie/{zamId}")
    public Zamowienie updateZamowienie(@PathVariable Long zamId) {
        Zamowienie zamowienie = zamowienieRepo.findById(zamId).get();
        double nowaKwota = zamowienie.obliczKwote();
        zamowienie.setKwota(nowaKwota);
        return zamowienieRepo.save(zamowienie);
    }

}
