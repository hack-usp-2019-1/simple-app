package com.hackusp.klabinusp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hackusp.klabinusp.R;
import com.hackusp.klabinusp.model.Oportunidade;

public class OportunidadeActivity extends AppCompatActivity {

    private Oportunidade oportunidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oportunidade);

        //Recuperar dados do usuário destinatário
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){

            if(bundle.containsKey("oportunidade")){

                oportunidade = (Oportunidade) bundle.getSerializable("oportunidade");



            }
            else{


            }
        }

    }
}
