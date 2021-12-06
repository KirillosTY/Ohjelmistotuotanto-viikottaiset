package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.LinkedList;

public class Tapahtumankuuntelija implements EventHandler {
    private TextField tuloskentta; 
    private TextField syotekentta;
    private Button plus;
    private Button miinus;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    private Undo peru;
    private HashMap<Button, Tapahtuma> calcSumsNeeded;
    private LinkedList<Integer> arvoja;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.plus = plus;
        this.miinus = miinus;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = new Sovelluslogiikka();
        calcSumsNeeded = new HashMap<>();
        peru = new Undo();
        arvoja = new LinkedList<>();
        calcSumsNeeded.put(plus,new Plus());
        calcSumsNeeded.put(miinus, new Miinus());
        calcSumsNeeded.put(nollaa, new Nollaa());
        calcSumsNeeded.put(undo,peru);
    }
    
    @Override
    public void handle(Event event) {


        int arvo = 0;

        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }

        if(calcSumsNeeded.get(event.getTarget()) != null ){

            calcSumsNeeded.get(event.getTarget()).suorita(arvo,sovellus, tuloskentta, syotekentta, nollaa, undo,arvoja );
        }


    }

}
