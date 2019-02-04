package fr.ensma.a3.ia.tp.tictactoe.buttonCase.automate;

import fr.ensma.a3.ia.tp.tictactoe.buttonCase.ModelCase;
import fr.ensma.a3.ia.tp.tictactoe.buttonCase.PresentationCase;

public class EnTouche extends AbsEtatCase  {


    public EnTouche(IGestionEtatCase monautomate, ModelCase lemodel) {
        super(monautomate, lemodel);
    }

    @Override
    public void touche() throws CaseNonPermisException {
        //faire rien
    }

    @Override
    public void reset() throws CaseNonPermisException {
        lemodel.setValChamp("");
        monautomate.setEtatCourant(monautomate.getEnVide());
    }
}
