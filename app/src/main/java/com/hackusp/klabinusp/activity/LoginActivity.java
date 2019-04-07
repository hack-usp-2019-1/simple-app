package com.hackusp.klabinusp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.hackusp.klabinusp.R;

public class LoginActivity extends AppCompatActivity {

    private EditText textoNumeroUSP;
    private EditText textoSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);
        this.getSupportActionBar().hide();


        textoNumeroUSP = findViewById(R.id.textoNumeroUSP);
        textoSenha = findViewById(R.id.textoSenha);

    }

    public void buttonLogar(View view){

        String numerousp = textoNumeroUSP.getText().toString();
        String senha = textoSenha.getText().toString();

        if(numerousp.equals("") || numerousp.isEmpty()){
            Toast.makeText(this, "Preencha um número USP.", Toast.LENGTH_SHORT).show();
        }
        else if(senha.equals("") || senha.isEmpty()){
            Toast.makeText(this, "Preencha a senha.", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i = new Intent(this, ManchetesActivity.class);
            startActivity(i);
        }
    }
}
