package ohtu.verkkokauppa;

public interface PankkiInj {
    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
}
