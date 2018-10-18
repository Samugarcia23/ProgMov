package com.example.sam.ejercicio8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * Declaramos los elementos que vamos a utilizar, en este caso seran 3 EditText(2 para introducir numeros y otro para el resultado),
     * 4 RadioButton(1 para cada operación) y 1 botón para realizar el cálculo
     **/

    private EditText num1, num2, res;
    private RadioButton rbadd, rbsub, rbmult, rbdiv;
    private Button bcalc;

    /**
     * Llamamos al método calcular() al iniciar la aplicación, para que ejecute su código una vez pulsemos el botón
     **/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        res = findViewById(R.id.res);
        calcular();
    }

    /**
     * Para empezar, asignamos a cada radiobutton y al boton creados anteriormente su identificador del activity_main,
     * ademas asignamos un onClickListener() al boton. Creamos el metodo onClick(), para cuando pulsempos el boton.
     * Comprobará cual de los radiobutton esta activado con isChecked() y ejecutará la operacion asignada.
     * Antes de realizar esto, para evitar excepciones,
     * se comprueba que hay al menos 1 rb seleccionado y que los editText no esten vacios.
     **/

    public void calcular(){
        rbadd = findViewById(R.id.rbadd);
        rbsub = findViewById(R.id.rbsub);
        rbmult = findViewById(R.id.rbmult);
        rbdiv = findViewById(R.id.rbdiv);

        bcalc = findViewById(R.id.bcalc);
        bcalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!rbadd.isChecked() && !rbsub.isChecked() && !rbmult.isChecked() && !rbdiv.isChecked()) {
                    toast("No has seleccionado ninguna opcion");
                }
                if(num1.getText().toString().equals("") || num2.getText().toString().equals("")){
                        toast("Debes introducir ambos numeros");
                }else{
                    if (rbadd.isChecked()){
                        res.setText(String.valueOf(Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString())));
                    }else{
                        if (rbsub.isChecked()){
                            res.setText(String.valueOf(Integer.parseInt(num1.getText().toString()) - Integer.parseInt(num2.getText().toString())));
                        }else{
                            if (rbmult.isChecked()){
                                res.setText(String.valueOf(Integer.parseInt(num1.getText().toString()) * Integer.parseInt(num2.getText().toString())));
                            }else{
                                if (rbdiv.isChecked()){
                                    res.setText(String.valueOf(Integer.parseInt(num1.getText().toString()) / Integer.parseInt(num2.getText().toString())));
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    /**
     * Este metodo nos ahorra tener que escribir varias veces el codigo para crear un toast, a solo tener que escribir
     * la llamada del metodo y el mensaje
     **/

    public void toast(String mensaje){
        Toast toast1 = Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT);
        toast1.setGravity(Gravity.CENTER, 0, 500);
        toast1.show();
    }
}
