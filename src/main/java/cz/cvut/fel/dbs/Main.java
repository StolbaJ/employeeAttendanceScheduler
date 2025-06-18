package cz.cvut.fel.dbs;

import cz.cvut.fel.dbs.model.*;
import cz.cvut.fel.dbs.model.Zamestnanec;
import cz.cvut.fel.dbs.Dto.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        GeneralDto service = new GeneralDto();

        // Přidání nového zaměstnance
        Zamestnanec zamestnanec = new Zamestnanec();
        zamestnanec.setRodneCislo("90010112345");
        zamestnanec.setJmeno("Petr Novak");
        zamestnanec.setDatumNarozeni(new Date());
        zamestnanec.setMesto("Praha");
        service.pridatZamestnance(zamestnanec);

        // Výpis všech zaměstnanců
        System.out.println("Všichni zaměstnanci:");
        service.vypisVsechnyZamestnance().forEach(z -> System.out.println(z.getJmeno()));

        // Přidání oddělení
        Oddeleni oddeleni = new Oddeleni();
        oddeleni.setZamereni("IT");
        oddeleni.setBudova("A1");
        oddeleni.setMaxPocetZamestnancu(10);
        service.pridatOddeleni(oddeleni);

        // Přidání pracovní smlouvy
        PracovniSmlouva smlouva = new PracovniSmlouva();
        smlouva.setId(new PracovniSmlouvaId());
        smlouva.getId().setPocatek(new Date());
        smlouva.getId().setZamestnanec(zamestnanec.getRodneCislo());
        smlouva.setKonec(null);
        smlouva.setUvazek(100.0);
        service.pridatPracovniSmlouvu(smlouva);

        // Přidání operace - příchod
        Prichod prichod = new Prichod();
        prichod.setZpozdeni("00:05:00");
        prichod.setDuvodZpozdeni("Doprava");
        service.pridatOperaci(prichod);

        // Výpis všech operací
        System.out.println("Všechny operace:");
        service.vypisVsechnyOperace().forEach(op -> System.out.println(op.getClass().getSimpleName()));

        System.out.println("Demonstrace ukončena.");
    }
}
