package fr.ensma.a3.ia.tp.tictactoe.plateau.automate;

import fr.ensma.a3.ia.tp.tictactoe.plateau.ModelPlateau;

public class EnInit extends AbsEtatPlateau {


    public EnInit(IGestionEtatPlateau monautomate, ModelPlateau lemodel) {
        super(monautomate, lemodel);
    }

    @Override
    public void jouer() throws PlateauNonPermisException {
        lemodel.setReset(false);
        monautomate.setEtatCourant(monautomate.getEnJeu());
    }

    @Override
    public void reset() throws PlateauNonPermisException {
        //faire rien
    }


}
