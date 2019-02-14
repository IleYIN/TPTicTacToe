package fr.ensma.a3.ia.tp.tictactoe.buttonCase;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.tp.tictactoe.buttonCase.automate.CaseNonPermisException;
import fr.ensma.a3.ia.tp.tictactoe.buttonCase.automate.EnFin;
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
    private IEtatCase etatEnFin;

    public PresentationCase(){
        listObserverCase = new ArrayList<IObserverOfCase>();
        lemodel = new ModelCase();
        etatCourant = new EnVide(this,lemodel);
        etatVide = new EnVide(this,lemodel);
        etatEnTouche = new EnTouche(this,lemodel);
        etatEnFin = new EnFin(this,lemodel);
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
            //faire intention aux ordres des trois commandes suivantes!!!
            etatCourant.touche();
            lavue.notifValeur(lemodel.getValChamp());
            lavue.notifButton(lemodel.isTouchable());
        } catch (CaseNonPermisException e) {
            e.printStackTrace();
        }
    }

    public void actionReset(){
        try {
            etatCourant.reset();
            lavue.notifValeur(lemodel.getValChamp());
            lavue.notifButton(lemodel.isTouchable());
        } catch (CaseNonPermisException e) {
            e.printStackTrace();
        }
    }

    public void actionFin(){
      try{
          etatCourant.finir();
          lavue.notifValeur(lemodel.getValChamp());
          lavue.notifButton(lemodel.isTouchable());
      }  catch (CaseNonPermisException e) {
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
    public IEtatCase getEnFin() {
        return this.etatEnFin;
    }

    @Override
    public void addObserver(IObserverOfCase iobr) {
        listObserverCase.add(iobr);
    }

    @Override
    public void removeObserver(IObservableCase iobr) {
        listObserverCase.remove(iobr);
    }

    public void notifyObserverPlateau() {
        for(IObserverOfCase observer:listObserverCase){
            observer.updateFromCase(this);
        }
    }

    @Override
    public void subscribePlateau(IObservablePlateau iobs) {
        this.presPlateau = (PresentationPlateau)iobs;
        iobs.addObserver(this);
    }

    @Override
    public String updateFromPlateau() {
        this.notifyObserverPlateau();
        if(!presPlateau.getLemodel().isReset()){
            if(presPlateau.getLemodel().isJoueur()){
               return "O";
            } else {
               return "X";
            }
        } else {
           return "";
        }
    }
}
