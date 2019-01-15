package com.example.sam.ejemplologin;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnlogin, btnnoacc;
    private EditText tbxuser, tbxpass;
    public ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogin = findViewById(R.id.btnlogin);
        btnnoacc = findViewById(R.id.btnnoacc);

        tbxuser = findViewById(R.id.tbxuser);
        tbxpass = findViewById(R.id.tbxpass);

        viewModel = ViewModelProviders.of(this).get(MiViewModel.class);

        btnlogin.setOnClickListener(this);

        btnnoacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        String username = tbxuser.getText().toString();
        String password = tbxpass.getText().toString();
        if(username.equals("")){
            Toast toast = Toast.makeText(this, "Introduce un nombre de usuario válido", Toast.LENGTH_SHORT);
            toast.show();
        }else{
            if(password.equals("")){
                Toast toast = Toast.makeText(this, "Introduce una contraseña válida", Toast.LENGTH_SHORT);
                toast.show();
            }else
                log(username, password);
        }

    }

    public void log(String user, String pass){
        if (!((MiViewModel) viewModel).comprobarDatos(user, pass)){
            Toast toast = Toast.makeText(this, "Los datos no son correctos", Toast.LENGTH_SHORT);
            toast.show();
        }else{
            limpiar();
            Intent intent = new Intent(MainActivity.this, logged.class);
            startActivity(intent);
        }
    }

    public void limpiar(){
        tbxuser.setText("");
        tbxpass.setText("");
        tbxuser.requestFocus();
    }
}
