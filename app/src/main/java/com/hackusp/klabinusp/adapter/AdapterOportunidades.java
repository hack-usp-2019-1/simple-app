package com.hackusp.klabinusp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hackusp.klabinusp.R;
import com.hackusp.klabinusp.model.Oportunidade;

import java.util.List;

public class AdapterOportunidades extends RecyclerView.Adapter<AdapterOportunidades.MyViewHolder> {

    private List<Oportunidade> listaOportunidades;
    private Context context;

    public AdapterOportunidades(List listaOportunidades, Context context) {
        this.listaOportunidades = listaOportunidades;
        this.context = context;
    }

    public List<Oportunidade> getListaOportunidades() {
        return listaOportunidades;
    }

    public void setListaOportunidades(List<Oportunidade> listaOportunidades) {
        this.listaOportunidades = listaOportunidades;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_oportunidade, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Oportunidade oportunidade = listaOportunidades.get(i);

        myViewHolder.textDescricaoOportunidade.setText(oportunidade.getDescricao());
        myViewHolder.textTituloOportunidade.setText(oportunidade.getTitulo());
        myViewHolder.textDistanciaOportunidade.setText(oportunidade.getDistancia());
        myViewHolder.textDataOportunidade.setText(oportunidade.getData());

        if(oportunidade.getTipo().equals("ic"))
            myViewHolder.imageOportunidade.setImageResource(R.drawable.pesquisa);
        else if(oportunidade.getTipo().equals("estagio"))
            myViewHolder.imageOportunidade.setImageResource(R.drawable.estagio);
        else if(oportunidade.getTipo().equals("palestra"))
            myViewHolder.imageOportunidade.setImageResource(R.drawable.palestra);
        else
            myViewHolder.imageOportunidade.setImageResource(R.drawable.qporaehessa);

    }

    @Override
    public int getItemCount() {
        return listaOportunidades.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageOportunidade;
        TextView textTituloOportunidade;
        TextView textDescricaoOportunidade;
        TextView textDataOportunidade;
        TextView textDistanciaOportunidade;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageOportunidade = itemView.findViewById(R.id.imageOportunidade);
            textTituloOportunidade = itemView.findViewById(R.id.textTituloOportunidade);
            textDescricaoOportunidade = itemView.findViewById(R.id.textDescricaoOportunidade);
            textDataOportunidade = itemView.findViewById(R.id.textDataOportunidade);
            textDistanciaOportunidade = itemView.findViewById(R.id.textDistanciaOportunidade);

        }
    }

}
