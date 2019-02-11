package fr.ensma.a3.ia.tp.tictactoe.buttonCase;

public class ModelCase {

    private String valChamp;
    private boolean touchable;

    public ModelCase(){valChamp = "";}

    public String getValChamp(){return valChamp;}

    public void setValChamp(String valChamp){
        this.valChamp = valChamp;
    }

    public boolean isTouchable() {
        return touchable;
    }

    public void setTouchable(boolean touchable) {
        this.touchable = touchable;
    }
}
