package com.hackusp.klabinusp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import com.hackusp.klabinusp.R;
import com.hackusp.klabinusp.RecyclerItemClickListener;
import com.hackusp.klabinusp.adapter.AdapterOportunidades;
import com.hackusp.klabinusp.model.Oportunidade;

import java.util.ArrayList;
import java.util.List;

public class ListaOportunidadesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Oportunidade> listaOportunidades = new ArrayList<>();
    private AdapterOportunidades adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listaoportunidades);

        recyclerView = findViewById(R.id.recyclerView);

        configuraRecyclerView();
        obtemOportunidades();



    }

    void configuraRecyclerView(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new AdapterOportunidades(listaOportunidades, this);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                List<Oportunidade> listaOportunidadesAtualizada = adapter.getListaOportunidades();
                                Oportunidade oportunidadeSelecionada = listaOportunidadesAtualizada.get(position);

                                Intent i = new Intent(ListaOportunidadesActivity.this, OportunidadeActivity.class);
                                i.putExtra("oportunidade", oportunidadeSelecionada);
                                startActivity(i);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );

    }

    void obtemOportunidades(){
        Oportunidade oportunidade;

        oportunidade = new Oportunidade(
                "Palestra do Monaco",
                "Só batatisse nessa palestra",
                "ICMC",
                "tech",
                "palestra",
                "n tem",
                "07/04/2019",
                "1 km"
        );
        listaOportunidades.add(oportunidade);

        oportunidade = new Oportunidade(
                "IC em razer",
                "Venha fazer ic em jogo de ricos",
                "lasejdgoiasijdg",
                "jogos",
                "ic",
                "laljshga",
                "10/07/2019",
                "3 km"
        );
        listaOportunidades.add(oportunidade);

        oportunidade = new Oportunidade(
                "Estagio na Klabin",
                "Só klabins serão aceitos até o fim de 2040.",
                "Klabin",
                "estagio",
                "estagio",
                "asdgasdgsag",
                "03/06/2020",
                "200 m"
        );
        listaOportunidades.add(oportunidade);

        adapter.notifyDataSetChanged();
    }
}
