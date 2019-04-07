package com.hackusp.klabinusp.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.hackusp.klabinusp.R;
import com.hackusp.klabinusp.RecyclerItemClickListener;
import com.hackusp.klabinusp.adapter.AdapterOportunidades;
import com.hackusp.klabinusp.api.OportunidadeService;
import com.hackusp.klabinusp.model.Oportunidade;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaOportunidadesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Oportunidade> listaOportunidades = new ArrayList<>();
    private List<Oportunidade> listaSalvos = new ArrayList<>();
    private AdapterOportunidades adapterOportunidades;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listaoportunidades);

        recyclerView = findViewById(R.id.recyclerView);

        swipe();
        configuraRetrofit();
        configuraRecyclerView();
        //obtemOportunidades();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_oportunidade, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.salvos:
                Intent i = new Intent(ListaOportunidadesActivity.this, SalvosActivity.class);
                i.putExtra("listaSalvos", (Serializable) listaSalvos);
                startActivity(i);
                break;
            case R.id.filtrar:
                Intent in = new Intent(ListaOportunidadesActivity.this, FiltrarActivity.class);
                startActivity(in);
                break;
            case R.id.criarOportunidades:
                Toast.makeText(this, "Criar oport", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void configuraRetrofit(){
        String urlAPI = "http://39ea84c5.ngrok.io/api/v1/";

        //Retrofit
        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(urlAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Recupera valores da API
        recuperaListaRetrofit();
    }

    public void recuperaListaRetrofit(){
        OportunidadeService service = retrofit.create(OportunidadeService.class);
        Call<List<Oportunidade>> call = service.recuperarOportunidades();

        call.enqueue(new Callback<List<Oportunidade>>() {

            @Override
            public void onResponse(Call<List<Oportunidade>> call, Response<List<Oportunidade>> response) {
                if(response.isSuccessful()){
                    listaOportunidades = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<Oportunidade>> call, Throwable t) {

            }
        });
    }

    private void swipe(){

        ItemTouchHelper.Callback itemTouch = new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {

                int dragFlags = ItemTouchHelper.ACTION_STATE_IDLE;
                int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;

                return makeMovementFlags(dragFlags, swipeFlags);
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            //esquerda: não interessado
            //direita: salvar
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                if(i == ItemTouchHelper.START){
                    marcarNaoInteressado(viewHolder);
                }
                else if(i == ItemTouchHelper.END){
                    salvarOportunidade(viewHolder);
                }
            }
        };

        new ItemTouchHelper(itemTouch).attachToRecyclerView(recyclerView);

    }

    private void salvarOportunidade(RecyclerView.ViewHolder viewHolder){

        int position = viewHolder.getAdapterPosition();
        Oportunidade oportunidade = listaOportunidades.get(position);
        listaSalvos.add(oportunidade);

        adapterOportunidades.notifyDataSetChanged();

        Toast.makeText(this, "Oportunidade salva com sucesso!", Toast.LENGTH_SHORT).show();

    }

    private void marcarNaoInteressado(RecyclerView.ViewHolder viewHolder){

        final int pos = viewHolder.getAdapterPosition();
        final Oportunidade oportunidade = listaOportunidades.get(pos);
        listaOportunidades.remove(pos);
        adapterOportunidades.notifyDataSetChanged();

        Snackbar.make(viewHolder.itemView, "Marcado como não interessado.", Snackbar.LENGTH_LONG)
                .setAction("Desfazer", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listaOportunidades.add(pos, oportunidade);
                        adapterOportunidades.notifyDataSetChanged();
                        Toast.makeText(ListaOportunidadesActivity.this, "Desfeito.", Toast.LENGTH_SHORT).show();
                    }
                })
                .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                .show();

    }

    private void configuraRecyclerView(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapterOportunidades = new AdapterOportunidades(listaOportunidades, this);
        recyclerView.setAdapter(adapterOportunidades);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                List<Oportunidade> listaOportunidadesAtualizada = adapterOportunidades.getListaOportunidades();
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

    private void obtemOportunidades(){
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

        adapterOportunidades.notifyDataSetChanged();
    }

}
