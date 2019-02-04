package fr.ensma.a3.ia.tp.tictactoe.plateau;

import fr.ensma.a3.ia.tp.tictactoe.buttonCase.IObservableCase;

public interface IObserverOfCase {
    public void subscribeCase(IObservableCase iobc);
    public void updateFromCase();
}
