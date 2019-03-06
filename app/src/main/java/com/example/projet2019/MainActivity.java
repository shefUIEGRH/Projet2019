package com.example.projet2019;

import com.example.projet2019.model.Magic;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.List;


public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MainController myController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler_view);

        myController = new MainController(this);
        myController.onStart();

    }

    public void showList(List<Magic> input){

        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);
    }
}
