package ohtu;

import java.util.HashMap;
import java.util.List;

public class Ostoskori {

     HashMap<String,Ostos> ostokset;

    public Ostoskori(){
        this.ostokset = new HashMap<>();

    }

    public int tavaroitaKorissa() {
        int lkm= 0;

        for(Ostos o: this.ostokset.values()){

            lkm += o.lukumaara();
        }


        return lkm;

    }
 
    public int hinta() {
        int summa= 0;

        for(Ostos o: this.ostokset.values()){

            summa += o.hinta();
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
        ostokset.get(poistettava.getNimi()).muutaLukumaaraa(0);
        if(ostokset.get(poistettava.getNimi()).lukumaara()==0){
            ostokset.remove(poistettava.getNimi());
        }
    }
 
    public List<Ostos> ostokset() {
        // palauttaa listan jossa on korissa olevat ostokset
 
        return null;
    }


    public void tyhjenna() {
        ostokset.clear();

    }

    public Ostos checkIfThere(Tuote t){

        Ostos o =ostokset.get(t.getNimi());
        if(o!=null){
            return ostokset.get(t.getNimi());
        }

        return null;
    }
}
