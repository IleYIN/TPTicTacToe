package fr.ensma.a3.ia.tp.tictactoe.plateau;

import fr.ensma.a3.ia.tp.tictactoe.buttonCase.IObserverOfPlateau;

public interface IObservablePlateau {
    public void addObserver(IObserverOfPlateau iobr);
    public void removeObserver(IObservablePlateau iobr);
    public void notifyObserverReset();
    public void notifyObserverFin();
}
