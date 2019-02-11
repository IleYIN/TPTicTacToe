package fr.ensma.a3.ia.tp.tictactoe.buttonCase;

import fr.ensma.a3.ia.tp.tictactoe.plateau.IObserverOfCase;

public interface IObservableCase {
    public void addObserver(IObserverOfCase iobr);
    public void removeObserver(IObservableCase iobr);
    public void notifyObserverPlateau();
}