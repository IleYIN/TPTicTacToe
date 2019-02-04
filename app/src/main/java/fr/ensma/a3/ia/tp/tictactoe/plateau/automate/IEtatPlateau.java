package fr.ensma.a3.ia.tp.tictactoe.plateau.automate;

public interface IEtatPlateau {
    public void jouer() throws PlateauNonPermisException;
    public void reset() throws PlateauNonPermisException;
}
