
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa implements Komento {
    
    private TextField tuloskentta;
    private TextField syotekentta; 
    private Button nollaa; 
    private Button undo; 
    private Sovelluslogiikka sovellus;
    private int arvo;
    
    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }
    

    @Override
    public void suorita() {
        lueSyote();
        sovellus.plus(arvo);
        int laskunTulos = sovellus.tulos();
        tuloskentta.setText(laskunTulos+"");
        syotekentta.setText("");
        
        if (laskunTulos == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
        
    }

    @Override
    public void peru() {
        sovellus.miinus(arvo);
        int laskunTulos = sovellus.tulos();
        tuloskentta.setText(laskunTulos+"");
        syotekentta.setText("");
        undo.disableProperty().set(true);
    }
    
    public void lueSyote() {
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    
}
