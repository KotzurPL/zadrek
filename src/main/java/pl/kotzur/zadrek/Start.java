package pl.kotzur.zadrek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class Start {

    private ProduktRepo produktRepo;
    private ZamowienieRepo zamowienieRepo;

    @Autowired
    public Start(ProduktRepo produktRepo, ZamowienieRepo zamowienieRepo) {
        this.produktRepo = produktRepo;
        this.zamowienieRepo = zamowienieRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runZadRek() {
/*
        Produkt produkt0 = new Produkt("Audio-Technica AT2020", 379.7);
        Produkt produkt1 = new Produkt("Audio-Technica MB3k", 202.25);
        Produkt produkt2 = new Produkt("Klark Teknik DN200 V2 Active DI", 696.54);
        Produkt produkt3 = new Produkt("LDM GLP-210AX", 1349.99);
        Produkt produkt4 = new Produkt("Behringer X32 Compact", 6953.8);
        Produkt produkt5 = new Produkt("Behringer X Air XR18", 2595.4);
        Produkt produkt6 = new Produkt("Turbosound TFX122M-AN", 2071.52);
        Produkt produkt7 = new Produkt("Turbosound iQ18B", 3966.65);
        Produkt produkt8 = new Produkt("Tannoy Gold 7", 1171.45);
        Produkt produkt9 = new Produkt("Lewitt DTP 640 REX", 1289.05);

        produktRepo.save(produkt0);
        produktRepo.save(produkt1);
        produktRepo.save(produkt2);
        produktRepo.save(produkt3);
        produktRepo.save(produkt4);
        produktRepo.save(produkt5);
        produktRepo.save(produkt6);
        produktRepo.save(produkt7);
        produktRepo.save(produkt8);
        produktRepo.save(produkt9);

        Zamowienie zamowienie0 = new Zamowienie(Date.valueOf("2022-02-18"), 1234.56);

        zamowienieRepo.save(zamowienie0);
*/
    }

}
