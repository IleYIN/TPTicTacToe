package fr.ensma.a3.ia.tp.tictactoe.plateau;


import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.tp.tictactoe.buttonCase.IObservableCase;
import fr.ensma.a3.ia.tp.tictactoe.buttonCase.IObserverOfPlateau;
import fr.ensma.a3.ia.tp.tictactoe.buttonCase.PresentationCase;
import fr.ensma.a3.ia.tp.tictactoe.buttonCase.automate.CaseNonPermisException;
import fr.ensma.a3.ia.tp.tictactoe.buttonCase.automate.EnTouche;
import fr.ensma.a3.ia.tp.tictactoe.buttonCase.automate.IEtatCase;
import fr.ensma.a3.ia.tp.tictactoe.plateau.automate.EnInit;
import fr.ensma.a3.ia.tp.tictactoe.plateau.automate.EnJeu;
import fr.ensma.a3.ia.tp.tictactoe.plateau.automate.IEtatPlateau;
import fr.ensma.a3.ia.tp.tictactoe.plateau.automate.IGestionEtatPlateau;
import fr.ensma.a3.ia.tp.tictactoe.plateau.automate.PlateauNonPermisException;

public class PresentationPlateau implements IGestionEtatPlateau, IObserverOfCase,IObservablePlateau {

    private List<PresentationCase> listPresCase;
    List<IObserverOfPlateau> listIObserverOfP;

    private ModelPlateau lemodel;
    private IVuePlateau lavue;

    private IEtatPlateau etatCourant;
    private IEtatPlateau etatInit;
    private IEtatPlateau etatEnJeu;

    public PresentationPlateau() {
        listPresCase = new ArrayList<PresentationCase>();
        listIObserverOfP = new ArrayList<IObserverOfPlateau>();
        lemodel = new ModelPlateau();
        etatCourant = new EnJeu(this,lemodel);
        etatInit= new EnInit(this,lemodel);
        etatEnJeu = new EnJeu(this,lemodel);
    }

    public IVuePlateau getLavue() {
        return lavue;
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
            this.notifyObserver();
        } catch (PlateauNonPermisException e) {
            e.printStackTrace();
        }

        //TODO
//        lavue.notifiValeur(lemodel.getValChamp());
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
    public void subscribeCase(IObservableCase iobc) {
        PresentationCase presCase = (PresentationCase)iobc;
        listPresCase.add(presCase);
        iobc.addObserver(this);
    }

    @Override
    public void updateFromCase()  {
        try {
            etatCourant.jouer();
            this.notifyObserver();
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
    public void notifyObserver() {
        for(IObserverOfPlateau iobr:listIObserverOfP){
            iobr.updateFromPlateau();
        }
    }
}