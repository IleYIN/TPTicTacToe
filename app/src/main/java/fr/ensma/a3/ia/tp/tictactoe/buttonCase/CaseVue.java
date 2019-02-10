package fr.ensma.a3.ia.tp.tictactoe.buttonCase;

import android.util.Log;
import android.view.View;
import android.widget.Button;


public class CaseVue implements IVueCase {

    private final PresentationCase mapres;
    private final Button lebutton;



    public CaseVue(final PresentationCase pres, Button button ){
        mapres = pres;
        lebutton = button;
        lebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(this.toString(), " was clicked");
                mapres.actionTouche();
            }
        });
    }

    @Override
    public Button getLebutton() {
        return lebutton;
    }

    @Override
    public void notifiValeur(String val) {
        lebutton.setText(val);
    }

     @Override
    public String toString() {
        return lebutton.toString();
    }
}
