package com.example.projet2019.activités;

import com.example.projet2019.MainController;
import com.example.projet2019.MyAdapter;
import com.example.projet2019.R;
import com.example.projet2019.model.Magic;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;


public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MainController myController;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler_view);

        myController = new MainController(this, getSharedPreferences("key", Context.MODE_PRIVATE));
        myController.onStart();

    }

    private void doYourUpdate(){
        swipeRefreshLayout.setRefreshing(false);
    }

    public void showList(List<Magic> input){

        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        mAdapter = new MyAdapter(input, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Magic item) {
                Intent intent = new Intent(MainActivity.this, BisActivity.class);
                intent.putExtra("nom",item.getName());
                intent.putExtra("type", item.getType());
                intent.putExtra("rarete", item.getRarity());
                intent.putExtra("attaque", item.getPower());
                intent.putExtra("defense", item.getToughness());
                intent.putExtra("image", item.getImage());
                MainActivity.this.startActivity(intent);
            }
        });
        recyclerView.setAdapter(mAdapter);
    }

}

