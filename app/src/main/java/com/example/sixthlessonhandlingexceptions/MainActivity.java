package com.example.sixthlessonhandlingexceptions;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private TextView equationOne, equationTwo, equationThree;
    private EditText solvingOne, solvingTwo, solvingThree;
    private int[] equationValue;
    private boolean right = false;

    private Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        equationOne = findViewById(R.id.equationOne);
        equationTwo = findViewById(R.id.equationTwo);
        equationThree = findViewById(R.id.equationThree);
        solvingOne = findViewById(R.id.solvingOne);
        solvingTwo = findViewById(R.id.solvingTwo);
        solvingThree = findViewById(R.id.solvingThree);

        button = findViewById(R.id.button);


        equationValue = valueArrayRandom();

        equationOne.setText(equationValue[0] + " + " + equationValue[1] + " = ");
        equationTwo.setText(equationValue[2] + " + " + equationValue[3] + " = ");
        equationThree.setText(equationValue[4] + " + " + equationValue[5] + " = ");


        solvingOne.setOnFocusChangeListener(focusListener);
        solvingTwo.setOnFocusChangeListener(focusListener);
        solvingThree.setOnFocusChangeListener(focusListener);

        button.setOnClickListener(listener);
    }


    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(right) {
                equationValue = valueArrayRandom();

                equationOne.setText(equationValue[0] + " + " + equationValue[1] + " = ");
                equationTwo.setText(equationValue[2] + " + " + equationValue[3] + " = ");
                equationThree.setText(equationValue[4] + " + " + equationValue[5] + " = ");
                solvingOne.setBackgroundColor(Color.rgb(0xE7,0xE4, 0xEC));
                solvingTwo.setBackgroundColor(Color.rgb(0xE7,0xE4, 0xEC));
                solvingThree.setBackgroundColor(Color.rgb(0xE7,0xE4, 0xEC));

                solvingOne.setText("");
                solvingTwo.setText("");
                solvingThree.setText("");
            }
        }
    };

    private View.OnFocusChangeListener focusListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View view, boolean b) {

            switch (view.getId()) {
                case R.id.solvingOne:
                    if(!b) {
                        try {

                            if (Integer.parseInt(solvingOne.getText().toString()) == (equationValue[0] + equationValue[1])) {
                                solvingOne.setBackgroundColor(Color.GREEN);
                                right = true;
                            } else {
                                solvingOne.setBackgroundColor(Color.RED);
                                right = false;
                            }
                        } catch (NumberFormatException exception){

                            solvingOne.setText("");

                            Toast.makeText(MainActivity.this, "Р’С‹ РЅРµ РґР°Р»Рё РѕС‚РІРµС‚Р°", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;
                case R.id.solvingTwo:
                    if(!b) {
                        try {

                            if (Integer.parseInt(solvingTwo.getText().toString()) == (equationValue[2] + equationValue[3])) {
                                solvingTwo.setBackgroundColor(Color.GREEN);
                                right = true;
                            } else {
                                solvingTwo.setBackgroundColor(Color.RED);
                                right = false;
                            }
                        } catch (NumberFormatException exception){

                            solvingTwo.setText("");

                            Toast.makeText(MainActivity.this, "Р’С‹ РЅРµ РґР°Р»Рё РѕС‚РІРµС‚Р°", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;
                case R.id.solvingThree:
                    if(!b) {
                        try {

                            if (Integer.parseInt(solvingThree.getText().toString()) == (equationValue[4] + equationValue[5])) {
                                solvingThree.setBackgroundColor(Color.GREEN);
                                right = true;
                            } else {
                                solvingThree.setBackgroundColor(Color.RED);
                                right = false;
                            }
                        } catch (NumberFormatException exception){

                            solvingThree.setText("");

                            Toast.makeText(MainActivity.this, "Р’С‹ РЅРµ РґР°Р»Рё РѕС‚РІРµС‚Р°", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;
            }
        }
    };


    private int[] valueArrayRandom() {
        Random random = new Random();
        int[] arrayValue = new int[6];
        for (int i = 0; i < arrayValue.length; i++) {
            arrayValue[i] = random.nextInt(99) + 1;
        }
        return arrayValue;
    }
}