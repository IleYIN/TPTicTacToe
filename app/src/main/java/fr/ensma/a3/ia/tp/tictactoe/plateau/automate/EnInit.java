package fr.ensma.a3.ia.tp.tictactoe.plateau.automate;

import fr.ensma.a3.ia.tp.tictactoe.plateau.ModelPlateau;
import fr.ensma.a3.ia.tp.tictactoe.plateau.PresentationPlateau;

public class EnInit extends AbsEtatPlateau {


    public EnInit(IGestionEtatPlateau monautomate, ModelPlateau lemodel) {
        super(monautomate, lemodel);
    }

    @Override
    public void timesup() throws PlateauNonPermisException {
       lemodel.setJoueur(!lemodel.isJoueur());
        lemodel.setVal("en cour du jeu, tour de "+((lemodel.isJoueur())?"O":"X"));
    }

    @Override
    public void jouer(int ord) throws PlateauNonPermisException {
        lemodel.setReset(false);
        lemodel.setVal("en cour du jeu, tour de "+((lemodel.isJoueur())?"X":"O"));
        monautomate.setEtatCourant(monautomate.getEnJeu());

        switch(ord){
            case 0:
                lemodel.setBoardStatus(0,0,lemodel.isJoueur());
                break;
            case 1:
                lemodel.setBoardStatus(0,1,lemodel.isJoueur());
                break;
            case 2:
                lemodel.setBoardStatus(0,2,lemodel.isJoueur());
                break;
            case 3:
                lemodel.setBoardStatus(1,0,lemodel.isJoueur());
                break;
            case 4:
                lemodel.setBoardStatus(1,1,lemodel.isJoueur());
                break;
            case 5:
                lemodel.setBoardStatus(1,2,lemodel.isJoueur());
                break;
            case 6:
                lemodel.setBoardStatus(2,0,lemodel.isJoueur());
                break;
            case 7:
                lemodel.setBoardStatus(2,1,lemodel.isJoueur());
                break;
            case 8:
                lemodel.setBoardStatus(2,2,lemodel.isJoueur());
                break;
            default:
                break;
        }

//        if(lemodel.checkWinner()){
//            monautomate.setEtatCourant(monautomate.getEnFinJeu());
//            lemodel.setButtontouchable(true);
//            PresentationPlateau pr = (PresentationPlateau)monautomate;
//            pr.notifyObserverFin();
//        }
    }

}
