package com.hackusp.klabinusp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.hackusp.klabinusp.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterManchetes extends RecyclerView.Adapter<AdapterManchetes.MyViewHolder>{

    private List<String> listManchetes;
    private Context context;

    public AdapterManchetes(List<String> listManchetes, Context context) {
        this.listManchetes = listManchetes;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_manchete, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        String s = listManchetes.get(i);
        myViewHolder.textoManchete.setText(s);

    }

    @Override
    public int getItemCount() {
        return listManchetes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textoManchete;
        CheckBox checkBoxManchete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textoManchete = itemView.findViewById(R.id.textoManchete);
            checkBoxManchete = itemView.findViewById(R.id.checkBox);

        }
    }

}
