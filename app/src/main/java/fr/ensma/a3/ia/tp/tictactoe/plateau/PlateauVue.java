package fr.ensma.a3.ia.tp.tictactoe.plateau;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlateauVue implements IVuePlateau {

    private PresentationPlateau mapres;
    private Button lebutton;
    private TextView leChamp;

    public PlateauVue(final PresentationPlateau pres, Button button, TextView champ ){
        mapres = pres;
        lebutton = button;
        lebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapres.actionReset();
            }
        });
        lebutton.setEnabled(false);
        leChamp = champ;
    }

    @Override
    public void notifValeur(final String val) {
        leChamp.setText(val);
    }

    @Override
    public void notifButton(final boolean touchable) {
        lebutton.setEnabled(touchable);
    }
}
