package com.hackusp.klabinusp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.hackusp.klabinusp.R;
import com.hackusp.klabinusp.RecyclerItemClickListener;
import com.hackusp.klabinusp.adapter.AdapterOportunidades;
import com.hackusp.klabinusp.model.Oportunidade;

import java.util.ArrayList;
import java.util.List;

public class SalvosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Oportunidade> listaSalvos = new ArrayList<>();
    private AdapterOportunidades adapterOportunidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salvos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){

            if(bundle.containsKey("listaSalvos")){
                listaSalvos = (ArrayList<Oportunidade>) getIntent().getSerializableExtra("listaSalvos");
            }
            else{
                Toast.makeText(this, "Erro ao enviar a lista de oportunidades salvas. Tente novamente.", Toast.LENGTH_SHORT).show();
                finish();
            }
        }

        recyclerView = findViewById(R.id.recyclerView);

        configuraRecyclerView();

    }

    private void configuraRecyclerView(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapterOportunidades = new AdapterOportunidades(listaSalvos, this);
        recyclerView.setAdapter(adapterOportunidades);
    }
}
