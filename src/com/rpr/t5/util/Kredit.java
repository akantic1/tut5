package com.rpr.t5.util;

import com.rpr.t5.Korisnik;

import java.util.List;

public class Kredit {

    public static Double proracunKreditneSposobnosti(KreditnaSposobnost funkcija, Korisnik k1) {
        Double kredit = funkcija.provjeri(k1.getRacun());
        return kredit;
    }

    public static void ispisiSveKorisnikeBezPrekoracenja(List<Korisnik> korisnici) {
    korisnici.stream().filter(k -> k.getRacun().getStanjeRacuna().doubleValue() > 0).
            forEach(System.out::println);

    }

    public void odobriPrekoracenje(List<Korisnik> korisnici){
        korisnici.stream().filter(k -> k.getRacun().getStanjeRacuna().doubleValue() >10000).
                forEach(k -> k.getRacun().odobriPrekoracenje());

    }
}
