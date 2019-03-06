package com.example.projet2019;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.example.projet2019.model.Magic;
import com.example.projet2019.model.RestMagic;
import android.util.Log;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController {

    private MainActivity myActivity;

    public MainController(MainActivity mainActivity) {
        this.myActivity = mainActivity;
    }

    public void onStart(){

        //Pour ceux qui veulent aller plus loin
        //Singleton
        //Pour ceux qui veulent aller encore plus loin
        // Injection de dépendances

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.magicthegathering.io/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RestMagicApi magicApi = retrofit.create(RestMagicApi.class);

        Call<RestMagic> call = magicApi.ListMagic();
        call.enqueue(new Callback<RestMagic>() {
            @Override
            public void onResponse(Call<RestMagic> call,
                                   Response<RestMagic> response) {
                RestMagic magicResponse = response.body();
                List<Magic> listMagic = magicResponse.getCards();
                myActivity.showList(listMagic);
            }

            @Override
            public void onFailure(Call<RestMagic> call, Throwable t) {
                Log.d("ERROR", "Api Error");
            }
        });
    }

}
