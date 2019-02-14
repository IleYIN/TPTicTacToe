package fr.ensma.a3.ia.tp.tictactoe.buttonCase.automate;

import fr.ensma.a3.ia.tp.tictactoe.buttonCase.ModelCase;
import fr.ensma.a3.ia.tp.tictactoe.buttonCase.PresentationCase;


public class EnVide extends AbsEtatCase {


    public EnVide(IGestionEtatCase monautomate, ModelCase lemodel) {
        super(monautomate, lemodel);
    }

    @Override
    public void touche() throws CaseNonPermisException {
        monautomate.setEtatCourant(monautomate.getEnTouche());
        PresentationCase pc = (PresentationCase)monautomate;
        lemodel.setValChamp(pc.updateFromPlateau());
        lemodel.setTouchable(false);
    }

    @Override
    public void reset() throws CaseNonPermisException {
       lemodel.setValChamp("CLICK");
       lemodel.setTouchable(true);
    }
}
