package fr.ensma.a3.ia.tp.tictactoe.plateau;

public class ModelPlateau {

    private boolean buttontouchable;
    private boolean joueur;
    private boolean reset;

    public ModelPlateau(){
        this.joueur = false;
        this.reset = false;
        this.buttontouchable = false;
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

    public boolean isButtontouchable() {
        return buttontouchable;
    }

    public void setButtontouchable(boolean buttontouchable) {
        if
        this.buttontouchable = buttontouchable;
    }
}

