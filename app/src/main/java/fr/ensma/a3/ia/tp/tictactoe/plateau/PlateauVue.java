package fr.ensma.a3.ia.tp.tictactoe.plateau;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PlateauVue implements IVuePlateau {

    private PresentationPlateau mapres;
    private Button lebutton;
    private TextView leChamp;
    private ProgressBar laBarre;
    private MonTimer leThTimer;

    public PlateauVue(final PresentationPlateau pres, Button button, TextView champ, ProgressBar bar ){
        mapres = pres;
        lebutton = button;
        laBarre = bar;
        leThTimer = new MonTimer();
        leThTimer.execute();
        laBarre.setMax(10);

        lebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapres.actionReset();
            }
        });
        leChamp = champ;
    }

    @Override
    public void createTimer(){
        leThTimer = new MonTimer();
        leThTimer.execute();
    }

    @Override
    public void notifValeur(final String val) {
        leChamp.setText(val);
    }

    @Override
    public void notifButton(final boolean touchable) {
        lebutton.setEnabled(touchable);
    }

    @Override
    public void notifTimerFin() {
        leThTimer.cancel(true);
        laBarre.setProgress(0);
    }


    private class MonTimer extends AsyncTask<Integer,Integer,Void> {

        @Override
        protected Void doInBackground(Integer... integers) {
            int clock = 0;
            while (clock<=10) {
                try {

                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
                clock++;
                publishProgress(clock);
                if (isCancelled()) {
                    return null;
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            laBarre.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            laBarre.setProgress(0);
            mapres.actionTimesUp();

        }
    }
}
