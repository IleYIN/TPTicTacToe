package fr.ensma.a3.ia.tp.tictactoe.buttonCase.automate;

import fr.ensma.a3.ia.tp.tictactoe.buttonCase.ModelCase;

public class EnFin extends AbsEtatCase {

    public EnFin(IGestionEtatCase monautomate, ModelCase lemodel) {
        super(monautomate, lemodel);
    }

    @Override
    public void reset() throws CaseNonPermisException {
        lemodel.setValChamp("CLICK");
        monautomate.setEtatCourant(monautomate.getEnVide());
        lemodel.setTouchable(true);
    }

}
