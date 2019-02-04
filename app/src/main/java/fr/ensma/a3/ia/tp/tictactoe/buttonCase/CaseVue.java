package fr.ensma.a3.ia.tp.tictactoe.buttonCase;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.tp.tictactoe.buttonCase.automate.IEtatCase;
import fr.ensma.a3.ia.tp.tictactoe.plateau.IObserverOfCase;

public class CaseVue implements IVueCase {

    private PresentationCase mapres;
    private Button lebutton;



    public CaseVue(final PresentationCase pres, Button button ){
        mapres = pres;
        lebutton = button;
        lebutton.setOnClickListener(this);
    }

    @Override
    public void notifiValeur(String val) {
        lebutton.setText(val);
    }

    @Override
    public void onClick(View v) {
        Log.d(this.toString(), " was clicked");
        mapres.actionTouche();
    }

    @Override
    public String toString() {
        return lebutton.toString();
    }
}
