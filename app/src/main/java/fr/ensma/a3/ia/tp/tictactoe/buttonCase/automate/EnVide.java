package fr.ensma.a3.ia.tp.tictactoe.buttonCase.automate;

import fr.ensma.a3.ia.tp.tictactoe.buttonCase.ModelCase;

public class EnVide extends AbsEtatCase {


    public EnVide(IGestionEtatCase monautomate, ModelCase lemodel) {
        super(monautomate, lemodel);
    }

    @Override
    public void touche() throws CaseNonPermisException {
        monautomate.setEtatCourant(monautomate.getEnTouche());
    }


}
