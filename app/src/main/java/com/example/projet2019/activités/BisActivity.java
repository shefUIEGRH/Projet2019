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
            //String details = getIntent().getStringExtra("détails");
            String imageApi = intent.getStringExtra("image");

            recupDetails(nom, imageApi);

    }

    private void recupDetails(String nom, String imageApi){

        TextView name = findViewById(R.id.Text2);
        name.setText(nom);

        ImageView imageUrl = findViewById(R.id.View2);
        Picasso.get().load(imageApi).into(imageUrl);

    }
}
