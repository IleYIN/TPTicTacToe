package fr.ensma.a3.ia.tp.tictactoe.plateau.automate;

import fr.ensma.a3.ia.tp.tictactoe.plateau.ModelPlateau;

public class EnJeu extends AbsEtatPlateau {


    public EnJeu(IGestionEtatPlateau monautomate, ModelPlateau lemodel) {
        super(monautomate, lemodel);
    }

    @Override
    public void reset() throws PlateauNonPermisException {
        lemodel.setReset(true);
        monautomate.setEtatCourant(monautomate.getEnInit());
    }

    @Override
    public void jouer() throws PlateauNonPermisException {
        lemodel.setValChamp(!lemodel.isValChamp());
    }
}
