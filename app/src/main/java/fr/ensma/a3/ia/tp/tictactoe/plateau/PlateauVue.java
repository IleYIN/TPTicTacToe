package fr.ensma.a3.ia.tp.tictactoe.plateau;

import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import fr.ensma.a3.ia.tp.tictactoe.MainActivity;
import fr.ensma.a3.ia.tp.tictactoe.accel.AcquAccel;
import fr.ensma.a3.ia.tp.tictactoe.accel.MDDAccel;

public class PlateauVue implements IVuePlateau {

    private PresentationPlateau mapres;
    private Button lebutton;
    private TextView leChamp;

    private ProgressBar laBarre;
    private MonTimer leThTimer;

    private TextView textAccel;
    private SensorManager sensM;
    private MDDAccel mddAccelVal;



    public PlateauVue(final PresentationPlateau pres, Button button, TextView champ, ProgressBar bar,
                      TextView textAc, SensorManager sen ){
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
        lebutton.setEnabled(false);
        leChamp = champ;

        textAccel = textAc;
        sensM = sen;
        mddAccelVal = new MDDAccel();

        new MonAcqAccel().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        AcquAccel thAcell = new AcquAccel(sensM,mddAccelVal);
        thAcell.start();

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

    private class MonAcqAccel extends AsyncTask<Void,Float,Void>{


        @Override
        protected Void doInBackground(Void... voids) {
            float xval;
            while(true) {

                try {
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                xval = mddAccelVal.getXVal();
                publishProgress(xval);
            }
        }

        @Override
        protected void onProgressUpdate(Float... values) {
            textAccel.setText(values[0].toString());

            if(values[0]>6.0||values[0]<-6){
                mapres.setEtatCourant(mapres.getEnFinJeu());
                mapres.notifyObserverFin();
                mapres.actionReset();
            }
        }
    }


}
