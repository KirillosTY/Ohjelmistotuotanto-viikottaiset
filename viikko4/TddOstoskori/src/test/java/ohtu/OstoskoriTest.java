package ohtu;

import java.util.Arrays;
import java.util.List;

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

    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorissaYksiOstosOlio() {
        kori.lisaaTuote(new Tuote("maito", 3));

        List<Ostos> ostokset = kori.ostokset();

        assertEquals(kori.ostokset().size(),1);
    }

    @Test
    public void yhdenTuotteenLisaamisenKorissaYksiOstosOlioJollaOikeaTuotteenNimiJaMaara() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);

        Ostos ostos = kori.ostokset().get(0);

        assertEquals("maito", ostos.tuotteenNimi());

    }

    @Test
    public void kahdenTuotteenLisaamisenJalkeenKorissaKaksiOstosOliota() {
        kori.lisaaTuote(new Tuote("maito", 3));
        kori.lisaaTuote(new Tuote("maitoL", 3));
        List<Ostos> ostokset = kori.ostokset();

        assertEquals(2, kori.ostokset().size());
    }
    @Test
    public void KahdenSamanTuotteenLisaamisenJalkeenKorissaYksiOlio() {
        Tuote maito = new Tuote("maito", 3);

        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);

        assertEquals(1, kori.ostokset().size());
    }

    @Test
    public void KahdenSamanTuotteenLisaamisenJalkeenKorinLkmKahdelle() {
        Tuote maito = new Tuote("maito", 3);

        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);

        assertEquals(2,kori.ostokset().get(0).lukumaara());
    }


    @Test
    public void KahdestaYhdenPoistaminenJattaaYhden(){
        Tuote maito = new Tuote("maito", 3);

        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);
        kori.poista(maito);
        assertEquals(1,kori.ostokset().get(0).lukumaara());



    }
}
