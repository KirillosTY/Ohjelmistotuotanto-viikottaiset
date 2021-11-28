package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KauppaTest {
    Viitegeneraattori viite;
    Pankki pankki;

    @Before public void startValues(){
         this.pankki = mock(Pankki.class);
         this.viite = mock(Viitegeneraattori.class);
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {

        // määritellään että viitegeneraattori palauttaa viitten 42
        when(viite.uusi()).thenReturn(42);

        Varasto varasto = mock(Varasto.class);
        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        // sitten testattava kauppa
        Kauppa k = new Kauppa(varasto, pankki, viite);

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());
        // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }

    @Test
    public void ostoksenPaaytyttyaSummaVarmistetaan() {

        when(viite.uusi()).thenReturn(42);

        Varasto varasto = mock(Varasto.class);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        Kauppa k = new Kauppa(varasto, pankki, viite);


        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");


        verify(pankki).tilisiirto(eq("pekka"), anyInt(), eq("12345"), anyString(),eq(5));

    }


    @Test
    public void tilisiirtoTarkistus() {
        when(viite.uusi()).thenReturn(42);

        Varasto varasto = mock(Varasto.class);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "kerma", 5));
        Kauppa k = new Kauppa(varasto, pankki, viite);


        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);

        k.tilimaksu("jeesus", "pinokkia");


        verify(pankki).tilisiirto(eq("jeesus"), anyInt(), eq("pinokkia"), anyString(),eq(10));


    }

    @Test
    public void tilisiirtoTarkistusKaksiSamaa() {
        when(viite.uusi()).thenReturn(42);

        Varasto varasto = mock(Varasto.class);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.saldo(2)).thenReturn(0);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "kerma", 5));
        Kauppa k = new Kauppa(varasto, pankki, viite);


        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("jeesus", "pinokkia");


        verify(pankki).tilisiirto(eq("jeesus"), anyInt(), eq("pinokkia"), anyString(),eq(5));


    }

    @Test
    public void tilisiirtoTarkistusToinenLoppu() {
        when(viite.uusi()).thenReturn(42);

        Varasto varasto = mock(Varasto.class);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        Kauppa k = new Kauppa(varasto, pankki, viite);


        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);

        k.tilimaksu("jeesus", "pinokkia");


        verify(pankki).tilisiirto(eq("jeesus"), anyInt(), eq("pinokkia"), anyString(),eq(10));


    }

    @Test
    public void uusiOstoskori(){

        when(viite.uusi()).thenReturn(42);

        Varasto varasto = mock(Varasto.class);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        Kauppa k = new Kauppa(varasto, pankki, viite);


        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);



        k.aloitaAsiointi();

        k.tilimaksu("jeesus", "pinokkia");
        verify(pankki).tilisiirto(eq("jeesus"), anyInt(), eq("pinokkia"), anyString(),eq(0));


    }

    @Test
    public void uusiViite(){

        when(viite.uusi()).thenReturn(42);

        Varasto varasto = mock(Varasto.class);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        Kauppa k = new Kauppa(varasto, pankki, viite);


        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);




        k.tilimaksu("jeesus", "pinokkia");
        when(viite.uusi()).thenReturn(4);
        k.aloitaAsiointi();

        k.tilimaksu("jeesus", "pinokkia");
        verify(pankki).tilisiirto(eq("jeesus"), eq(4), eq("pinokkia"), anyString(),eq(0));


    }

}
