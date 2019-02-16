package fr.ensma.a3.ia.tp.tictactoe.plateau;


import android.hardware.SensorManager;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.tp.tictactoe.accel.MDDAccel;
import fr.ensma.a3.ia.tp.tictactoe.buttonCase.IObservableCase;
import fr.ensma.a3.ia.tp.tictactoe.buttonCase.IObserverOfPlateau;
import fr.ensma.a3.ia.tp.tictactoe.buttonCase.PresentationCase;
import fr.ensma.a3.ia.tp.tictactoe.buttonCase.automate.IEtatCase;
import fr.ensma.a3.ia.tp.tictactoe.plateau.automate.EnFinJeu;
import fr.ensma.a3.ia.tp.tictactoe.plateau.automate.EnInit;
import fr.ensma.a3.ia.tp.tictactoe.plateau.automate.EnJeu;
import fr.ensma.a3.ia.tp.tictactoe.plateau.automate.IEtatPlateau;
import fr.ensma.a3.ia.tp.tictactoe.plateau.automate.IGestionEtatPlateau;
import fr.ensma.a3.ia.tp.tictactoe.plateau.automate.PlateauNonPermisException;

public class PresentationPlateau implements IGestionEtatPlateau, IObserverOfCase,IObservablePlateau {


    private List<IObservableCase> listPresCase;
    private List<IObserverOfPlateau> listIObserverOfP;

    private ModelPlateau lemodel;
    private IVuePlateau lavue;

    private IEtatPlateau etatCourant;
    private IEtatPlateau etatInit;
    private IEtatPlateau etatEnJeu;
    private IEtatPlateau etatEnFinJeu;


    public PresentationPlateau() {
        listPresCase = new ArrayList<IObservableCase>();
        listIObserverOfP = new ArrayList<IObserverOfPlateau>();
        lemodel = new ModelPlateau();
        etatCourant = new EnInit(this,lemodel);
        etatInit= new EnInit(this,lemodel);
        etatEnJeu = new EnJeu(this,lemodel);
        etatEnFinJeu = new EnFinJeu(this, lemodel);
    }

    public void setLavue(IVuePlateau lavue) {
        this.lavue = lavue;
    }


    public ModelPlateau getLemodel() {
        return lemodel;
    }

    public void actionReset() {
        try {
            etatCourant.reset();
            lavue.createTimer();
            lavue.notifValeur(lemodel.getVal());
            this.notifyObserverReset();
            lavue.notifButton(lemodel.isButtontouchable());
        } catch (PlateauNonPermisException e) {
            e.printStackTrace();
        }
    }

    public void actionTimesUp(){
        try {
            etatCourant.timesup();
            lavue.notifTimerFin();
            lavue.notifValeur(lemodel.getVal());
            lavue.createTimer();
        } catch (PlateauNonPermisException e) {
        e.printStackTrace();
    }
    }

    @Override
    public void setEtatCourant(IEtatPlateau etatPlateau) {
        this.etatCourant = etatPlateau;
    }

    @Override
    public IEtatPlateau getEtatCourant() {
        return this.etatCourant;
    }

    @Override
    public IEtatPlateau getEnJeu() {
        return etatEnJeu;
    }

    @Override
    public IEtatPlateau getEnInit() {
        return etatInit;
    }

    @Override
    public IEtatPlateau getEnFinJeu() {
        return etatEnFinJeu;
    }

    @Override
    public void subscribeCase(IObservableCase iobc) {
        listPresCase.add(iobc);
        iobc.addObserver(this);
    }

    @Override
    public void updateFromCase(IObservableCase iobc)  {
        try {
            etatCourant.jouer(this.listPresCase.indexOf(iobc));
            lavue.notifTimerFin();
            if(!etatCourant.equals(etatEnFinJeu)){
                lavue.createTimer();
            }
            lavue.notifValeur(lemodel.getVal());
//            Log.d(this.toString(),"notifButton rejouer");
            lavue.notifButton(lemodel.isButtontouchable());
        } catch (PlateauNonPermisException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addObserver(IObserverOfPlateau iobr) {
        listIObserverOfP.add(iobr);
    }

    @Override
    public void removeObserver(IObservablePlateau iobr) {
        listIObserverOfP.remove(iobr);
    }

    @Override
    public void notifyObserverReset() {
        Log.d(this.toString(),"notifyObserverReset");
        for(IObserverOfPlateau iobr:listIObserverOfP){
            PresentationCase pc = (PresentationCase)iobr;
            pc.actionReset();
        }
    }


    @Override
    public void notifyObserverFin() {
        for(IObserverOfPlateau iobr:listIObserverOfP){
            PresentationCase pc = (PresentationCase)iobr;
            pc.actionFin();
        }
        lavue.notifTimerFin();
    }
}
