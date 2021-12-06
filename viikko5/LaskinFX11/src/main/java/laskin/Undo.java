package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.LinkedList;

public class Undo implements Tapahtuma{

    private LinkedList<Integer> arvoja = new LinkedList<>();


    @Override
    public void suorita(int arvo, Sovelluslogiikka sovellus, TextField tuloskentta, TextField syotekentta, Button nollaa, Button Undo, LinkedList<Integer> arvoja){        sovellus.plus(arvo);

        int laskunTulos= 0;
        sovellus.nollaa();

        if (arvoja.size() != 0) {
            laskunTulos = arvoja.pollLast();
            sovellus.plus(laskunTulos);
        } else {
            Undo.disableProperty().set(true);
        }
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);


    }



}