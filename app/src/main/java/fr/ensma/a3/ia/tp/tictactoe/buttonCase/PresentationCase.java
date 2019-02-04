package fr.ensma.a3.ia.tp.tictactoe.buttonCase;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.tp.tictactoe.buttonCase.automate.CaseNonPermisException;
import fr.ensma.a3.ia.tp.tictactoe.buttonCase.automate.EnTouche;
import fr.ensma.a3.ia.tp.tictactoe.buttonCase.automate.EnVide;
import fr.ensma.a3.ia.tp.tictactoe.buttonCase.automate.IEtatCase;
import fr.ensma.a3.ia.tp.tictactoe.buttonCase.automate.IGestionEtatCase;
import fr.ensma.a3.ia.tp.tictactoe.plateau.IObservablePlateau;
import fr.ensma.a3.ia.tp.tictactoe.plateau.IObserverOfCase;
import fr.ensma.a3.ia.tp.tictactoe.plateau.PresentationPlateau;

public class PresentationCase implements IGestionEtatCase, IObservableCase, IObserverOfPlateau {

    private ModelCase lemodel;
    private IVueCase lavue;
    private List<IObserverOfCase> listObserverCase;

    private PresentationPlateau presPlateau;

    private IEtatCase etatCourant;
    private IEtatCase etatVide;
    private IEtatCase etatEnTouche;

    public PresentationCase(){
        listObserverCase = new ArrayList<IObserverOfCase>();
        lemodel = new ModelCase();
        etatCourant = new EnVide(this,lemodel);
        etatVide = new EnVide(this,lemodel);
        etatEnTouche = new EnTouche(this,lemodel);
    }

    public ModelCase getLemodel() {
        return lemodel;
    }


    public IVueCase getLavue() {
        return lavue;
    }

    public void setLavue(IVueCase lavue) {
        this.lavue = lavue;
    }

    public void actionTouche() {
        try {
            etatCourant.touche();
            lavue.notifiValeur(lemodel.getValChamp());
            this.notifyObserver();
        } catch (CaseNonPermisException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setEtatCourant(IEtatCase etatCase) {
        this.etatCourant = etatCase;
    }

    @Override
    public IEtatCase getEtatCourant() {
        return this.etatCourant;
    }

    @Override
    public IEtatCase getEnTouche() {
        return this.etatEnTouche;
    }

    @Override
    public IEtatCase getEnVide() {
        return this.etatVide;
    }

    @Override
    public void addObserver(IObserverOfCase iobr) {
        listObserverCase.add(iobr);
    }

    @Override
    public void removeObserver(IObservableCase iobr) {
        listObserverCase.remove(iobr);
    }

    public void notifyObserver() {
        for(IObserverOfCase observer:listObserverCase){
            observer.updateFromCase();
        }
    }

    @Override
    public void subscribePlateau(IObservablePlateau iobs) {
        this.presPlateau = (PresentationPlateau)iobs;
        iobs.addObserver(this);
    }

    @Override
    public void updateFromPlateau() {
        if(presPlateau.getEtatCourant().equals(presPlateau.getEnJeu())){
            if(presPlateau.getLemodel().isValChamp()){
               lemodel.setValChamp("O");
            } else {
               lemodel.setValChamp("X");
            }
        } else {
            lemodel.setValChamp("");
        }
    }
}
