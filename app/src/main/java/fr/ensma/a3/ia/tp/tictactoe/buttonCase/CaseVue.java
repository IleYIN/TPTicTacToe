package fr.ensma.a3.ia.tp.tictactoe.buttonCase;

import android.graphics.Canvas;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class CaseVue/* extends View*/ implements IVueCase {

    private final PresentationCase mapres;
    private final Button lebutton;


   /* @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }*/

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
    public void notifValeur(String val) {
        lebutton.setText(val);
    }

    @Override
    public void notifButton(final boolean touchable) {
        lebutton.setEnabled(touchable);
    }

    @Override
    public String toString() {
        return lebutton.toString();
    }
}
