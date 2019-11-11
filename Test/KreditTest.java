import com.rpr.t5.Banka;
import com.rpr.t5.Korisnik;
import com.rpr.t5.Racun;
import com.rpr.t5.util.Kredit;
import com.rpr.t5.util.KreditnaSposobnost;
import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KreditTest {
    @Test
    void test1(){
         Banka banka = new Banka();
        Korisnik k1 = banka.kreirajNovogKorisnika("Maja", "Majić");
        banka.kreirajRacun(k1);
        k1.getRacun().izvrsiUplatu(5000d);
        banka.dodajNovogUposlenog("Marko", "Marić");
        KreditnaSposobnost funkcija = (Racun racun) -> {
            double stanje = racun.getStanjeRacuna().doubleValue();
            if (stanje > 1000) {
                return stanje / 2;
            } else {
                return 0d;
            }
        };
       assertEquals(2500, Kredit.proracunKreditneSposobnosti(funkcija, k1));
    }
}
