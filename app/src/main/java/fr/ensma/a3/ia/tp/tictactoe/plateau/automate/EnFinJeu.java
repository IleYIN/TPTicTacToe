package fr.ensma.a3.ia.tp.tictactoe.plateau.automate;

import fr.ensma.a3.ia.tp.tictactoe.plateau.ModelPlateau;

public class EnFinJeu extends AbsEtatPlateau {

    public EnFinJeu(IGestionEtatPlateau monautomate, ModelPlateau lemodel) {
        super(monautomate, lemodel);
    }

    @Override
    public void reset() throws PlateauNonPermisException {
        monautomate.setEtatCourant(monautomate.getEnInit());
        lemodel.setReset(true);
        lemodel.setJoueur(false);
        lemodel.resetBoardStatus();
        lemodel.setVal("en cour du jeu, tour de X");
        lemodel.setButtontouchable(false);

    }
}
