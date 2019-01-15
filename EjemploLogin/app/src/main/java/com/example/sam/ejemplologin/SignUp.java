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

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private Button btnhaveacc, btnsignup;
    private EditText tbxmail, tbxpass, tbxuser;
    public ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnsignup = findViewById(R.id.btnsignup);
        btnhaveacc = findViewById(R.id.btnhaveacc);

        tbxmail = findViewById(R.id.tbxuser);
        tbxpass = findViewById(R.id.tbxpass);
        tbxuser = findViewById(R.id.tbxUser);

        viewModel = ViewModelProviders.of(this).get(MiViewModel.class);

        btnsignup.setOnClickListener(this);

        btnhaveacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        String email = tbxmail.getText().toString();
        String password = tbxpass.getText().toString();
        String username = tbxuser.getText().toString();

        if(email.equals("")){
            Toast toast = Toast.makeText(this, "Introduce un mail válido", Toast.LENGTH_SHORT);
            toast.show();
        }else{
            if(password.equals("")){
                Toast toast = Toast.makeText(this, "Introduce una contraseña válida", Toast.LENGTH_SHORT);
                toast.show();
            }else{
                if(username.equals("")){
                    Toast toast = Toast.makeText(this, "Introduce un usuario válida", Toast.LENGTH_SHORT);
                    toast.show();
                }else
                    addUser(username, password, email);
            }

        }
    }

    public void addUser(String mail, String pass, String user){
        if (((MiViewModel) viewModel).mailExists(mail)){
            Toast toast = Toast.makeText(this, "El mail introducido ya está registrado", Toast.LENGTH_SHORT);
            toast.show();
        }else{
            ((MiViewModel) viewModel).addUser(user, pass, mail);
            Intent intent = new Intent(SignUp.this, MainActivity.class);
            startActivity(intent);
        }
    }


    public void limpiar(){
        tbxmail.setText("");
        tbxuser.setText("");
        tbxpass.setText("");
        tbxuser.requestFocus();
    }
}
