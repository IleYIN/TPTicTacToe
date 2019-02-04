package fr.ensma.a3.ia.tp.tictactoe.plateau.automate;

import fr.ensma.a3.ia.tp.tictactoe.plateau.ModelPlateau;

public class EnInit extends AbsEtatPlateau {


    public EnInit(IGestionEtatPlateau monautomate, ModelPlateau lemodel) {
        super(monautomate, lemodel);
    }

    @Override
    public void jouer() throws PlateauNonPermisException {
        lemodel.setReset(false);
        lemodel.setValChamp(!lemodel.isValChamp());
        monautomate.setEtatCourant(monautomate.getEnJeu());
    }


}
