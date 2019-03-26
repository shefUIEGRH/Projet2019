package com.example.projet2019;


import com.example.projet2019.activités.MainActivity;
import com.example.projet2019.interface_magic.RestMagicApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.example.projet2019.model.Magic;
import com.example.projet2019.model.RestMagic;
import com.google.gson.reflect.TypeToken;

import android.content.SharedPreferences;
import android.util.Log;

import java.lang.reflect.Type;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController {

    private MainActivity myActivity;
    private SharedPreferences pref;
    private static final String KEY_ = "key";
    private static MainController ctr = null;

    // constructeur
    public MainController(MainActivity myActivity, SharedPreferences preferences) {
        this.myActivity = myActivity;
        this.pref = preferences;

    }

    public static MainController getInstance(MainActivity myActivity, SharedPreferences pref){

        if(ctr == null){
            ctr = new MainController(myActivity, pref);
        }
        return ctr;
    }

    public void onStart(){
        // si mon cache contient qqch, je vais charger ce qu'il y a dedans pour l'afficher
        if(pref.contains(KEY_)){

            String list = pref.getString(KEY_, null);
            Type listType = new TypeToken<List<Magic>>(){
            }.getType();
            List<Magic> magicList = new Gson().fromJson(list, listType);
            myActivity.showList(magicList);

        }
        else{

            Gson gson = new GsonBuilder().setLenient().create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.magicthegathering.io/v1/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            RestMagicApi magicApi = retrofit.create(RestMagicApi.class);

            Call<RestMagic> call = magicApi.ListMagic();
            call.enqueue(new Callback<RestMagic>() {
                @Override
                public void onResponse(Call<RestMagic> call, Response<RestMagic> response){
                    RestMagic magicResponse = response.body();
                    List<Magic> listMagic = magicResponse.getCards();

                    Gson gson = new Gson();
                    String list = gson.toJson(listMagic);

                    pref.edit().putString(KEY_, list).apply();

                    myActivity.showList(listMagic);

                }

                @Override
                public void onFailure(Call<RestMagic> call, Throwable t) {
                    Log.d("ERROR", "Api Error");
                }
            });

        }







       }

}
