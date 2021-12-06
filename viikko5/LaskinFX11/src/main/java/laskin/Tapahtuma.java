package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.LinkedList;

public interface Tapahtuma {

      void suorita(int arvo, Sovelluslogiikka sovellus, TextField tuloskentta, TextField syotekentta, Button nollaa, Button Undo, LinkedList<Integer> arvoja);

}