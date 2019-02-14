package fr.ensma.a3.ia.tp.tictactoe.buttonCase.automate;

import fr.ensma.a3.ia.tp.tictactoe.buttonCase.ModelCase;
import fr.ensma.a3.ia.tp.tictactoe.buttonCase.PresentationCase;

public abstract class AbsEtatCase implements IEtatCase{

    protected IGestionEtatCase monautomate;
    protected ModelCase lemodel;

    public AbsEtatCase(IGestionEtatCase monautomate, ModelCase lemodel) {
        this.monautomate = monautomate;
        this.lemodel = lemodel;
    }

    @Override
    public void touche() throws CaseNonPermisException {
        throw new CaseNonPermisException();
    }

    @Override
    public void reset() throws CaseNonPermisException {
        throw new CaseNonPermisException();
    }

    @Override
    public void finir() throws CaseNonPermisException  {
        throw new CaseNonPermisException();
    }
}
