package fr.ensma.a3.ia.tp.tictactoe.plateau.automate;

public interface IEtatPlateau {
    public void jouer(int ord) throws PlateauNonPermisException;
    public void reset() throws PlateauNonPermisException;
}
