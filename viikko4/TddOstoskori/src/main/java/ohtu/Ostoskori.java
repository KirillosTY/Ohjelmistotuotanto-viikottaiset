package ohtu;

import java.util.HashMap;
import java.util.List;

public class Ostoskori {

    private HashMap<String,Ostos> ostokset = new HashMap<>();

    public int tavaroitaKorissa() {
        int lkm= 0;

        for(Ostos o: ostokset.values()){

            lkm += o.lukumaara();
        }


        return lkm;

    }
 
    public int hinta() {
        int summa= 0;

        for(Ostos o: ostokset.values()){

            summa += o.lukumaara()*o.hinta();
        }

        return summa;
    }
 
    public void lisaaTuote(Tuote lisattava) {
        Ostos o = checkIfThere(lisattava);

        if(o== null){
            ostokset.put(lisattava.getNimi(), new Ostos(lisattava));
        } else {

            ostokset.get(lisattava.getNimi()).muutaLukumaaraa(1);

        }

    }
 
    public void poista(Tuote poistettava) {
        // poistaa tuotteen
    }
 
    public List<Ostos> ostokset() {
        // palauttaa listan jossa on korissa olevat ostokset
 
        return null;
    }
 
    public void tyhjenna() {
        // tyhjentää korin
    }

    public Ostos checkIfThere(Tuote t){
        if(ostokset.containsKey(t.getNimi())){
            return ostokset.get(t.getNimi());
        }

        return null;
    }
}
