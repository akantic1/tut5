package com.rpr.t5;

public class Korisnik extends Osoba {
    private Racun racun;

    public Korisnik(String ime, String prezime) {
        super(ime, prezime);
    }

    public boolean dodajRacun(Racun racun){
        if(this.racun == null){
            this.racun = racun;
            return true;
        }
        else
            return false;
    }

    public Racun getRacun() {
        return racun;
    }
}