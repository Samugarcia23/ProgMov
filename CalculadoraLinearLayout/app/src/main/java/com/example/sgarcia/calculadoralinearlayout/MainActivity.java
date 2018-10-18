package com.example.sgarcia.calculadoralinearlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bdiv, bsum, bres, bmult, bigual, bclean;
    TextView tvres;
    String mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvres = findViewById(R.id.tvres);
        bigual=findViewById(R.id.bigual);
        numeros();
        calcular();
    }

    public static boolean isNumeric(String cadena) {

        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }

    public void numeros(){
        b0=findViewById(R.id.b0);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);
        bdiv=findViewById(R.id.bdiv);
        bmult=findViewById(R.id.bmult);
        bres=findViewById(R.id.bres);
        bsum=findViewById(R.id.bsum);
        bclean=findViewById(R.id.bclean);
        tvres.setText("");

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrar = tvres.getText().toString();
                mostrar = mostrar + "0";
                tvres.setText(mostrar);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrar = tvres.getText().toString();
                mostrar = mostrar + "1";
                tvres.setText(mostrar);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrar = tvres.getText().toString();
                mostrar = mostrar + "2";
                tvres.setText(mostrar);            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrar = tvres.getText().toString();
                mostrar = mostrar + "3";
                tvres.setText(mostrar);            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrar = tvres.getText().toString();
                mostrar = mostrar + "4";
                tvres.setText(mostrar);            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrar = tvres.getText().toString();
                mostrar = mostrar + "5";
                tvres.setText(mostrar);            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrar = tvres.getText().toString();
                mostrar = mostrar + "6";
                tvres.setText(mostrar);            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrar = tvres.getText().toString();
                mostrar = mostrar + "7";
                tvres.setText(mostrar);            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrar = tvres.getText().toString();
                mostrar = mostrar + "8";
                tvres.setText(mostrar);            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrar = tvres.getText().toString();
                mostrar = mostrar + "9";
                tvres.setText(mostrar);            }
        });

        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrar = tvres.getText().toString();
                mostrar = mostrar + "/";
                tvres.setText(mostrar);
            }
        });

        bmult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrar = tvres.getText().toString();
                mostrar = mostrar + "*";
                tvres.setText(mostrar);            }
        });

        bsum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrar = tvres.getText().toString();
                mostrar = mostrar + "+";
                tvres.setText(mostrar);            }
        });

        bres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrar = tvres.getText().toString();
                mostrar = mostrar + "-";
                tvres.setText(mostrar);
            }
        });

        bclean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvres.setText("");
            }
        });
    }

    public void calcular(){
        bigual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1=0, n2=0, res=0, cont;
                String txt=tvres.getText().toString();
                cont=0;

                if (!txt.contains("*") || !txt.contains("+") || !txt.contains("-") || !txt.contains("/")  ) {
                    tvres.setText("Error, debe haber al menos 1 operador");                }

                if (txt.contains("*")) {
                    cont++;
                    if (cont>1){
                        tvres.setText("Error, no puede haber mas de 1 operador");
                    }
                    if (cont<1){
                        tvres.setText("Error, debe haber al menos 1 operador");
                    }
                    Integer.toString(n1).equals(txt.substring(0, txt.lastIndexOf("*")));
                    Integer.toString(n2).equals(Integer.parseInt(txt.substring(txt.lastIndexOf("*") + 1, txt.length())));
                    if (isNumeric(Integer.toString(n1)) == true && isNumeric(Integer.toString(n2)) == true) {
                        res = n1 * n2;
                        tvres.setText(Integer.toString(res));
                    }else{
                        tvres.setText("Error, Comprueba que ambos numeros son correctos");
                    }

                }

                if (txt.contains("/")) {
                    cont++;
                    if (cont>1){
                        tvres.setText("Error, no puede haber mas de 1 operador");
                    }
                    if (cont<1){
                        tvres.setText("Error, debe haber al menos 1 operador");
                    }
                    Integer.toString(n1).equals(txt.substring(0, txt.lastIndexOf("/")));
                    Integer.toString(n2).equals(Integer.parseInt(txt.substring(txt.lastIndexOf("/") + 1, txt.length())));
                    if (isNumeric(Integer.toString(n1)) == true && isNumeric(Integer.toString(n2)) == true) {
                        if (n2 != 0) {
                            res = (n1 / n2);
                            tvres.setText(Integer.toString(res));
                        }else{
                            if(n2==0)
                                tvres.setText("No se puede dividir entre 0");
                        }
                    }else{
                        tvres.setText("Error, Comprueba que ambos numeros son correctos");
                    }
                }

                if (txt.contains("+")) {
                    cont++;
                    if (cont>1){
                        tvres.setText("Error, no puede haber mas de 1 operador");
                    }
                    if (cont<1){
                        tvres.setText("Error, debe haber al menos 1 operador");
                    }
                    Integer.toString(n1).equals(txt.substring(0, txt.lastIndexOf("+")));
                    Integer.toString(n2).equals(Integer.parseInt(txt.substring(txt.lastIndexOf("+") + 1, txt.length())));
                    if (isNumeric(Integer.toString(n1)) == true && isNumeric(Integer.toString(n2)) == true) {
                        res = (n1 + n2);
                        tvres.setText(Integer.toString(res));
                    }else{
                        tvres.setText("Error, Comprueba que ambos numeros son correctos");
                    }
                }

                if (txt.contains("-")) {
                    cont++;
                    if (cont>1){
                        tvres.setText("Error, no puede haber mas de 1 operador");
                    }
                    if (cont<1){
                        tvres.setText("Error, debe haber al menos 1 operador");
                    }
                    Integer.toString(n1).equals(txt.substring(0, txt.lastIndexOf("-")));
                    Integer.toString(n2).equals(Integer.parseInt(txt.substring(txt.lastIndexOf("-") + 1, txt.length())));
                    if (isNumeric(Integer.toString(n1)) == true && isNumeric(Integer.toString(n2)) == true) {
                        res = n1 - n2;
                        tvres.setText(Integer.toString(res));
                    }else{
                        tvres.setText("Error, Comprueba que ambos numeros son correctos");
                    }
                }
            }
        });
    }
}
