package com.example.examen1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    double prixAjouste, total,dist,perf,prx;
    double AJOUT_DIESEL = 0.25;
    double AJOUT_GAZOLINE = 0.15;

    TextView date, cout;
    EditText distance, performance, prix;
    RadioButton radioButtonDiesel, radioButtonGazoline;
    Button buttonCalculer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        date = findViewById(R.id.date);
        cout = findViewById(R.id.cout);
        distance = findViewById(R.id.distance);
        performance = findViewById(R.id.performance);
        prix = findViewById(R.id.prix);
        radioButtonDiesel = findViewById(R.id.radioButtonDiesel);
        radioButtonGazoline = findViewById(R.id.radioButtonGazoline);
        buttonCalculer = findViewById(R.id.buttonCalculer);


        date.setText(Calendar.getInstance().getTime().toString());

buttonCalculer.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


    if(radioButtonDiesel.isChecked()){
        if(distance.getText().toString().length() > 0 && performance.getText().toString().length() > 0 && prix.getText().toString().length() > 0){
            calculateCout(AJOUT_DIESEL);
            cout.setText("$"+String.format("%.2f",total));
        }else{
            Toast.makeText(MainActivity.this, "Svp completez toutes les information requises", Toast.LENGTH_LONG).show();
        }
    }else if(radioButtonGazoline.isChecked()){
        if(distance.getText().toString().length() > 0 && performance.getText().toString().length() > 0 && prix.getText().toString().length() > 0){
            calculateCout(AJOUT_GAZOLINE);
            cout.setText("$"+String.format("%.2f",total));
        }else{
            Toast.makeText(MainActivity.this, "Svp completez toutes les information requises", Toast.LENGTH_LONG).show();
        }
    }else{
        Toast.makeText(MainActivity.this, "Svp choisissez le type d'essence", Toast.LENGTH_LONG).show();
    }
    }
});

    }
    public void calculateCout(double ajout){
            dist = Double.parseDouble(distance.getText().toString());
            perf =Double.parseDouble(performance.getText().toString());
            prx = Double.parseDouble(prix.getText().toString());
            prixAjouste = prx + ajout;
            perf = perf/100;
            total =dist * perf * prixAjouste;
    }
}