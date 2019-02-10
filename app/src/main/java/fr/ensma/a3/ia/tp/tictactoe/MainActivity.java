package fr.ensma.a3.ia.tp.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.tp.tictactoe.buttonCase.CaseVue;
import fr.ensma.a3.ia.tp.tictactoe.buttonCase.PresentationCase;
import fr.ensma.a3.ia.tp.tictactoe.plateau.PlateauVue;
import fr.ensma.a3.ia.tp.tictactoe.plateau.PresentationPlateau;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;

    List<Button> listButtons = new ArrayList<Button>();

    Button resetbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button01);
        button2 = findViewById(R.id.button02);
        button3 = findViewById(R.id.button03);
        button4 = findViewById(R.id.button04);
        button5 = findViewById(R.id.button05);
        button6 = findViewById(R.id.button06);
        button7 = findViewById(R.id.button07);
        button8 = findViewById(R.id.button08);
        button9 = findViewById(R.id.button09);
        resetbutton = findViewById(R.id.button10);

        listButtons.add(button1);
        listButtons.add(button2);
        listButtons.add(button3);
        listButtons.add(button4);
        listButtons.add(button5);
        listButtons.add(button6);
        listButtons.add(button7);
        listButtons.add(button8);
        listButtons.add(button9);

        PresentationPlateau presentationPlateau = new PresentationPlateau();
        PlateauVue prespl = new PlateauVue(presentationPlateau,resetbutton);
        presentationPlateau.setLavue(prespl);

        for(Button button:listButtons){
            PresentationCase pres = new PresentationCase();
            CaseVue caze = new CaseVue(pres, button);
            pres.setLavue(caze);
            pres.subscribePlateau(presentationPlateau);
            presentationPlateau.subscribeCase(pres);
        }

    }
}
