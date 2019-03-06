package com.example.projet2019;

import com.example.projet2019.model.RestMagic;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestMagicApi {

    @GET("cards")
    Call<RestMagic> ListMagic();
}
