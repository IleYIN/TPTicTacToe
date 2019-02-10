package fr.ensma.a3.ia.tp.tictactoe.plateau;

import android.view.View;
import android.widget.Button;

public class PlateauVue implements IVuePlateau {

    private PresentationPlateau mapres;
    private Button lebutton;



    public PlateauVue(final PresentationPlateau pres, Button button ){
        mapres = pres;
        lebutton = button;
        lebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapres.actionReset();
            }
        });
    }

}
