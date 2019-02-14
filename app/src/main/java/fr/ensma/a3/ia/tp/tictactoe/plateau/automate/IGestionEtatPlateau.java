package fr.ensma.a3.ia.tp.tictactoe.plateau.automate;

public interface IGestionEtatPlateau {

    public void setEtatCourant(final IEtatPlateau etatPlateau);
    public IEtatPlateau getEtatCourant();
    public IEtatPlateau getEnJeu();
    public IEtatPlateau getEnInit();
    public IEtatPlateau getEnFinJeu();
}
