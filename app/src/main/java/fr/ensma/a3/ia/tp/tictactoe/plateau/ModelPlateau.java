package fr.ensma.a3.ia.tp.tictactoe.plateau;

import android.util.Log;

public class ModelPlateau {

    private boolean joueur;
    private boolean reset;

    private int [][] boardStatus = new int[3][3];
    private String val;
    private boolean buttontouchable;

    public ModelPlateau(){
        this.joueur = false;//false = 'X', true = 'O'
        this.reset = false;
        this.buttontouchable = false;
        this.val = "en cour du jeu, tour de "+((this.isJoueur())?"O":"X");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                boardStatus[i][j] = -1;
            }
        }
    }

    public void setButtontouchable(boolean buttontouchable) {
        this.buttontouchable = buttontouchable;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public boolean isReset() {
        return reset;
    }

    public void setReset(boolean reset) {
        this.reset = reset;
    }

    public boolean isJoueur(){return joueur;}

    public void setJoueur(boolean joueur){
        this.joueur = joueur;
    }

    public boolean isButtontouchable() {
        return buttontouchable;
    }

    public void resetBoardStatus(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                boardStatus[i][j] = -1;
            }
        }
    }
    public void setBoardStatus(int x, int y, boolean joueur){
        if((0<=x)&&(x<3)&&(0<=y)&&(y<3)){
            boardStatus[x][y] = joueur?0:1;//0:O,1:X
        } else {
            Log.d(this.toString(), "x et y non acceptable");
        }

    }

    public boolean checkWinner(){

        //Horizontal --- rows
        for(int i=0; i<3; i++){
            if(boardStatus[i][0] != -1 && boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2] ){
                if (boardStatus[i][0]==1){
                    this.val = ("Player X winner " + (i+1)+" row");
                }
                else if (boardStatus[i][0]==0) {
                    this.val = ("Player 0 winner " + (i+1)+" row");
                }
                return true;
            }
        }

        //Vertical --- columns
        for(int i=0; i<3; i++){
            if(boardStatus[0][i] != -1 && boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i]){
                if (boardStatus[0][i]==1){
                    this.val = ("Player X winner " + (i+1)+" column");
                }
                else if (boardStatus[0][i]==0) {
                    this.val = ("Player 0 winner " + (i+1)+" column");
                }
                return true;
            }
        }

        //First diagonal
        if(boardStatus[0][0] != -1 && boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2]){
            if (boardStatus[0][0]==1){
                this.val = ("Player X winner First Diagonal");
            }
            else if (boardStatus[0][0]==0) {
                this.val = ("Player 0 winner First Diagonal");
            }
            return true;
        }

        //Second diagonal
        if(boardStatus[0][2] != -1 && boardStatus[0][2] == boardStatus[1][1] && boardStatus[0][2] == boardStatus[2][0]){
            if (boardStatus[0][2]==1){
                this.val = ("Player X winner Second Diagonal");
            }
            else if (boardStatus[0][2]==0) {
                this.val = ("Player 0 winner Second Diagonal");
            }
            return true;
        }

        boolean fin = true;
        for(int i=0; i<3; i++){
            for(int j=0;j<3;j++){
                if(boardStatus[i][j]==-1){
                    fin = false;
                }
            }
        }
        if(fin){
            this.val = ("No winner");
         }
        return fin;
    }
}

