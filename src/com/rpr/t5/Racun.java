package com.rpr.t5;

public class Racun {
    private final Long brojRacuna;
    private final Osoba korisnikRacuna;
    private Double stanjeRacuna;
    private boolean odobrenjePrekoracenja;

    public Racun(Long brojRacuna, Osoba korisnikRacuna) {
        this.brojRacuna = brojRacuna;
        this.korisnikRacuna = korisnikRacuna;
        this.stanjeRacuna = 0d;
        this.odobrenjePrekoracenja = false;
    }

    public Long getBrojRacuna() {
        return brojRacuna;
    }

    public Osoba getKorisnikRacuna() {
        return korisnikRacuna;
    }

    public Double getStanjeRacuna() {
        return stanjeRacuna;
    }

    public boolean isOdobrenjePrekoracenja() {
        return odobrenjePrekoracenja;
    }

    public boolean izvrsiUplatu(Double uplata){
        stanjeRacuna += uplata;
        return true;
    }

    public boolean izvrsiIsplatu(Double isplata){
        if(stanjeRacuna - isplata < 0)
            provjeriOdobrenjePrekoracenja(isplata);
        else
            stanjeRacuna -= isplata;
        return true;

    }

    private boolean provjeriOdobrenjePrekoracenja(Double prekoracenje){
        if (odobrenjePrekoracenja){
            stanjeRacuna -= prekoracenje;
            return true;
        }
        else return false;
    }

    public void odobriPrekoracenje(){
        odobrenjePrekoracenja = true;
    }


}
