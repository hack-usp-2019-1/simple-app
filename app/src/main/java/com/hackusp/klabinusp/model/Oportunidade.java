package com.hackusp.klabinusp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Oportunidade implements Serializable {

    @SerializedName("titulo")
    private String titulo;
    @SerializedName("descricao")
    private String descricao;
    @SerializedName("local")
    private String local;
    @SerializedName("assunto")
    private String assunto;
    @SerializedName("tipo")
    private String tipo;
    @SerializedName("link")
    private String link;
    @SerializedName("data")
    private String data;
    @SerializedName("distancia")
    private String distancia;

    public Oportunidade(String titulo, String descricao, String local, String assunto, String tipo, String link, String data, String distancia) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.local = local;
        this.assunto = assunto;
        this.tipo = tipo;
        this.link = link;
        this.data = data;
        this.distancia = distancia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }
}
