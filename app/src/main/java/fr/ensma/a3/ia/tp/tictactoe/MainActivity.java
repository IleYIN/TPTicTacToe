package fr.ensma.a3.ia.tp.tictactoe;

import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.tp.tictactoe.accel.AcquAccel;
import fr.ensma.a3.ia.tp.tictactoe.accel.MDDAccel;
import fr.ensma.a3.ia.tp.tictactoe.buttonCase.CaseVue;
import fr.ensma.a3.ia.tp.tictactoe.buttonCase.PresentationCase;
import fr.ensma.a3.ia.tp.tictactoe.plateau.PlateauVue;
import fr.ensma.a3.ia.tp.tictactoe.plateau.PresentationPlateau;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private ProgressBar laBarre;

    private  List<Button> listButtons = new ArrayList<Button>();

    private Button resetbutton;

    private TextView whowins;

    private TextView textAccel;
    private SensorManager sensM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textAccel = findViewById(R.id.text_accel);
        sensM = (SensorManager)getSystemService(SENSOR_SERVICE);

        whowins = findViewById(R.id.whowins);

        laBarre = findViewById(R.id.la_bar);

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
        PlateauVue prespl = new PlateauVue(presentationPlateau,resetbutton,whowins,laBarre, textAccel, sensM);
        presentationPlateau.setLavue(prespl);

        for(Button button:listButtons){
            PresentationCase presCase = new PresentationCase();
            CaseVue caze = new CaseVue(presCase, button);
            presCase.setLavue(caze);
            presCase.subscribePlateau(presentationPlateau);
            presentationPlateau.subscribeCase(presCase);
        }

    }




}
