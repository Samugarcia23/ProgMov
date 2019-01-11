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

    private Button btnlogin, btnsignup;
    private EditText tbxmail, tbxpass;
    public ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogin = findViewById(R.id.btnlogin);
        btnsignup = findViewById(R.id.btnsignup);

        tbxmail = findViewById(R.id.tbxmail);
        tbxpass = findViewById(R.id.tbxpass);

        viewModel = ViewModelProviders.of(this).get(MiViewModel.class);

        btnlogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String email = tbxmail.getText().toString();
        String password = tbxpass.getText().toString();
        if(email.equals("")){
            Toast toast = Toast.makeText(this, "Introduce un mail válido", Toast.LENGTH_SHORT);
            toast.show();
        }else{
            if(password.equals("")){
                Toast toast = Toast.makeText(this, "Introduce una contraseña válida", Toast.LENGTH_SHORT);
                toast.show();
            }else
                addUser(email, password);
        }

    }

    public void addUser(String mail, String pass){
        if (!((MiViewModel) viewModel).setUser(mail, pass)){
            Toast toast = Toast.makeText(this, "El mail introducido ya existe", Toast.LENGTH_SHORT);
            toast.show();
        }else{
            Intent intent = new Intent(MainActivity.this, logged.class);
            startActivity(intent);
        }
    }


    public void limpiar(){
        tbxmail.setText("");
        tbxpass.setText("");
        tbxmail.requestFocus();
    }
}
