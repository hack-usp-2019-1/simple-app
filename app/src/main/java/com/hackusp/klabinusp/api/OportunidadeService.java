package com.hackusp.klabinusp.api;

import com.hackusp.klabinusp.model.Oportunidade;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OportunidadeService {

    @GET("opts")
    Call<List<Oportunidade>> recuperarOportunidades();

}
