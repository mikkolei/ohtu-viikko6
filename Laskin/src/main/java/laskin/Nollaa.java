
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa implements Komento {
    
    private TextField tuloskentta;
    private TextField syotekentta; 
    private Button nollaa; 
    private Button undo; 
    private Sovelluslogiikka sovellus;
    private int arvo;
    
    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }

    @Override
    public void suorita() {
        lueSyote();
        sovellus.nollaa();
        tuloskentta.setText(0+"");
        syotekentta.setText("");
        
        if (sovellus.tulos() == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }

    @Override
    public void peru() {
        tuloskentta.setText(arvo+"");
        undo.disableProperty().set(true);
    }
    
    public void lueSyote() {
        try {
            arvo = Integer.parseInt(tuloskentta.getText());
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    
}
