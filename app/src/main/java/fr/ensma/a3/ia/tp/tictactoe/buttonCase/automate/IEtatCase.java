package fr.ensma.a3.ia.tp.tictactoe.buttonCase.automate;

public interface IEtatCase {
    public void touche() throws CaseNonPermisException;
    public void reset() throws CaseNonPermisException;
}
