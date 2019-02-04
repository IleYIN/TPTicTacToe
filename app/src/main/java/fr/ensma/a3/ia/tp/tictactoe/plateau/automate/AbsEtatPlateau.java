package fr.ensma.a3.ia.tp.tictactoe.plateau.automate;

import fr.ensma.a3.ia.tp.tictactoe.plateau.ModelPlateau;

public class AbsEtatPlateau implements IEtatPlateau {

    protected IGestionEtatPlateau monautomate;
    protected ModelPlateau lemodel;

    public AbsEtatPlateau(IGestionEtatPlateau monautomate, ModelPlateau lemodel) {
        this.monautomate = monautomate;
        this.lemodel = lemodel;
    }

    @Override
    public void jouer() throws PlateauNonPermisException {
        throw new PlateauNonPermisException();
    }

    @Override
    public void reset() throws PlateauNonPermisException {
        throw new PlateauNonPermisException();
    }
}
