package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.LinkedList;

public class Nollaa implements Tapahtuma{


    @Override
    public void suorita(int arvo, Sovelluslogiikka sovellus, TextField tuloskentta, TextField syotekentta, Button nollaa, Button Undo, LinkedList<Integer> arvoja){        sovellus.plus(arvo);
        sovellus.nollaa();

        int laskunTulos = sovellus.tulos();

        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);




    }
}