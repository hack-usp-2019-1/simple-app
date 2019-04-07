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
import com.hackusp.klabinusp.adapter.AdapterManchetes;
import com.hackusp.klabinusp.model.Oportunidade;

import java.util.ArrayList;
import java.util.List;

public class ManchetesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> listaManchetes = new ArrayList<>();
    private AdapterManchetes adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manchetes);

        getSupportActionBar().setTitle("Preferências");

        recyclerView = findViewById(R.id.recyclerView);

        preencheListaManchetes();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new AdapterManchetes(listaManchetes, this);
        recyclerView.setAdapter(adapter);

    }

    public void btConfirmar(View view){
        Intent i = new Intent(this, ListaOportunidadesActivity.class);
        startActivity(i);
    }

    public void preencheListaManchetes(){
        String s;

        /*s = "Nove autistas pulam de ponta cabeça na Lua";
        listaManchetes.add(s);

        s = "Klabin é o mais novo unicórnio de cu do cinco";
        listaManchetes.add(s);

        s = "HackUSP só aceita klabin, diz Yaya";
        listaManchetes.add(s);

        s = "Bolsonaro sobre sancatão: não aguento mais";
        listaManchetes.add(s);*/

        s = "Espetáculo teatral gratuito acontece na noite de 27 de março na USP São Carlos ";
        listaManchetes.add(s);

        s = "Palestra: ”Desafios reais e emocionais na perspectiva da psicologia analítica”";
        listaManchetes.add(s);

        s = "Estágio no Centro de Tecnologia da Informação de São Carlos (CeTI-SC)";
        listaManchetes.add(s);

        s = "Oportunidades para apoio a empreendedores, ideias e projetos";
        listaManchetes.add(s);

        s = "Oportunidade remota em FinTech líder internacional";
        listaManchetes.add(s);

        s = "Começam as inscrições para o HackUsp 2019 que ocorrerá em São Paulo";
        listaManchetes.add(s);

        s = "Maratona de cursos gratuitos: aprenda a desenvolver jogos no ICMC";
        listaManchetes.add(s);

        s = "Abertas as inscrições para o grupo de extensão NEU São Carlos";
        listaManchetes.add(s);
    }
}
