package fr.ensma.a3.ia.tp.tictactoe.buttonCase;

import fr.ensma.a3.ia.tp.tictactoe.plateau.IObservablePlateau;

public interface IObserverOfPlateau {
    public void subscribePlateau(IObservablePlateau iobs);
    public void updateFromPlateau();
}
