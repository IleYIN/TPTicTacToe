package fr.ensma.a3.ia.tp.tictactoe.plateau;

public class ModelPlateau {

    private boolean joueur;
    private boolean reset;

    public ModelPlateau(){
        this.joueur = false;
        this.reset = false;
    }

    public boolean isReset() {
        return reset;
    }

    public void setReset(boolean reset) {
        this.reset = reset;
    }

    public boolean isValChamp(){return joueur;}

    public void setValChamp(boolean joueur){
        this.joueur = joueur;
    }
}
