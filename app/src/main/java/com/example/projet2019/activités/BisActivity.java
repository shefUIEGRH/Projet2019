package com.example.projet2019.activités;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projet2019.R;
import com.squareup.picasso.Picasso;


public class BisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bis);

        getDetails();
    }

    private void getDetails(){

        if(getIntent().hasExtra("nom")&& getIntent().hasExtra("détails")){
            String nom = getIntent().getStringExtra("nom");
            String details = getIntent().getStringExtra("détails");
            String imageApi = getIntent().getStringExtra("image");

            recupDetails(nom, details, imageApi);
        }
    }

    private void recupDetails(String nom, String details, String imageApi){

        TextView name = findViewById(R.id.Text2);
        name.setText(nom);

        ImageView imageUrl = findViewById(R.id.View2);
        Picasso.with(getApplicationContext()).load(imageApi).into(imageUrl);
    }
}
