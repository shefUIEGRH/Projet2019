package com.example.projet2019.activités;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.projet2019.R;
import com.master.glideimageview.GlideImageView;
import com.squareup.picasso.Picasso;


public class BisActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bis);

        getDetails();
    }

    private void getDetails(){

        Intent intent = getIntent();
            String nom = intent.getStringExtra("nom");
            String types = intent.getStringExtra("type");
            String rarete = intent.getStringExtra("rarete");
            String attaque = intent.getStringExtra("attaque");
            String defense = intent.getStringExtra("defense");
            String couleur = intent.getStringExtra("couleur");
            String imageApi = intent.getStringExtra("image");

            recupDetails(nom, types, rarete, attaque, defense, couleur, imageApi);

    }

    private void recupDetails(String nom, String types, String rarete, String attaque, String defense, String couleur, String imageApi){

        TextView name = findViewById(R.id.nom);
        name.setText(nom);

        TextView rarety = findViewById(R.id.rarete);
        rarety.setText(rarete);

        TextView power = findViewById(R.id.power);
        power.setText(attaque);

        TextView toughness = findViewById(R.id.toughness);
        toughness.setText(defense);

        TextView type = findViewById(R.id.type);
        type.setText(types);

        TextView color = findViewById(R.id.color);
        color.setText(couleur);

        ImageView imageUrl = findViewById(R.id.imagecarte);
        Picasso.get().load(imageApi).into(imageUrl);

    }
}
