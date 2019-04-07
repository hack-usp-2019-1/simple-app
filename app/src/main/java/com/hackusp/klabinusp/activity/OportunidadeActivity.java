package com.hackusp.klabinusp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.hackusp.klabinusp.R;
import com.hackusp.klabinusp.model.Oportunidade;

public class OportunidadeActivity extends AppCompatActivity {

    private Oportunidade oportunidade;
    private TextView textTituloOportunidade, textDescricaoOportunidade, textLocalOportunidade,
            textAssuntoOportunidade, textTipoOportunidade, textLinkOportunidade,
            textDataOportunidade, textDistanciaOportunidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oportunidade);

        textTituloOportunidade = findViewById(R.id.textTituloOportunidade);
        textDescricaoOportunidade = findViewById(R.id.textDescricaoOportunidade);
        textLocalOportunidade = findViewById(R.id.textLocalOportunidade);
        textAssuntoOportunidade = findViewById(R.id.textAssuntoOportunidade);
        textTipoOportunidade = findViewById(R.id.textTipoOportunidade);
        textLinkOportunidade = findViewById(R.id.textLinkOportunidade);
        textDataOportunidade = findViewById(R.id.textDataOportunidade);
        textDistanciaOportunidade = findViewById(R.id.textDistanciaOportunidade);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Recuperar dados do usuário destinatário
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){

            if(bundle.containsKey("oportunidade")){

                oportunidade = (Oportunidade) bundle.getSerializable("oportunidade");
                textTituloOportunidade.setText(oportunidade.getTitulo());
                textDescricaoOportunidade.setText(oportunidade.getDescricao());
                textLocalOportunidade.setText(oportunidade.getLocal());
                textAssuntoOportunidade.setText(oportunidade.getAssunto());
                textTipoOportunidade.setText(oportunidade.getTipo());
                textLinkOportunidade.setText(oportunidade.getLink());
                textDataOportunidade.setText(oportunidade.getData());
                textDistanciaOportunidade.setText(oportunidade.getDistancia());

            }
            else{

                Toast.makeText(this, "Erro ao enviar a oportunidade. Tente novamente.", Toast.LENGTH_SHORT).show();
                finish();

            }
        }

    }
}
