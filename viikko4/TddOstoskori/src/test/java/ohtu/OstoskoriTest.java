package ohtu;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OstoskoriTest {

    Ostoskori kori;

    @Before
    public void setUp() {
        kori = new Ostoskori();

    }

    // step 1
    @Test
    public void ostoskorinHintaJaTavaroidenMaaraAlussa() { 
        assertEquals(0, kori.hinta());
 
        assertEquals(0,kori.tavaroitaKorissa());
    }

    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorissaYksiTuote() {
        Tuote maito = new Tuote("maito", 3);

        kori.lisaaTuote(maito);

        assertEquals(1,kori.tavaroitaKorissa());
    }

    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorinHintaOnTuotehinta() {
        Tuote maito = new Tuote("maito", 3);

        kori.lisaaTuote(maito);

        assertEquals(3,kori.hinta());
    }

    @Test
    public void KahdenTuotteenLisaamisenJalkeenKorissaKaksiTuotetta() {
        Tuote maito = new Tuote("maito", 3);
        Tuote maitoL = new Tuote("maito-Laktoositon", 3);
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maitoL);
        assertEquals(2,kori.tavaroitaKorissa());
    }

    @Test
    public void KahdenTuotteenLisaamisenJalkeenKorinHintaKahdelle() {
        Tuote maito = new Tuote("maito", 3);
        Tuote maitoL = new Tuote("maito-Laktoositon", 3);
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maitoL);
        assertEquals(6,kori.hinta());
    }


    @Test
    public void KahdenSamanTuotteenLisaamisenJalkeenKorissaKaksiTuotetta() {
        Tuote maito = new Tuote("maito", 3);

        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);
        assertEquals(2,kori.tavaroitaKorissa());
    }



    @Test
    public void KahdenSamanTuotteenLisaamisenJalkeenKorinHintaKahdelle() {
        Tuote maito = new Tuote("maito", 3);
        kori.tyhjenna();
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);
        assertEquals(6,kori.hinta());
    }
}
