package fr.ensma.a3.ia.tp.tictactoe.buttonCase.automate;

public interface IGestionEtatCase {

    public void setEtatCourant(final IEtatCase etatCase);
    public IEtatCase getEtatCourant();
    public IEtatCase getEnTouche();
    public IEtatCase getEnVide();
    public IEtatCase getEnFin();
}
