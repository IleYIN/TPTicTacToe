package fr.ensma.a3.ia.tp.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.ensma.a3.ia.tp.tictactoe.buttonCase.CaseVue;
import fr.ensma.a3.ia.tp.tictactoe.buttonCase.IObservableCase;
import fr.ensma.a3.ia.tp.tictactoe.buttonCase.PresentationCase;
import fr.ensma.a3.ia.tp.tictactoe.plateau.PlateauVue;
import fr.ensma.a3.ia.tp.tictactoe.plateau.PresentationPlateau;

public class MainActivity extends AppCompatActivity/* implements View.OnClickListener*/{

    Button button1;
    Button button2;
//    Button button3;
//    Button button4;
//    Button button5;
//    Button button6;
//    Button button7;
//    Button button8;
//    Button button9;

//    Button resetbutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        button1 = findViewById(R.id.button01);
        button2 = findViewById(R.id.button02);
//            button3 = findViewById(R.id.button03);
//        button4 = findViewById(R.id.button04);
//        button5 = findViewById(R.id.button05);
//        button6 = findViewById(R.id.button06);
//        button7 = findViewById(R.id.button07);
//        button8 = findViewById(R.id.button08);
//        button9 = findViewById(R.id.button09);
//        resetbutton = findViewById(R.id.button10);

//        PresentationPlateau presentationPlateau = new PresentationPlateau();
//        PlateauVue prespl = new PlateauVue(presentationPlateau,resetbutton);
//        presentationPlateau.setLavue(prespl);

        PresentationCase pres = new PresentationCase();
        CaseVue case1 = new CaseVue(pres, button1);
        pres.setLavue(case1);

        PresentationCase pres2 = new PresentationCase();
        CaseVue case2 = new CaseVue(pres, button2);
        pres.setLavue(case2);

//        presentationPlateau.subscribeCase((IObservableCase)pres);
//        presentationPlateau.subscribeCase((IObservableCase)pres2);
//        button1.setOnClickListener(this);
//        button2.setOnClickListener(this);
//        button3.setOnClickListener(this);
//        button4.setOnClickListener(this);
//        button5.setOnClickListener(this);
//        button6.setOnClickListener(this);
//        button7.setOnClickListener(this);
//        button8.setOnClickListener(this);
//        button9.setOnClickListener(this);
    }

//    @Override
//    public void onClick(View v) {
//        button1.setText("hi");
//    }
}
